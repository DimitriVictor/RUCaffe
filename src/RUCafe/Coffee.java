package RUCafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {

    private boolean hasCream = false;
    private boolean hasSyrup = false;
    private boolean hasWhippedCream = false;
    private boolean hasMilk = false;
    private boolean hasCaramel = false;

    private String size;
    private int count;
    private double price;

    public Coffee(){
       size = "No Size";
       count = 1;
       price = 0;
    }

    @Override
    double itemPrice() {
        return price;
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof String){
            String additionType = (String)obj;
            if(additionType.equals(Constants.CREAM)){
                hasCream = true;
                return true;
            }else if(additionType.equals(Constants.WHIPPEDCREAM)){
                hasWhippedCream = true;
                return true;
            }else if(additionType.equals(Constants.MILK)){
                hasMilk = true;
                return true;
            }else if(additionType.equals(Constants.SYRUP)){
                hasSyrup = true;
                return true;
            }else if(additionType.equals(Constants.CARAMEL)) {
                hasCaramel = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof String){
            String additionType = (String)obj;
            if(additionType.equals(Constants.CREAM)){
                hasCream = false;
                return true;
            }else if(additionType.equals(Constants.WHIPPEDCREAM)){
                hasWhippedCream = false;
                return true;
            }else if(additionType.equals(Constants.MILK)){
                hasMilk = false;
                return true;
            }else if(additionType.equals(Constants.SYRUP)){
                hasSyrup = false;
                return true;
            }else if(additionType.equals(Constants.CARAMEL)) {
                hasCaramel = false;
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        boolean hasToppings = false;

        String order = "Coffee";

        order += "(" + Double.toString(count) + ") ";

        order += size +"[";

        if(hasCream == true){
            order += Constants.CREAM + ", ";
            hasToppings = true;
        }
        if(hasSyrup == true){
            order += Constants.SYRUP + ", ";
            hasToppings = true;
        }
        if(hasWhippedCream == true){
            order += Constants.WHIPPEDCREAM + ", ";
            hasToppings = true;

        }
        if(hasMilk == true){
            order += Constants.MILK + ", ";
            hasToppings = true;
        }
        if(hasCaramel == true){
            order += Constants.CARAMEL + ", ";
            hasToppings = true;
        }
        if(hasToppings == true){
           order = order.substring(0,order.length()-2);
        }

        order += "]";

        return order;
    }

    public void setCount(int count){
        this.count =  count;
    }

    public void setSize(String size){
        this.size = size;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
