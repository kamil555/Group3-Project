

public class Bid {
//   private int bidCount;

 

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

    public Bid(String userName, double bidAmount, int itemID) {
    	super();
    	this.bidAmount = bidAmount;
    	this.userName = userName;
    	this.itemID = itemID;
    	
    }
}
