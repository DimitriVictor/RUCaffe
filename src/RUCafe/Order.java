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

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    public int getOrderLength(){
        return this.order.size();
    }

    public double getSubTotal() {
        double subTotal = 0.0;
        for(MenuItem currOrder : this.order){
            subTotal += currOrder.itemPrice();
        }
        return subTotal;
    }

    public ArrayList<String> getOrderList() {
        ArrayList<String> list = new ArrayList<>();
        for(MenuItem currOrder : this.order){
            list.add(currOrder.toString());
        }
        return list;
    }
}
