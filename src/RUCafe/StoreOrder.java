package RUCafe;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class StoreOrder implements  Customizable{
     private ArrayList<Order> storeOrders;

     public StoreOrder(){
         storeOrders = new ArrayList<>();
     }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order order = (Order)obj;
            this.storeOrders.add(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            Order order = (Order)obj;
            this.storeOrders.remove(order);
            return true;
        }
        return false;
    }

    public int getNumOrders(){
       return storeOrders.size();
    }

    public ArrayList<Integer> getNumList(){
         ArrayList<Integer> list = new ArrayList<>();
         for(int i = 0; i < storeOrders.size(); i++){
             list.add(storeOrders.get(i).getOrderNumber());
         }
         return list;
    }
    public Order getOrder(int index){
        return storeOrders.get(index);
    }

    public Double getStoreTotal(){
         Double total = 0.0;
         for(int i = 0; i<storeOrders.size(); i++){
             total += storeOrders.get(i).getSubTotal();
         }
         return total;
    }

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
