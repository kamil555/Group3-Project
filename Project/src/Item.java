
public class Item {
	@Override
	public String toString() {
		
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemInfo=" + itemInfo + "]";
	}
	int itemID;
	String itemName;
	String itemInfo;
	
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
	

}
