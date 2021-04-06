package RUCafe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * This class is the controller for the Coffee.fxml view, and it controls the Order Coffee Menu GUI. The user can select the size of the coffee and Addins.
 * Also get the total price of the coffee. It can also add the coffee to the order.
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
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

    /**
     * Initializes the Coffee Menu
     */
    @FXML
    public void initialize() {
        ObservableList<String> sizes = FXCollections.observableArrayList(Constants.SHORT,Constants.TALL, Constants.GRANDE, Constants.VENTE);
        sizeComboBox.setItems(sizes);

        ObservableList<Integer> numbers = FXCollections.observableArrayList(Constants.ONE,Constants.TWO,Constants.THREE);
        countComboBox.setItems(numbers);

    }

    /**
     * This function displays whether the cream addin was selected or deselected.
     * @param event selected cream checkbox was selected or deselected
     */
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

    /**
     * This function displays whether the milk addin was selected or deselected.
     * @param event selected milk checkbox was selected or deselected
     */
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

    /**
     * This function displays whether the syrup addin was selected or deselected.
     * @param event selected syrup checkbox was selected or deselected
     * */
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

    /**
     * This function displays whether the whippedcream addin was selected or deselected.
     * @param event selected whippedcream checkbox was selected or deselected
     * */
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

    /**
     * This function displays whether the caramel addin was selected or deselected.
     * @param event selected caramel checkbox was selected or deselected
     * */
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

    /**
     * This function is called when the size is chosen and sets the combo box to that value
     * @param event selected a size from the count combo box
     * */
    @FXML
    void sizeSelected(ActionEvent event) {

        String selected = sizeComboBox.getSelectionModel().getSelectedItem().toString();
            if(selected.equals(Constants.SHORT)){
                sizePrice = Constants.SHORT_PRICE;
                coffee.setSize(Constants.SHORT);
            }else if(selected.equals(Constants.TALL)){
                sizePrice = Constants.TALL_PRICE;
                coffee.setSize(Constants.TALL);
            }else if(selected.equals(Constants.GRANDE)){
                sizePrice = Constants.GRANDE_PRICE;
                coffee.setSize(Constants.GRANDE);
            }else{
                sizePrice = Constants.VENTE_PRICE;
                coffee.setSize(Constants.VENTE);
            }

        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    /**
     * This function is called when the count is chosen and sets the combo box to that number
     * @param event selected a size from the  count combo box
     * */
    @FXML
    void countSelected(ActionEvent event) {
    //this is alittle ugly*******
        count = (double) Integer.valueOf((Integer) countComboBox.getSelectionModel().getSelectedItem());
        coffee.setCount((int) count);
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }
    /**
     * This function is called when the user clicks the add order button and it adds the item to the shopping list
     * @param event pressed the add order button
     * */
    @FXML
    void addOrderSelected(ActionEvent event){
        if(sizeComboBox.getSelectionModel().getSelectedItem() == null ||
                countComboBox.getSelectionModel().getSelectedItem() == null){
            displayWarning("Oops! You Forgot To Choose A Size Or Amount.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,  "Do You Want To Add This To Your Order?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            double totalPrice = (sizePrice + addInsPrice)*count;
            coffee.setPrice(totalPrice);
            boolean addedSuccessfully = MainMenuController.order.add(coffee);
            if (!addedSuccessfully) {
                displayWarning("Issue with adding to order, please try again");
                return;
            }
            Stage stage = (Stage) sizeComboBox.getScene().getWindow();
            stage.close();
        }else{
            alert.close();
            return;
        }

    }

    /**
     * This function is called and shows the user a warning message
     * @param warningMessage is the message displayed on the warning
     * */
    public void displayWarning(String warningMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Invalid!");
        alert.setContentText(warningMessage);
        alert.showAndWait();
    }

    /**
     * This function displays a confirmation message
     * @param confirmMessage is the message to confirm
     */
    public void displayConfirmation(String confirmMessage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText("Add To Order");
        alert.setContentText(confirmMessage);
        alert.showAndWait();
    }

}
