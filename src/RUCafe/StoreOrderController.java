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
 *
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

    @FXML
    public void initialize() {
        ObservableList<Integer> orders = FXCollections.observableArrayList(MainMenuController.storeOrder.getNumList());
        chooseStoreOrderComboBox.setItems(orders);
        totalTextField.setText("$0.00");
        listView.setItems(null);
    }

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

    @FXML
    public void chooseStoreOrder(ActionEvent event){
        if(chooseStoreOrderComboBox.getValue() == null){
            totalTextField.setText("$0.00");
            listView.setItems(null);
            return;
        }
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

    @FXML
    public void clickedExportFile(){
        if(MainMenuController.storeOrder.getNumOrders() == 0){
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
