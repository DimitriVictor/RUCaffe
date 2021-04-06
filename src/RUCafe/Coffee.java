package RUCafe;

/**
 * This class is the class that represents the Coffee. It contains different fields such as Addins,Size, and Count
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class Coffee extends MenuItem implements Customizable {

    private boolean hasCream = false;
    private boolean hasSyrup = false;
    private boolean hasWhippedCream = false;
    private boolean hasMilk = false;
    private boolean hasCaramel = false;

    private String size;
    private int count;
    private double price;

    /**
     * Constructor for the Coffee class. It initialized the size, count, and price
     *
     */
    public Coffee(){
       size = "No Size";
       count = 1;
       price = 0;
    }

    /**
     * The function will return the price of the coffee created
     * @return coffee price
     */
    @Override
    double itemPrice() {
        return price;
    }

    /**
     * This function adds an Addin to the coffee order
     * @param obj to be added
     * @return returns true whether  the add was sucessful and false otherwise
     */
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

    /**
     * This function removes an Addin from the coffee order
     * @param obj to be removed
     * @return return true if the obj was removed and false otherwise
     */
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

    /**
     * This functions creates and returns the string representation of a coffee
     * @return the string representation of a Coffee ordered
     */
    @Override
    public String toString(){
        boolean hasToppings = false;

        String order = "Coffee";

        order += "(" + Integer.toString((int)count) + ") ";

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

    /**
     * This function sets the number of coffees the user wants
     * @param count sets the amount of coffees that the user wants to order.
     */
    public void setCount(int count){
        this.count = count;
    }

    /**
     * This function sets the size of the coffee ordered
     * @param size is the size of the coffe ordered
     */
    public void setSize(String size){
        this.size = size;
    }

    /**
     * This function sets the price of the coffee ordered based on the size
     * @param price is the numerical price of the size ordered
     */
    public void setPrice(double price){
        this.price = price;
    }
}
