package RUCafe;

/**
 * This class is the superclass of all menu items, such as donuts and coffee. It includes a itemPrice function that all subclasses implement
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
abstract class MenuItem {
    /**
     * This function generates the price of an ordered items
     * @return price of the item
     */
    abstract double itemPrice();
}
