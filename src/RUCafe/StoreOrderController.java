package RUCafe;

import java.util.ArrayList;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StoreOrderController implements Customizable{
    public static ArrayList<Order> storeOrders = new ArrayList<>();

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
        ObservableList<Integer> orders = FXCollections.observableArrayList();
        for(int i = 0; i < storeOrders.size(); i++){
            orders.add(i);
        }

        ObservableList<String> sizes = FXCollections.observableArrayList(Constants.SMALL,Constants.MEDIUM, Constants.LARGE);

        chooseStoreOrderComboBox.setItems(sizes);

        ObservableList<Integer> numbers = FXCollections.observableArrayList(Constants.ONE,Constants.TWO,Constants.THREE);
        chooseStoreOrderComboBox.setItems(numbers);

    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    public void displayWarning(String warningMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Invalid!");
        alert.setContentText(warningMessage);
        alert.showAndWait();
    }



}
