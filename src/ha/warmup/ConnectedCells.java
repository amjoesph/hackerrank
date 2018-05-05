package ha.warmup;

public class ConnectedCells {
	
	public static int[][] matrix  = {{1, 1, 0, 0},
									 {0, 1, 1, 0},
									 {0, 0, 1, 0},
									 {1, 0, 0, 0}
									};
	
	public static void main(String[] args) {
		System.out.println(getBiggestRegion(matrix));
	}
	
	public static int getBiggestRegion(int[][] matrix) {
		int maxRegion = 0;
		
		for (int row = 0; row < matrix.length; row ++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == 1 ) {
					
					// not working
					int size = getMaxRegion(matrix, row, column);
					
					// works
//					int size = visit(matrix, row, column, matrix.length, matrix[row].length, 0 );
					maxRegion = Math.max(size, maxRegion);
					System.out.println("MaxRegion" + maxRegion + ":row:" + row + ":column:" + column);
				}
			}
		}
		
		return maxRegion;
	}
	
	public static int getMaxRegion(int[][] matrix, int row, int column) {
		
		System.out.println("MATRIX :" + row +":col<<:" + column);
		
		if (row < 0 || column < 0 || row >= matrix.length ||  column >=  matrix[row].length) {
			return 0;
		}
		
		if (matrix[row][column] == 0) {
			return 0;
		}
		System.out.println("CODE:" + row +":col:" + column);
		matrix[row][column] = 0;
		int size = 1;
		for (int r = row -1 ; r < row + 1; r++) {
			for (int c = column -1 ; c <= column + 1; c++) {
				if (r != row || c != column ) {
					size += getMaxRegion(matrix, r, c);
				}
			}
		}
		
		System.out.println("Return size" + size + ":row:" + row + ":column:" + column);
		return size;
		
	}
	
	public static int visit(int[][] A, int i, int j, int n, int m, int size) {
	    A[i][j] = -1;
	    size++;
	    if(i-1 >= 0 && j-1 >= 0 && A[i-1][j-1] == 1) {
	    	size += visit(A, i-1, j-1, n, m, 0);
	    }
	    if(i-1 >= 0 && A[i-1][j] == 1) {
	        size += visit(A, i-1, j, n, m, 0);
	    }
	    if(i-1 >= 0 && j+1 < m && A[i-1][j+1] == 1) {
	        size += visit(A, i-1, j+1, n, m, 0);
	    }
	    if(j-1 >= 0 && A[i][j-1] == 1) {
	        size += visit(A, i, j-1, n, m, 0);
	    }
	    if(j+1 < m && A[i][j+1] == 1) {
	        size += visit(A, i, j+1, n, m, 0);
	    }
	    if(i+1 < n && j-1 >= 0 && A[i+1][j-1] == 1) {
	        size += visit(A, i+1, j-1, n, m, 0);
	    }
	    if(i+1 < n && A[i+1][j] == 1) {
	        size += visit(A, i+1, j, n, m, 0);
	    }
	    if(i+1 < n && j+1 < m && A[i+1][j+1] == 1) {
	        size += visit(A, i+1, j+1, n, m, 0);
	    }
	    return size;
	}

}
