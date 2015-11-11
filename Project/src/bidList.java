import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class bidList {
	
	HashMap<Integer, LinkedList<Bid>> itemBidList= new HashMap<Integer, LinkedList<Bid>>();
	LinkedList<Bid> bidlist = new LinkedList<Bid>();
	
	
	
	public void addBid(int itemNum, Bid bid, Item item) {
		if( itemBidList.isEmpty() == true && bid.getBidAmount() >= item.startBid) {
			itemBidList.put(itemNum, bidlist);
			bidlist.add(bid);
		}
	}
	
	
//	static ArrayList<Bid> bid = new ArrayList<Bid>(); 
//	
//	
//	private void addBid(String bidName, double bidAmount) {
//		
//		
//		if(bid.size() == 0) { //start bid
//			bid.add(new Bid(bidName, bidAmount));
//		} 
//		else { 
//			Bid b = (Bid)bid.get(bid.size());
//			if(b.getBidAmount() < bidAmount) { //if the new bid Amount lager than last Amount
//				bid.add(new Bid(bidName, bidAmount)); // then add to list
//			} else { 
//				System.out.println("invalid amount");// else 
//			}
//		}
//	}
	
	
//	public static void main(String[] args) { // test
//		
//	}

}


