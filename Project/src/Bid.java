

public class Bid {
	
	
	public Bid(User u,Item i,double money){
		this.bidName = u.username;
		this.bidAmount = money;
		if(i.getStartBid() >= bidAmount){
			
		}
	}
//   private int bidCount;

    @Override
	public String toString() {
		return "Bid [bidName=" + bidName + ", bidAmount=" + bidAmount + "]";
	}

	private String bidName;
	private double bidAmount;
//  public Bid next; 
  
    public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getBidName() {
		return bidName;
	}

	public void setBidName(String bidName) {
		this.bidName = bidName;
	}

    public Bid(String bidName, double bidAmount) {
    	super();
    	this.bidAmount = bidAmount;
    	this.bidName = bidName;
    }
}
