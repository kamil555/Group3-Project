import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bid {

<<<<<<< HEAD
	@Override
	public String toString() {
		return userName + "," + itemID + "," + bidAmount ;
	}

	private String userName;
	private int itemID;
	private double bidAmount;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public double getBidAmount() {
=======
 

	@Override
	public String toString() {
		return "Bid [userName=" + userName + ", itemID=" + itemID + ", bidAmount=" + bidAmount + "]";
	}

	private String userName;
	private int itemID;
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	private double bidAmount;
 
  
    public double getBidAmount() {
>>>>>>> bid-inventory
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

<<<<<<< HEAD
	public Bid(String userName,  int itemID, double bidAmount) {
		this.bidAmount = bidAmount;
		this.userName = userName;
		this.itemID = itemID;

	}
=======
    public Bid(String userName, double bidAmount, int itemID) {
    	super();
    	this.bidAmount = bidAmount;
    	this.userName = userName;
    	this.itemID = itemID;
    	
    }
>>>>>>> bid-inventory
}
