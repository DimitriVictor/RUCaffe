package RUCafe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;


import java.util.Observable;

public class CoffeeController {

    Coffee coffee = new Coffee();

    private double sizePrice = 0;
    private double count = 1;
    private double addInsPrice = 0;

    @FXML
    private ComboBox sizeComboBox;

    @FXML
    private ComboBox countComboBox;

    @FXML
    private CheckBox creamCheckbox;

    @FXML
    private CheckBox milkCheckbox;

    @FXML
    private CheckBox syrupCheckbox;

    @FXML
    private CheckBox whippedCreamCheckBox;

    @FXML
    private CheckBox caramelCheckbox;

    @FXML
    private TextArea totalTextArea;

    @FXML
    private Button addOrderButton;

    @FXML
    public void initialize() {
        ObservableList<String> sizes = FXCollections.observableArrayList("Small","Medium", "Large");
        sizeComboBox.setItems(sizes);

        ObservableList<Integer> numbers = FXCollections.observableArrayList(1,2,3);
        countComboBox.setItems(numbers);

    }

    @FXML
    void selectCream(ActionEvent event) {
        String type = "cream";
        if(creamCheckbox.isSelected()){
            addInsPrice += .20;
            coffee.add(type);
        }else{
            addInsPrice -= .20;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectMilk(ActionEvent event) {
        String type = "milk";

        if(milkCheckbox.isSelected()){
            addInsPrice += .20;
            coffee.add(type);
        }else{
            addInsPrice -= .20;
            coffee.remove(type);

        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectSyrup(ActionEvent event) {
        String type = "syrup";
        if(syrupCheckbox.isSelected()){
            addInsPrice += .20;
            coffee.add(type);
        }else{
            addInsPrice -= .20;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectWhippedCream(ActionEvent event) {
        String type = "whippedCream";
        if(whippedCreamCheckBox.isSelected()){
            addInsPrice += .20;
            coffee.add(type);
        }else{
            addInsPrice -= .20;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectCaramel(ActionEvent event) {
        String type = "caramel";
        if(caramelCheckbox.isSelected()){
            addInsPrice += .20;
            coffee.add(type);
        }else{
            addInsPrice -= .20;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void sizeSelected(ActionEvent event) {

        String selected = sizeComboBox.getSelectionModel().getSelectedItem().toString();

            if(selected.equals("Small")){
                sizePrice = 1.99;
            }else if(selected.equals("Medium")){
                sizePrice = 2.49;

            }else{
                sizePrice = 2.99;
            }


        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    @FXML
    void countSelected(ActionEvent event) {
    //this is alittle ugly*******
        count = (double) Integer.valueOf((Integer) countComboBox.getSelectionModel().getSelectedItem());
        coffee.setCount((int) count);
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    @FXML
    void addOrderSelected(ActionEvent event){


    }


}
