package RUCafe;

import javafx.event.ActionEvent;

/**
 * Controller class for the main menu view of the application. From the main menu, the user can order donuts, order coffee, view their current order, and view all the store orders
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class MainMenuController {
    private Order order; //May need to be static
    //WILL EVENTUALLY NEED TO CREATED VARIABLE FOR STORE ORDER: NEED TO MAKE CLASS FOR STORE ORDER
    private int orderNum = 0;
    private boolean orderExist = false;

    /**
     * This function opens the window that is dedicated to ordering donuts
     * @param actionEvent the button is pressed
     */
    public void openOrderDonuts(ActionEvent actionEvent) {

    }

    /**
     * This function opens the window that is dedicated to ordering coffee
     * @param actionEvent the button is pressed
     */
    public void openOrderCoffee(ActionEvent actionEvent) {

    }

    /**
     * This function opens the window that is dedicated to viewing the current order
     * @param actionEvent the button is pressed
     */
    public void openViewOrder(ActionEvent actionEvent) {

    }

    /**
     * This function opens the window that is dedicated to viewing the store orders
     * @param actionEvent the button is pressed
     */
    public void openViewStoreOrder(ActionEvent actionEvent) {

    }
}
