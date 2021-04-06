package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ViewOrder {

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
     * Initializes the Donut Menu GUI
     */
    public void initialize() {
        ObservableList<String> orders = FXCollections.observableArrayList(MainMenuController.order.getOrderList());
        this.ordersList.setItems(orders);
        updatePrices();
    }

    private void updatePrices() {

    }

    public void removeSelectedItem(ActionEvent actionEvent) {

    }

    public void placeOrder(ActionEvent actionEvent) {

    }
}
