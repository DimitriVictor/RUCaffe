package RUCafe;

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
}
