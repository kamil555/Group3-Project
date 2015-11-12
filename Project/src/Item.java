
public class Item {
	
	@Override
	public String toString() {
		return itemID + "," + startBid + "," + itemName + "," + itemInfo;
	}
	int itemID;
	double startBid;
	String itemName;
	String itemInfo;
//	Double winBid;
//	String winUser;
	
	public double getStartBid() {
		return startBid;
	}
	public void setStartBid(double startBid) {
		this.startBid = startBid;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	public Item(int itemID, double startBid, String itemName, String itemInfo) {
		super();
		this.itemID = itemID;
		this.startBid = startBid;
		this.itemName = itemName;
		this.itemInfo =itemInfo;
	}
	

}
