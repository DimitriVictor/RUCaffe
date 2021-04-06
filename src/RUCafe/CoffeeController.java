package RUCafe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


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
        ObservableList<String> sizes = FXCollections.observableArrayList(Constants.SMALL,Constants.MEDIUM, Constants.LARGE);
        sizeComboBox.setItems(sizes);

        ObservableList<Integer> numbers = FXCollections.observableArrayList(Constants.ONE,Constants.TWO,Constants.THREE);
        countComboBox.setItems(numbers);

    }

    @FXML
    void selectCream(ActionEvent event) {
        String type = Constants.CREAM;
        if(creamCheckbox.isSelected()){
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        }else{
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectMilk(ActionEvent event) {
        String type = Constants.MILK;

        if(milkCheckbox.isSelected()){
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        }else{
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);

        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectSyrup(ActionEvent event) {
        String type = Constants.SYRUP;
        if(syrupCheckbox.isSelected()){
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        }else{
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectWhippedCream(ActionEvent event) {
        String type = Constants.WHIPPEDCREAM;
        if(whippedCreamCheckBox.isSelected()){
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        }else{
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void selectCaramel(ActionEvent event) {
        String type = Constants.CARAMEL;
        if(caramelCheckbox.isSelected()){
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        }else{
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }

    @FXML
    void sizeSelected(ActionEvent event) {

        String selected = sizeComboBox.getSelectionModel().getSelectedItem().toString();
            if(selected.equals(Constants.SMALL)){
                sizePrice = Constants.SMALL_PRICE;
                coffee.setSize(Constants.SMALL);
            }else if(selected.equals(Constants.MEDIUM)){
                sizePrice = Constants.MEDIUM_PRICE;
                coffee.setSize(Constants.MEDIUM);
            }else{
                sizePrice = Constants.LARGE_PRICE;
                coffee.setSize(Constants.LARGE);
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

        if(sizeComboBox.getSelectionModel().getSelectedItem() == null ||
                countComboBox.getSelectionModel().getSelectedItem() == null){
            displayWarning("Oops! You Forgot To Choose A Size Or Amount.");
            return;
        }

        displayConfirmation(" Are You Sure You Want To Add The Coffee?");

        boolean addedSuccessfully = MainMenuController.order.add(coffee);
        if (!addedSuccessfully) {
            displayWarning("Issue with adding to order, please try again");
            return;
        }

    }

    public void displayWarning(String warningMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Invalid!");
        alert.setContentText(warningMessage);
        alert.showAndWait();
    }

    public void displayConfirmation(String confirmMessage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText("Add To Order");
        alert.setContentText(confirmMessage);
        alert.showAndWait();
    }

}
