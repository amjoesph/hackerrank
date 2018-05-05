package ha.goldman.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProfitSum {
	
	
	/**
	 * 
	 * @param ar
	 */
	public static void main(String ar[]) {
		
		int[] cost = {9, 3, 10, 8, 14, 4, 8, 11, 9, 25};
		
		PriorityQueue<MaxPrice> maxQueue = new PriorityQueue<MaxPrice>( new Comparator<MaxPrice>(){
			public int compare(MaxPrice a, MaxPrice b) {
				return b.price.compareTo(a.price);
			}
		});
		
		buildMaxPriceQueue(cost, maxQueue);
		
		System.out.println(maxQueue.toString());
			
		System.out.println("ANS:" + findProfitPair(cost, maxQueue));
		
	}
	
	private static void buildMaxPriceQueue(int[] cost, PriorityQueue<MaxPrice> maxQueue) {
		
		for(int j=1; j<cost.length; j++) {
			MaxPrice mp = new MaxPrice(Integer.valueOf(cost[j]), j);
			maxQueue.add(mp);
		}
		
	}
	
	
	private static String findProfitPair (int[] cost, PriorityQueue<MaxPrice> maxQueue) {
		
		int buyPrice = cost[0];
		int sellPrice = cost[0];
		MaxPrice mp = maxQueue.poll();
		int profit = 0;
		int highPrice = 0;
		int highPriceIndex = 0;
		
		if (mp != null) {
			highPrice = mp.price.intValue();
			highPriceIndex = mp.index;
			profit = highPrice - sellPrice;
		}
		
		
		for (int i=1; i<cost.length; i++) {
			if (i > highPriceIndex) {
				while (mp == null || i > highPriceIndex) {
					mp = maxQueue.poll();
					if (mp != null) {
						highPrice = mp.price.intValue();
						highPriceIndex = mp.index;
					}
				}
			} 
			if (cost[highPriceIndex] - cost[i] > profit) {
				buyPrice =  cost[i];
				sellPrice = cost[highPriceIndex];
				profit = cost[highPriceIndex] - cost[i];
			}
		}
		return "Buy price:" + buyPrice + ":sellPrice:" + sellPrice + ":profit:" + profit;
	}
	
	static class MaxPrice {
		Integer price;
		int index;
		
		MaxPrice(Integer price, int index) {
			this.price = price;
			this.index = index;
		}
		
		public String toString(){
			return "Price:" + price + ":index:" + index;
		}
	}

}
