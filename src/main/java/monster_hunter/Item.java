
package monster_hunter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import monster_hunter.Exceptions.*;


/**
 *
 * @author howan
 */
public class Item {
	private int ItemID;
	private String Name;
	private int Quantity;
	private ArrayList<String> rankings;
	
	public Item() {
		this.Name = "";
		this.Quantity = -1;
		this.rankings = new ArrayList<>();
	}
	
//  ------------------------------------------
//  GETTERS AND SETTERS
//  ------------------------------------------
	/**
	 * Get the id of the item
	 * @return the id of the item
	 */
	public int getID() {
		return ItemID;
	}
	
	/**
	 * Set the value of the ItemID
	 * @param id the ID of the item
	 */
	public void setID(int id){
		this.ItemID = id;
	}
	
//  ------------------------------------------
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
		} catch (NegativeNewQuantity nnq){
			Logger.getLogger(fileHandler.class.getName()).log(Level.SEVERE, nnq.getMessage(), nnq);
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
	 * @param rank The rank you want to check for
	 * @return true if it exists, false if not
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
				"ItemID=" + Util.padRight(Integer.toString(this.ItemID), 5) +
				"Name=" + Util.padRight(this.Name + ",", 35) + 
				"Quantity=" + Util.padRight(Integer.toString(this.Quantity),5) +
				"Rankings=" + Util.padRight(getRankings().toString(), 20) + "}";
				//"Rankings=" + getRankings() + "}";
	}
	
	public ArrayList<Object> export(){
		ArrayList<Object> item = new ArrayList<>();
		item.add(ItemID);
		item.add(Name);
		item.add(Quantity);
		ArrayList<String> ranking = new ArrayList<>();
		for (String i : rankings){
			ranking.add(i);
		}
		item.add(ranking);
		
		return item;
	}
}