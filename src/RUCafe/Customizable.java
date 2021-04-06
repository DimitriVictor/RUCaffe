package RUCafe;

/**
 * This interface to allows the Coffee objects to add and remove Add-Ins, teh Order objects to add and remove MenuItems(donut and coffee),
 * and the StoreOrder objects to add and remove Orders
 * @author Padmank Ambadipudi
 */
public interface Customizable {
    /**
     * This function adds an object to a list
     * @param obj to be added
     * @return true if the item was added successfully, false otherwise
     */
    boolean add(Object obj);

    /**
     * This function removes an object to a list
     * @param obj to be removed
     * @return true if the item was removed successfully, false otherwise
     */
    boolean remove(Object obj);
}
