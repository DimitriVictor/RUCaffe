package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class DonutController {

    public ComboBox donutTypeSelect;
    public ListView donutFlavors;
    public ListView donutOrders;
    public TextField quantityTextField;

    /**
     * Initializes the Donut Menu GUI
     */
    public void initialize() {
        ObservableList<String> donutTypes = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Holes");
        donutTypeSelect.setItems(donutTypes);

        quantityTextField.setText("1");
        //setSubtotalText();
    }

    public void setDonutFlavors(ActionEvent actionEvent) {
        if (donutTypeSelect.getValue() == null) {
            donutFlavors.setItems(null);
        } else if (donutTypeSelect.getValue().toString().equals("Yeast Donut")) {
            ObservableList<String> yeastTypes = FXCollections.observableArrayList("Glazed", "Sugar", "Blueberry Filled");
            donutFlavors.setItems(yeastTypes);
        } else if (donutTypeSelect.getValue().toString().equals("Cake Donut")) {
            ObservableList<String> cakeTypes = FXCollections.observableArrayList("Chocolate");
            donutFlavors.setItems(cakeTypes);
        } else if (donutTypeSelect.getValue().toString().equals("Donut Holes")) {
            ObservableList<String> holeTypes = FXCollections.observableArrayList("Strawberry");
            donutFlavors.setItems(holeTypes);
        }
    }

    public void increment(ActionEvent actionEvent) {
        int currQuantity = Integer.parseInt(quantityTextField.getText());
        quantityTextField.setText(String.valueOf(++currQuantity));
    }

    public void decrement(ActionEvent actionEvent) {
        int currQuantity = Integer.parseInt(quantityTextField.getText());
        if(currQuantity == 1){
            displayWarning("You cannot order a quantity of an item less than 1!");
        }
        else{
            quantityTextField.setText(String.valueOf(--currQuantity));
        }
    }

    public void displayWarning(String warningMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        //alert.setHeaderText("Invalid Command Entered");
        alert.setContentText(warningMessage);
        alert.showAndWait();
    }
}
