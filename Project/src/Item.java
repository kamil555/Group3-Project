/**
 * 
 */

/**
 * @author Stepas
 *
 */
public class Item {
	int itemID;
	String itemName;
	String itemInfo;
	String auctionName;
	double startBid;
	
	
	public double getStartBid() {
		return startBid;
	}
	public void setStartBid(double startBid) {
		this.startBid = startBid;
	}
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName +", Auction Name = "+auctionName+ ", itemInfo=" + itemInfo + "]";
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
	public Item(int itemID, String itemName, String itemInfo) {
		super();
	}


	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	

}
