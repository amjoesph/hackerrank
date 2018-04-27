package ha.dynamicprogramming.practice;

public class SquareSubmatrix {
	
	
	
	public static void main(String[] args) {
		
		SquareSubmatrix ss = new SquareSubmatrix();
		
		boolean[][] arr = {
				{false, true, true, true},
				{true, true, true, true},
				{false, true, true, true}
		};
		
//		System.out.println("sub matrix:"+ ss.squareSubmatrix(arr));
		System.out.println("top down matrix:"+ ss.squareSubmatrixTD(arr));
//		System.out.println("bottom up matrix:"+ ss.squareSubmatrixBU(arr));
		
	}
	
	// Top down dynamic programming solution. Cache
	// the values to avoid repeating computations
	public int squareSubmatrixTD(boolean[][] arr) {
		// Initialize cache. Don't need to initialize
		// to -1 because the only cells that will be
		// 0 are ones that are false and we want to
		// skip those ones anyway
		int[][] cache = new int[arr.length][arr[0].length];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j])
					max = Math.max(max, squareSubmatrixTD(arr, i, j, cache));
			}
		}
		
		
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				System.out.print(cache[i][j]+"   ");
			}
			System.out.println("\n");
		}
		
		return max;
	}

	// Overloaded recursive function
	private int squareSubmatrixTD(boolean[][] arr, int i, int j, int[][] cache) {
		if (i == arr.length || j == arr[0].length)
			return 0;
		if (!arr[i][j])
			return 0;

		// If the value is set in the cache return
		// it. Otherwise compute and save to cache
		if (cache[i][j] > 0) {
			System.out.println("from cache:i:"+i+","+j +":j");
			return cache[i][j];
		}
		cache[i][j] = 1
				+ Math.min(Math.min(squareSubmatrixTD(arr, i + 1, j, cache), squareSubmatrixTD(arr, i, j + 1, cache)),
						squareSubmatrixTD(arr, i + 1, j + 1, cache));
		return cache[i][j];
	}
	
	// Brute force solution. From each cell
	// find the biggest square submatrix for which
	// it is the upper left-hand corner
	public int squareSubmatrix(boolean[][] arr) {
		int max = 0;
		// Compute for each cell the biggest subarray
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j])
					max = Math.max(max, squareSubmatrix(arr, i, j));
			}
		}
		return max;
	}

	// Overloaded recursive function
	private int squareSubmatrix(boolean[][] arr, int i, int j) {
		// Base case at bottom or right of the matrix
		if (i == arr.length || j == arr[0].length)
			return 0;
		// If the cell is false then it’s not part
		// of a valid submatrix
		if (!arr[i][j])
			return 0;
		// Find the size of the right, bottom, and
		// bottom right submatrices and add 1 to the
		// minimum of those 3 to get the result
		return 1 + Math.min(Math.min(squareSubmatrix(arr, i + 1, j), squareSubmatrix(arr, i, j + 1)),
				squareSubmatrix(arr, i + 1, j + 1));
	}

}
