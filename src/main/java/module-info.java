module com.github.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.calculator to javafx.fxml;
    exports com.github.calculator;
}