package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class is the controller for the ViewOrder.fxml view. The user can review
 * the order, remove a selected item and place the order.
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class ViewOrderController {

    @FXML
    private ListView ordersList;
    @FXML
    private TextField subTotalTextField;
    @FXML
    private TextField salesTaxTextField;
    @FXML
    private TextField totalTextField;
    @FXML
    private Button removeBtn;
    @FXML
    private Button placeOrderBtn;

    /**
     * Initializes the View Order menu
     */
    public void initialize() {
        ObservableList<String> orders = FXCollections.observableArrayList(MainMenuController.order.getOrderList());
        this.ordersList.setItems(orders);
        updatePrices();
    }

    /**
     * This function generates the values for subtotal, tax, and total price in a properly formatted manner
     */
    private void updatePrices() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);

        double subTotal = MainMenuController.order.getSubTotal();
        double tax = Constants.SALES_TAX * subTotal;
        double total = subTotal + tax;

        String formattedSubTotal = df.format(subTotal);
        String formattedTax = df.format(tax);
        String formattedTotal = df.format(total);

        subTotalTextField.setText("$" + formattedSubTotal);
        salesTaxTextField.setText("$" + formattedTax);
        totalTextField.setText("$" + formattedTotal);
    }

    /**
     * This function removes a selected order from the order list. The user is asked to confirm if they want to remove the selected item
     * and given a message if there was a problem removing a selected item
     * @param actionEvent remove selected item button is pressed
     */
    public void removeSelectedItem(ActionEvent actionEvent) {
        if (this.ordersList.getSelectionModel().getSelectedItem() == null) {
            displayWarning("You did not select item to remove");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,  "Are You Sure You Want To Remove Order?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            int index = ordersList.getSelectionModel().getSelectedIndex();
            boolean isRemoved = MainMenuController.order.remove(MainMenuController.order.getItem(index));
            if(!isRemoved){
                displayWarning("Could Not Remove Selected Item!");
                return;
            }
            ObservableList<String> orders = FXCollections.observableArrayList(MainMenuController.order.getOrderList());
            this.ordersList.setItems(orders);
            updatePrices();
        }
        else {
            alert.close();
            return;
        }
    }

    /**
     * This function displays and alert with a custom message if the user has done something invalid
     * @param s message to be displayed to the user
     */
    private void displayWarning(String s) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Invalid Command Entered!");
        alert.setContentText(s);
        alert.showAndWait();
    }

    /**
     * This function places the order by adding it to the list of store orders
     * @param actionEvent place order button is pressed
     */
    public void placeOrder(ActionEvent actionEvent) {
        if(MainMenuController.order.getOrderLength() == 0){
            displayWarning("You Cannot Place Order Since You Have No Orders!");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure You Want To Place This Order?", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            boolean addedSuccessfully = MainMenuController.storeOrder.add(MainMenuController.order);
            if (!addedSuccessfully) {
                displayWarning("Issue with adding to order, please try again");
                return;
            }
            MainMenuController.orderExist = false;
            Stage stage = (Stage) removeBtn.getScene().getWindow();
            stage.close();
        }
        else{
            alert.close();
            return;
        }
    }
}
