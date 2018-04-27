package ha.dynamicprogramming.practice;

public class CoinChange {
	
	int coins[] = {10, 6, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CoinChange  cc = new CoinChange();
		
		System.out.println("top down:" + cc.makeChange(19));
		System.out.println("bottom up:" + cc.makeChangeBU(19));
		
	}

	// Bottom up dynamic programming solution.
	// Iteratively compute number of coins for
	// larger and larger amounts of change
	public int makeChangeBU(int c) {
		int[] cache = new int[c + 1];
		for (int i = 1; i <= c; i++) {
			int minCoins = Integer.MAX_VALUE;

			// Try removing each coin from the total
			// and see which requires the fewest
			// extra coins
			for (int coin : coins) {
				if (i - coin >= 0) {
					int currCoins = cache[i - coin] + 1;
					if (currCoins < minCoins) {
						minCoins = currCoins;
					}
				}
			}
			cache[i] = minCoins;
		}

		return cache[c];
	}

	//TOP down approach
	public int makeChange(int c) {
		// Initialize cache with values as -1
		int[] cache = new int[c + 1];
		for (int i = 1; i < c + 1; i++)
			cache[i] = -1;
		return makeChange(c, cache);
	}

	// Overloaded recursive function
	private int makeChange(int c, int[] cache) {
		// Return the value if it’s in the cache
		if (cache[c] >= 0)
			return cache[c];

		int minCoins = Integer.MAX_VALUE;

		// Find the best coin
		for (int coin : coins) {
			if (c - coin >= 0) {
				int currMinCoins = makeChange(c - coin, cache);
				if (currMinCoins < minCoins)
					minCoins = currMinCoins;
			}
		}

		// Save the value into the cache
		cache[c] = minCoins + 1;
		return cache[c];
	}
	
}
