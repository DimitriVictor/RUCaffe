package RUCafe;

import java.awt.*;

public class Donut extends MenuItem {
    private String donutType;
    private String donutFlavor;
    private int quantity;

    public Donut(String donutType, String donutFlavor, int quantity){
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.quantity = quantity;
    }

    @Override
    double itemPrice() {
        double price = 0.0;
        if(this.getDonutType().equals(Constants.YEAST_DONUT)){
            price = Constants.YEAST_DONUT_PRICE * this.getQuantity();
        } else if(this.getDonutType().equals(Constants.CAKE_DONUT)){
            price = Constants.CAKE_DONUT_PRICE * this.getQuantity();
        } else {
            price = Constants.DONUT_HOLE_PRICE * this.getQuantity();
        }
        return price;
    }

    /**
     * Getter method for the donut type
     * @return the type of donut
     */
    public String getDonutType(){
        return this.donutType;
    }

    /**
     * Getter method for the donut type
     * @return the flavor of donut
     */
    public String getDonutFlavor(){
        return this.donutFlavor;
    }

    /**
     * Getter method for the amount a certain donut
     * @return the amount of a donut
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Setter method to set the quantity of a donut
     * @param n the number of donuts
     */
    public void setQuantity(int n) {
        this.quantity = n;
    }

    @Override
    public String toString(){
        return this.getDonutType() + ": " + this.getDonutFlavor() + "(" + this.getQuantity() + ")";
    }
}
