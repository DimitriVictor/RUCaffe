package RUCafe;

import java.util.ArrayList;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * This is the controller class for the Store Order menu. It allows users to delete orders and export orders into a text file
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class StoreOrderController {

    @FXML
    private ListView listView;

    @FXML
    private Button exportOrderButton;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private TextField totalTextField;

    @FXML
    private ComboBox chooseStoreOrderComboBox;

    /**
     * This function initializes the GUI elements in the store order menu
     */
    @FXML
    public void initialize() {
        ObservableList<Integer> orders = FXCollections.observableArrayList(MainMenuController.storeOrder.getNumList());
        chooseStoreOrderComboBox.setItems(orders);
        totalTextField.setText("$0.00");
        listView.setItems(null);
    }

    /**
     * This function cancels a specified order and removes it from the list of store orders
     * @param event cancel order button is selected
     */
    @FXML
    public void cancelOrder(ActionEvent event){
        if(chooseStoreOrderComboBox.getSelectionModel().getSelectedItem() == null){
            displayWarning("You Must Select An Order To Cancel An Order!");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,  "Are You Sure You Want To Cancel Order?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES) {
            int index = chooseStoreOrderComboBox.getSelectionModel().getSelectedIndex();
            boolean canceledSuccessfully = MainMenuController.storeOrder.remove(MainMenuController.storeOrder.getOrder(index));
            if (!canceledSuccessfully) {
                displayWarning("Issue with canceling order, please try again");
                return;
            }
            initialize();
        }else {
            alert.close();
            return;
        }
    }

    /**
     * This function displays corresponding orders based on the order number selected in the drop down menu
     * @param event The user selects an order number from the drop down menu
     */
    @FXML
    public void chooseStoreOrder(ActionEvent event){
        if(chooseStoreOrderComboBox.getValue() == null){
            totalTextField.setText(Constants.zeroDollars);
            listView.setItems(null);
            return;
        }
        int index = chooseStoreOrderComboBox.getSelectionModel().getSelectedIndex();
        Order order = MainMenuController.storeOrder.getOrder(index);

        totalTextField.setText("$" + String.format("%.2f", order.getSubTotal()));
        ObservableList<String> orders = FXCollections.observableArrayList(order.getOrderList());
        listView.setItems(orders);
    }

    /**
     * This function displays an alert to the user if they have done something invalid
     * @param warningMessage message to be displayed to the user
     */
    public void displayWarning(String warningMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Invalid!");
        alert.setContentText(warningMessage);
        alert.showAndWait();
    }

    /**
     * This function exports the store order information to a text file
     * @param event the user clicks the export file button
     */
    @FXML
    public void clickedExportFile(ActionEvent event){
        if(MainMenuController.storeOrder.getNumOrders() == Constants.NO_ORDERS){
            displayWarning("There Are No Orders To Export");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,  "Are You Sure You Want To Export?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES) {
            Stage stage = new Stage();
            boolean exportSuccessfully = MainMenuController.storeOrder.exportFile(stage);
            if (!exportSuccessfully) {
                displayWarning("Issue with exporting, please try again");
                return;
            }
        }else {
            alert.close();
            return;
        }

    }
}
