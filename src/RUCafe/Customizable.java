package RUCafe;

/**
 * This interface to allows the Coffee objects to add and remove Add-Ins, teh Order objects to add and remove MenuItems(donut and coffee),
 * and the StoreOrder objects to add and remove Orders
 * @author Padmank Ambadipudi
 */
public interface Customizable {
    boolean add(Object obj);
    boolean remove(Object obj);
}
