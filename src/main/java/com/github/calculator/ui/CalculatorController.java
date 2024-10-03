package com.github.calculator.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CalculatorController implements Initializable {
    @FXML
    private GridPane inputGrid;
    @FXML
    private Label outputLabel;

    public CalculatorController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListenersToNumberButtons(retrieveButtonList());
    }

    private ArrayList<Button> retrieveButtonList() {
        ArrayList<Button> buttonList = new ArrayList<>();
        for (Node currNode : inputGrid.getChildren()) {
            if (currNode instanceof Button) {
                buttonList.add((Button) currNode);
            }
        }
        return buttonList;
    }

    private void addListenersToNumberButtons(ArrayList<Button> buttonList) {
        for (int i = 0; i < buttonList.size(); i++) {
            Button currButton = buttonList.get(i);
            String currentButtonValue = currButton.getText();
            if (Character.isDigit(currentButtonValue.charAt(0))) {
                currButton.setOnAction(event -> {
                    StringBuilder sb = new StringBuilder(outputLabel.getText());
                    sb.append(currentButtonValue);
                    outputLabel.setText(sb.toString());
                });
                buttonList.remove(i);
                i--;
            }

        }
    }

}
