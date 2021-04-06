package RUCafe;

import java.util.ArrayList;

/**
 * This class handles all the current orders and keeps track of them in a list format. It implements the Customizable interface
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class Order implements Customizable{
    private ArrayList<MenuItem> order;
    private int orderNumber;

    /**
     * Constructor for the Order object
     * @param orderNumber that order is in the list of all orders
     */
    public Order(int orderNumber){
        this.order = new ArrayList<>();
        this.orderNumber = orderNumber;
    }

    /**
     * This function adds an order to the list of orders
     * @param obj to be added, could be donut or coffee
     * @return true if the object was added successfully, false if it was not added successfully
     */
    @Override
    public boolean add(Object obj){
        if(obj instanceof  Donut){
            Donut d = (Donut) obj;
            this.order.add(d);
            return true;
        }else if (obj instanceof Coffee){
            Coffee c = (Coffee) obj;
            this.order.add(c);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This function removes an object from the list of orders. The object can be a donut or a coffee
     * @param obj to be removed
     * @return true if the object was removed successfully, false if it was not removed successfully
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof  Donut){
            Donut d = (Donut) obj;
            this.order.remove(d);
            return true;
        }else if (obj instanceof Coffee){
            Coffee c = (Coffee) obj;
            this.order.remove(c);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This function is a getter function for the length of the current list of orders
     * @return length or order array list
     */
    public int getOrderLength(){
        return this.order.size();
    }

    /**
     * This function gets a specific order in the list of orders
     * @param index where the order is located
     * @return MenuItem object, representing the order that is to be found
     */
    public MenuItem getItem(int index){
        return order.get(index);
    }

    /**
     * This function gets the subtotal of all the items in the list
     * @return numerical form of the subtotal of all the orders
     */
    public double getSubTotal() {
        double subTotal = 0.0;
        for(MenuItem currOrder : this.order){
            subTotal += currOrder.itemPrice();
        }
        return subTotal;
    }

    /**
     * This function generates a list of all the orders
     * @return list of all the orders in their toString representation
     */
    public ArrayList<String> getOrderList() {
        ArrayList<String> list = new ArrayList<>();
        for(MenuItem currOrder : this.order){
            list.add(currOrder.toString());
        }
        return list;
    }

    /**
     * This function is a getter for the order number that the current order is
     * @return order number of the order
     */
    public int getOrderNumber(){
        return orderNumber;
    }

}
