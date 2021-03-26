package omt.tipcalculator;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * TipCalculater app which has a simple UI that helps users to calculate the
 * total amount for their expenses!
 *
 * @author omt
 */
public class TipCalculatorController {

    @FXML
    private Slider slider;
    @FXML
    private Label lblPercentage;
    @FXML
    private Label lblErrorInfo;
    @FXML
    private TextField txtTip;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtTotal;

    /**
     * This will be called when the form is ready to be initialized! We will
     * just do initial setup in this section.
     */
    @FXML
    void initialize() {
        init();
    }

    @FXML
    private void switchToAboutPage() throws IOException {
        String fxmlFileName = "about";
        App.setRoot(fxmlFileName);
    }

    /**
     * When slider value changes we will calculate the tip information.
     *
     * @param event
     */
    @FXML
    void handleMouseDrag(MouseEvent event) {
        calculateTipAndUpdateInfo();
    }

    /**
     * Handle the key event when user enters a new amount
     *
     * @param event
     */
    @FXML
    void handleKeyTyped(KeyEvent event) {
        calculateTipAndUpdateInfo();
    }
    
    /**
     * This exit the application!
     * @param event 
     */
    @FXML
    void handleExit(ActionEvent event) {
        System.out.println("Bye bye now...");
        System.exit(0);
    }

    /**
     * Initialize the UI based on the default values
     */
    private void init() {
        double value = slider.getValue();
        int tipPercentage = (int) value;
        lblPercentage.setText(String.format("%d %%", tipPercentage));
        lblErrorInfo.setVisible(false);
    }

    /**
     * Calculate the tip information as well as the total amount that we need to
     * pay. After that update the UI (View)
     */
    private void calculateTipAndUpdateInfo() {
        try {
            double value = slider.getValue();
            int tipPercentage = (int) value;
            lblPercentage.setText(String.format("%d %%", tipPercentage));
            double amount = Double.parseDouble(txtAmount.getText());
            double tipAmount = tipPercentage * amount / 100.0;
            double totalAmount = amount + tipAmount;
            txtTip.setText(String.format("%.02f", tipAmount));
            txtTotal.setText(String.format("%.02f", totalAmount));
            lblErrorInfo.setVisible(false);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong amount entry! ");
            lblErrorInfo.setVisible(true);
        }
    }
}
