
public class Item {
<<<<<<< HEAD
	
	@Override
	public String toString() {
		return itemID + "," + startBid + "," + itemName + "," + itemInfo;
	}
	
=======
	@Override
	public String toString() {
		
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemInfo=" + itemInfo + "]";
	}
>>>>>>> bid-inventory
	int itemID;
	double startBid;
	String itemName;
	String itemInfo;
<<<<<<< HEAD
//	Double winBid;
//	String winUser;
	public String auctionName;
	
=======
>>>>>>> bid-inventory
	public double getStartBid() {
		return startBid;
	}
	public void setStartBid(double startBid) {
		this.startBid = startBid;
	}
<<<<<<< HEAD
=======
	
	
>>>>>>> bid-inventory
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
<<<<<<< HEAD
	public Item(int itemID, double startBid, String itemName, String itemInfo) {
		super();
		this.itemID = getID();
		this.startBid = startBid;
		this.itemName = itemName;
		this.itemInfo =itemInfo;
	}
//	public Item() {
//		super();
//		this.itemID = itemID;
//		this.startBid = startBid;
//		this.itemName = itemName;
//		this.itemInfo =itemInfo;
//	}
	

	private int getID(){
		Inventory i = new Inventory();
		return i.listofItems.size();
=======
	public Item(int itemID, String itemName, String itemInfo) {
		super();
>>>>>>> bid-inventory
	}
	

}
