
package monster_hunter;

import java.util.ArrayList;
import java.util.HashMap;
import monster_hunter.Exceptions.*;


/**
 *
 * @author howan
 */
public class Item {
	private String Name;
	private int Quantity;
	private ArrayList<String> rankings;
	
	public Item() {
		this.Name = "";
		this.Quantity = -1;
		this.rankings = new ArrayList<String>();
	}
	
//  ------------------------------------------
//  GETTERS AND SETTERS
//  ------------------------------------------
	/**
	 * Get the value of NAME
	 * @return the value of NAME
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * Set the value of Name
	 * @param name Name of the item
	 */
	public void setName(String name){
		this.Name = name;
	}
	
//  ------------------------------------------
//  ------------------------------------------
	
	/**
	 * Get the value of quantity
	 * @return the value of quantity
	 */
	public int getQuantity() {
		return Quantity;
	}

	/**
	 * Set the value of quantity
	 * @param quantity new value of quantity
	 */
	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}
	
	 /**
	 * Set the value of quantity based on the difference between current and new
	 * @param diff the difference of quantity
	 * @param isMinus the sign of diff. is the diff a plus, or minus
	 */
	public void setQuantityDiff(int diff, boolean isMinus){
		if (!isMinus){
			this.Quantity += diff;
			return;
		}
		try{
			if (this.Quantity - diff < 0){
				throw new NegativeNewQuantity(this.Quantity + " - " + diff + 
						" is less than zero. Please fix the quantity differece.");
			}
		} catch (NegativeNewQuantity negative){
			
		}
	}
	
//  ------------------------------------------
//  ------------------------------------------
	
	/**
	 * Get the Rankings ArrayList
	 * @return the ArrayList
	 */	
	public ArrayList<String> getRankings() {
		return rankings;
	}
	
	/**
	 * Set the value of Rankings
	 * @param rank the difference of quantity
	 */
	public void setRankings(String rank) {
		this.rankings.add(rank);
	}
	
	/**
	 * Checks to see if the rank exists in the ArrayList
	 * @return true if it exists, false if not
`	 * @param rank does this rank exist in the ArrayList
	 */
	public boolean hasRanking(String rank){
		for (String i : rankings){
			if (i.equals(rank)){
				return true;
			}
		}
		return false;
	}
	
//  ------------------------------------------
//  ------------------------------------------
	
	@Override
	public String toString() {
		return  "Item{" + 
				"Name=" + Util.padRight(this.Name + ",", 15) + 
				"Quantity=" + this.Quantity + "   " +
				"Rankings=" + Util.padRight(getRankings().toString(), 20) + "}";
				//"Rankings=" + getRankings() + "}";
	}
	
	public ArrayList<String> export(){
		ArrayList<String> item = new ArrayList<String>();
		item.add(Name);
		item.add(Integer.toString(Quantity));
		for (String i : rankings){
			item.add(i);
		}
		
		return item;
	}
	
	
}
