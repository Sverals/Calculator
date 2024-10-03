package com.github.calculator.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    @FXML
    private GridPane inputGrid;
    @FXML
    private Label outputLabel;
    @FXML
    private HBox scrollingHBox;
    @FXML
    private ScrollPane scrollPane;

    public CalculatorController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Button> buttonList = retrieveButtonList();
        addListenersToAllButtons(buttonList);
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

    private void addListenersToAllButtons(ArrayList<Button> buttonList) {
        addListenersToNumberButtons(buttonList);
        addListenersToNonNumberButtons(buttonList);
    }

    private void addListenersToNumberButtons(ArrayList<Button> buttonList) {
        for (Button currButton : buttonList) {
            String currentButtonValue = currButton.getText();
            if (Character.isDigit(currentButtonValue.charAt(0))) {
                currButton.setOnAction(event -> {
                    scrollPane.setHvalue(1.0);

                    StringBuilder sb = new StringBuilder(outputLabel.getText());
                    sb.append(currentButtonValue);
                    outputLabel.setText(sb.toString());
                });
            }

        }
    }
    private void addListenersToNonNumberButtons(ArrayList<Button> buttonList) {
       for (Button currButton : buttonList) {
           addListenersToNonDigitOutputButtons(currButton);
        }
       for (Button currButton : buttonList) {
           addListenersToNonDegitLogicButtons(currButton);
       }
    }

    private void addListenersToNonDigitOutputButtons(Button currentButton) {
        String currentButtonValue = currentButton.getText();
        char buttonChar = currentButtonValue.charAt(0);
        if (currentButtonValue.equals("x²") || buttonChar == 'U' || buttonChar == 'C' || buttonChar == '=') {
            return;
        }
        if (!Character.isDigit(buttonChar)) { //prevents non text buttons being added to output

            currentButton.setOnAction(event -> {
                outputLabel.setText(outputLabel.getText() + currentButtonValue);
            });
        }

    }

    private void addListenersToNonDegitLogicButtons(Button currentButton) {
       String currentButtonValue = currentButton.getText();
       char buttonChar = currentButtonValue.charAt(0);
       switch (buttonChar) {
           case 'U': //Undo Button action
               currentButton.setOnAction(event -> {
                   if (!outputLabel.getText().isEmpty()) {
                       String newText = outputLabel.getText().substring(0, outputLabel.getText().length() - 1);
                       outputLabel.setText(newText);
                   }
               });
               break;
           case 'C': //Clear button action
               currentButton.setOnAction(event -> {
                   outputLabel.setText("");
               });
               break;
           case '=': //Enter button action
               currentButton.setOnAction(event -> {
                   processEnterRequest(outputLabel.getText());
                   outputLabel.setText("");
               });
               break;
           default: break;
       }
       if (currentButtonValue.equals("x²")) { //adds power to output
           currentButton.setOnAction(event -> {
           outputLabel.setText(outputLabel.getText() + "²");
           });
       }
    }

    public void processEnterRequest(String input) {
        //send to calculator
        //receive response to post
    }


}
