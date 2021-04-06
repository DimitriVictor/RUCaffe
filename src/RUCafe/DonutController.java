package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;

public class DonutController {

    @FXML
    private ComboBox donutTypeSelect;
    @FXML
    private ListView donutFlavors;
    @FXML
    private ListView donutOrders;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextArea subtotalTextField;

    private ArrayList<Donut> donutCart;

    /**
     * Initializes the Donut Menu GUI
     */
    public void initialize() {
        ObservableList<String> donutTypes = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Holes");
        donutTypeSelect.setItems(donutTypes);

        donutCart = new ArrayList<>();
        quantityTextField.setText("1");
        //subtotalTextField;
    }

    public void setDonutFlavors(ActionEvent actionEvent) {
        if (donutTypeSelect.getValue() == null) {
            donutFlavors.setItems(null);
        } else if (donutTypeSelect.getValue().toString().equals("Yeast Donut")) {
            ObservableList<String> yeastTypes = FXCollections.observableArrayList("Glazed", "Sugar", "Berry Filled");
            donutFlavors.setItems(yeastTypes);
        } else if (donutTypeSelect.getValue().toString().equals("Cake Donut")) {
            ObservableList<String> cakeTypes = FXCollections.observableArrayList("Chocolate", "Spicy Surprise", "Buttermilk");
            donutFlavors.setItems(cakeTypes);
        } else if (donutTypeSelect.getValue().toString().equals("Donut Holes")) {
            ObservableList<String> holeTypes = FXCollections.observableArrayList("Strawberry", "Powder", "Jelly Filled");
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
        alert.setHeaderText("Invalid Command Entered!");
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

    /**
     * Resets all selections in the Donut Menu GUI
     */
    public void resetDonutMenu() {
        this.donutFlavors.setItems(null);
        this.donutTypeSelect.setValue("");
        this.quantityTextField.setText("1");
    }

    public void addToCart(ActionEvent actionEvent) {
        if(donutTypeSelect.getSelectionModel().getSelectedItem() == null && donutFlavors.getSelectionModel().getSelectedItem() == null){
            displayWarning("You Must Select A Donut Type & Donut Flavor Before Adding To The Cart");
            return;
        }
        if(donutFlavors.getSelectionModel().getSelectedItem() == null){
            displayWarning("You Must Select A Donut Flavor Before Adding To The Cart");
            return;
        }

        String donutType = donutTypeSelect.getSelectionModel().getSelectedItem().toString();
        String donutFlavor = donutFlavors.getSelectionModel().getSelectedItem().toString();
        int quantity = Integer.parseInt(quantityTextField.getText());
        Donut donut = new Donut(donutType, donutFlavor, quantity);

        addDonutToCart(donut, quantity);
        ObservableList<String> itemsInCart = FXCollections.observableArrayList(populateCart());
        donutOrders.setItems(itemsInCart);

        subtotalTextField.setText(getSubtotal());
        //resetDonutMenu();
    }

    public void addDonutToCart(Donut donut, int quantity) {
        for(Donut d : donutCart){
            if(donut.getDonutType().equals(d.getDonutType()) && donut.getDonutFlavor().equals(d.getDonutFlavor())){
                d.setQuantity(d.getQuantity() + quantity);
                return;
            }
        }
        donutCart.add(donut);
    }

    public ArrayList<String> populateCart() {
        ArrayList<String> list = new ArrayList<>();
        for(Donut d : donutCart){
            list.add(d.toString());
        }
        return list;
    }

    public String getSubtotal(){
        double totalPrice = 0.0;
        for(Donut d : donutCart){
            totalPrice += d.itemPrice();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        String subTotal = df.format(totalPrice);
        return subTotal;
    }

    public void removeFromCart(ActionEvent actionEvent) {
        if(donutCart.isEmpty()){
            displayWarning("Your Cart Is Empty, There Is Nothing To Remove");
            return;
        }
        if(donutOrders.getSelectionModel().getSelectedItem() == null){
            displayWarning("You Must Select A Donut To Remove It");
            return;
        }

        donutCart.remove(donutOrders.getSelectionModel().getSelectedIndex());

        ObservableList<String> itemsInCart = FXCollections.observableArrayList(populateCart());
        donutOrders.setItems(itemsInCart);

        subtotalTextField.setText(getSubtotal());
        //resetDonutMenu();
    }

    public void addOrder(ActionEvent actionEvent) {
        if(donutCart.isEmpty()){
            displayWarning("You Must Have Something In Your Cart Before Ordering!");
            return;
        }

        displayConfirmation("Donuts Added to Order!");

        for (Donut toAdd : donutCart) {
            boolean addedSuccessfully = MainMenuController.order.add(toAdd);
            if (!addedSuccessfully) {
                displayWarning("Issue with adding to order, please try again");
                return;
            }
        }
    }
}
