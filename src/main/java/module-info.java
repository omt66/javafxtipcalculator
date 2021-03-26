module omt.tipcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens omt.tipcalculator to javafx.fxml;
    exports omt.tipcalculator;
}
