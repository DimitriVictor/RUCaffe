package RUCafe;

import java.util.ArrayList;

/**
 * This class handles all the current orders and keeps track of them in a list format. It implements the Customizable interface
 * @author Padmank Ambadipudi
 */
public class Order implements Customizable{
    private ArrayList<MenuItem> order;
    private int orderNumber;

    public Order(int orderNumber){
        this.order = new ArrayList<>();
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean add(Object obj){
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    public int getOrderLength(){
        return this.order.size();
    }
}
