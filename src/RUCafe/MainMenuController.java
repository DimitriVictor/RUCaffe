package RUCafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the main menu view of the application. From the main menu, the user can order donuts, order coffee, view their current order, and view all the store orders
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class MainMenuController {
    public static Order order; //May need to be static
    //WILL EVENTUALLY NEED TO CREATED VARIABLE FOR STORE ORDER: NEED TO MAKE CLASS FOR STORE ORDER
    private int orderNum = 0;
    private boolean orderExist = false;
    private Object Constants;

    /**
     * This function opens the window that is dedicated to ordering donuts
     * @param actionEvent the button is pressed
     */
    public void openOrderDonuts(ActionEvent actionEvent) throws IOException {
        createNewOrder();

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
    }

    /**
     * This function opens the window that is dedicated to ordering coffee
     * @param actionEvent the button is pressed
     */
    public void openOrderCoffee(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coffee.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Order Coffee");
        stage.setScene(new Scene(root1));

        stage.setX(350);
        stage.setY(450);

        //After the window is open, make main menu disabled
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * This function opens the window that is dedicated to viewing the current order
     * @param actionEvent the button is pressed
     */
    public void openViewOrder(ActionEvent actionEvent) throws IOException {
        createNewOrder();

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
    }

    /**
     * This function opens the window that is dedicated to viewing the store orders
     * @param actionEvent the button is pressed
     */
    public void openViewStoreOrder(ActionEvent actionEvent) {

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
