public class Item
{
	
	@Override
	public String toString()
	{
		return itemID + "," + auctionName + "," + startBid + "," + itemName
				+ "," + itemInfo;
	}
	
	int itemID;
	double startBid;
	String itemName;
	String itemInfo;
	// Double winBid;
	// String winUser;
	public String auctionName;
	
	public double getStartBid()
	{
		return startBid;
	}
	
	public void setStartBid(double startBid)
	{
		this.startBid = startBid;
	}
	
	public int getItemID()
	{
		return itemID;
	}
	
	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	public String getItemInfo()
	{
		return itemInfo;
	}
	
	public void setItemInfo(String itemInfo)
	{
		this.itemInfo = itemInfo;
	}
	
	public Item(String auctionName, double startBid, String itemName,
			String itemInfo)
	{
		// super();
		this.auctionName = auctionName;
		this.itemID = getID();
		this.startBid = startBid;
		this.itemName = itemName;
		this.itemInfo = itemInfo;
	}
	
	public Item(int itemID, String auctionName, double startBid,
			String itemName, String itemInfo)
	{
		// super();
		this.itemID = itemID;
		this.auctionName = auctionName;
		this.startBid = startBid;
		this.itemName = itemName;
		this.itemInfo = itemInfo;
	}
	
	private int getID()
	{
		Inventory i = new Inventory();
		return i.listofItems.size();
	}
	
}
