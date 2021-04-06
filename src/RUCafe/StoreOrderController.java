package RUCafe;

import java.util.ArrayList;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    @FXML
    public void initialize() {
        if(MainMenuController.storeOrder.getNumOrders() != 0){
            ObservableList<Integer> orders = FXCollections.observableArrayList(MainMenuController.storeOrder.getNumList());
            chooseStoreOrderComboBox.setItems(orders);
        }
    }

    @FXML
    public void chooseStoreOrder(ActionEvent event){
        int index = chooseStoreOrderComboBox.getSelectionModel().getSelectedIndex();
        Order order = MainMenuController.storeOrder.getOrder(index);

        totalTextField.setText("$" + String.format("%.2f", order.getSubTotal()));
        ObservableList<String> orders = FXCollections.observableArrayList(order.getOrderList());
        listView.setItems(orders);
    }

    public void displayWarning(String warningMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Invalid!");
        alert.setContentText(warningMessage);
        alert.showAndWait();
    }

}
