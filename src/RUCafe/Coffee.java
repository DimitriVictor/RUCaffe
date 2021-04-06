package RUCafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {
    ArrayList<String> addInList = new ArrayList<>();

    private boolean hasCream = false;
    private boolean hasSyrup = false;
    private boolean hasWhippedCream = false;
    private boolean hasMilk = false;
    private boolean hasCaramel = false;

    private String size;
    private double count;

    public Coffee(){
       size = "No Size";
       count = 0;
    }

    @Override
    double itemPrice() {
        return 0;
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof String){
            String additionType = (String)obj;
            if(additionType.equals("cream")){
                hasCream = true;
                return true;
            }else if(additionType.equals("whippedCream")){
                hasWhippedCream = true;
                return true;
            }else if(additionType.equals("milk")){
                hasMilk = true;
                return true;
            }else if(additionType.equals("syrup")){
                hasSyrup = true;
                return true;
            }else if(additionType.equals("caramel")) {
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
            if(additionType.equals("cream")){
                hasCream = false;
                return true;
            }else if(additionType.equals("whippedCream")){
                hasWhippedCream = false;
                return true;
            }else if(additionType.equals("milk")){
                hasMilk = false;
                return true;
            }else if(additionType.equals("syrup")){
                hasSyrup = false;
                return true;
            }else if(additionType.equals("caramel")) {
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
            order += "cream, ";
            hasToppings = true;
        }
        if(hasSyrup == true){
            order += "syrup, ";
            hasToppings = true;
        }
        if(hasWhippedCream == true){
            order += "whippedCream, ";
            hasToppings = true;

        }
        if(hasMilk == true){
            order += "milk, ";
            hasToppings = true;
        }
        if(hasCaramel == true){
            order += "caramel, ";
            hasToppings = true;
        }
        if(hasToppings == true){
            order.substring(0,order.length()-2);
        }

        order += "]";

        return order;
    }

    public void setCount(int count){
        this.count =  (double)count;
    }

    public void setSize(String size){
        this.size = size;
    }
}
