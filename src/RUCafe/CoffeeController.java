package RUCafe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.Observable;

public class CoffeeController {

    @FXML
    public ComboBox sizeComboBox;

    @FXML
    public ComboBox countComboBox;


    @FXML
    public void initialize() {
        ObservableList<String> sizes = FXCollections.observableArrayList("Small","Medium", "Large");
        sizeComboBox.setItems(sizes);

        ObservableList<Integer> numbers = FXCollections.observableArrayList(1,2,3);
        countComboBox.setItems(numbers);

    }

}
