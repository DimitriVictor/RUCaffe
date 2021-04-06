package RUCafe;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * This class keeps the list of orders placed by the user and implements the Customizable interface
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class StoreOrder implements  Customizable{
     private ArrayList<Order> storeOrders;

    /**
     * This function is the constructor for the class
     */
    public StoreOrder(){
         storeOrders = new ArrayList<>();
     }

    /**
     * This function adds an order to the list of store orders
     * @param obj to be added
     * @return true if the order was added successfully, false if it was not
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order order = (Order)obj;
            this.storeOrders.add(order);
            return true;
        }
        return false;
    }

    /**
     * This function removes an order to the list of store orders
     * @param obj to be added
     * @return true if the order was removed successfully, false if it was not
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            Order order = (Order)obj;
            this.storeOrders.remove(order);
            return true;
        }
        return false;
    }

    /**
     * This function gets the number of orders currently in the store order list
     * @return length of the store order list
     */
    public int getNumOrders(){
       return storeOrders.size();
    }

    /**
     * This function gets a list of order numbers in the store order list
     * @return list containing all the order numbers
     */
    public ArrayList<Integer> getNumList(){
         ArrayList<Integer> list = new ArrayList<>();
         for(int i = 0; i < storeOrders.size(); i++){
             list.add(storeOrders.get(i).getOrderNumber());
         }
         return list;
    }

    /**
     * This function gets an order based on a specified location in the list
     * @param index where the order is located in the list
     * @return the specified order
     */
    public Order getOrder(int index){
        return storeOrders.get(index);
    }

    /**
     * This function gets the total amount of money that all the orders placed cost
     * @return price of all orders in store orders
     */
    public Double getStoreTotal(){
         Double total = 0.0;
         for(int i = 0; i<storeOrders.size(); i++){
             total += storeOrders.get(i).getSubTotal();
         }
         return total;
    }

    /**
     * This function exports each order in the store order list onto a new file
     * @param stage where the file should be set
     * @return true if the file was exported successfully, false if it was not
     */
    public boolean exportFile(Stage stage){

        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open Target File for the Export");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            Stage st = stage;
            File targetFile = chooser.showSaveDialog(st); //get the reference of the target file
            //write code to write to the file.

            FileWriter fw = new FileWriter(targetFile);

            for(Order order : MainMenuController.storeOrder.storeOrders){
                fw.write("Order Number: " + order.getOrderNumber());
                fw.write("\n");
                fw.write("\n");
                fw.write("Menu Items: ");
                for(int i = 0; i< order.getOrderList().size(); i++){
                    fw.write("\n");
                    fw.write("     "+ i + ")" +order.getOrderList().get(i));
                }
                fw.write("\n");
                fw.write("\n");
                Double subtot = order.getSubTotal();
                fw.write("Subtotal: $" + String.format("%.2f", subtot));
                fw.write("\n");
                fw.write("\n");
            }
            Double total = MainMenuController.storeOrder.getStoreTotal();
            fw.write("Total: " + "$" + String.format("%.2f", total));

            fw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
