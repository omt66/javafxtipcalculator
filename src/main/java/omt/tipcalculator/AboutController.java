package omt.tipcalculator;

import java.io.IOException;
import javafx.fxml.FXML;

public class AboutController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("tipcalculator");
    }
}