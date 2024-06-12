
package monster_hunter;

import java.util.ArrayList;
import java.util.HashMap;
import monster_hunter.Exceptions.*;


/**
 *
 * @author howan
 */
public class Item {
    public final String NAME;
    public int quantity;
    
    public Item(String name, int quantity) {
        this.NAME = name;
        this.quantity = quantity;
    }
    
//  ------------------------------------------
//  GETTERS AND SETTERS
//  ------------------------------------------
    /**
     * Get the value of NAME
     * @return the value of NAME
     */
    public String getNAME() {
        return NAME;
    }
    
    /**
     * Get the value of quantity
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     /**
     * Set the value of quantity based on the difference between current and new
     * @param diff the difference of quantity
     * @param isMinus the sign of diff. is the diff a plus, or minus
     */
    public void setQuantityDiff(int diff, boolean isMinus){
        if (!isMinus){
            this.quantity += diff;
            return;
        }
        try{
            if (this.quantity - diff < 0){
                throw new NegativeNewQuantity(this.quantity + " - " + diff + 
                        " is less than zero. Please fix the quantity differece.");
            }
        } catch (NegativeNewQuantity negative){
            
        }
    }

    @Override
    public String toString() {
        return "Item{" + "NAME=" + NAME + ", " + Util.padRight("", 15 - NAME.length()) + "quantity=" + quantity + '}';
    }
    
    public ArrayList<String> export(){
        ArrayList<String> item = new ArrayList<String>();
        item.add(NAME);
        item.add(Integer.toString(quantity));
        
        return item;
    }
    
    
}
