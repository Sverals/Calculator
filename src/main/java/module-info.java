module com.github.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.calculator to javafx.fxml;
    exports com.github.calculator;

    opens com.github.calculator.ui to javafx.fxml;
    exports com.github.calculator.ui;
}