package RUCafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is the controller class for the MainMenu.fxml view. From the main menu, the user can order donuts, order coffee, view their current order, and view all the store orders
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class MainMenuController {
    public static Order order; //May need to be static

    public static StoreOrder storeOrder = new StoreOrder();

    private int orderNum = 1;
    public static boolean orderExist = false;

    /**
     * This function opens the window that is dedicated to ordering donuts
     * @param actionEvent the button is pressed
     */
    public void openOrderDonuts(ActionEvent actionEvent) {
        createNewOrder();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Donut.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Donuts");
            stage.setResizable(false);
            stage.setScene(new Scene(root1));

            stage.setX(RUCafe.Constants.DONUT_WINDOW_WIDTH);
            stage.setY(RUCafe.Constants.DONUT_WINDOW_HEIGHT);

            //After the window is open, make main menu disabled
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This function opens the window that is dedicated to ordering coffee
     * @param actionEvent the button is pressed
     */
    public void openOrderCoffee(ActionEvent actionEvent) {
        createNewOrder();

    try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coffee.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Order Coffee");
        stage.setScene(new Scene(root1));

        stage.setX(Constants.COFFEE_WINDOW_WIDTH);
        stage.setY(Constants.COFFEE_WINDOW_HEIGHT);

        //After the window is open, make main menu disabled
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }catch (IOException e){
        e.printStackTrace();
    }

    }

    /**
     * This function opens the window that is dedicated to viewing the current order
     * @param actionEvent the button is pressed
     */
    public void openViewOrder(ActionEvent actionEvent) {
        createNewOrder();

      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewOrder.fxml"));
          Parent root1 = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("View Your Order");
          stage.setResizable(false);
          stage.setScene(new Scene(root1));

          stage.setX(RUCafe.Constants.DONUT_WINDOW_WIDTH);
          stage.setY(RUCafe.Constants.DONUT_WINDOW_HEIGHT);

          //After the window is open, make main menu disabled
          stage.initModality(Modality.APPLICATION_MODAL);
          stage.showAndWait();
      }catch (IOException e){
          e.printStackTrace();
      }

    }

    /**
     * This function opens the window that is dedicated to viewing the store orders
     * @param actionEvent the button is pressed
     */
    public void openViewStoreOrder(ActionEvent actionEvent) {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrder.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root1));

            stage.setX(350);
            stage.setY(450);

            //After the window is open, make main menu disabled
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This function creates a new order if one does not already exist each time
     */
    private void createNewOrder() {
        if(!this.orderExist){
            this.order = new Order(this.orderNum);
            this.orderNum++;
            this.orderExist = true;
        }
    }

}
