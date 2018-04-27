package ha.warmup;

public class MatrixSearch {

	public static void main(String[] args) {
		
		int[][] matrix  = new int[][]{
			  { 2, 25, 50, 75},
			  { 5, 28, 60, 80},
			  { 10, 30, 65, 83},
			  { 20, 32, 70, 85}
			};
			
			System.out.println(isExist(matrix,20));
	}
	
	
	private static boolean isExist(int[][] matrix, int num) {
		
		boolean _exist = false;
		
		int x = 0;
		int y = matrix[0].length - 1;
				
		if ( matrix[x][y] == num) {
			return true;
		}
		
		while (x < matrix.length && y >= 0) {
			if (matrix[x][y] == num) {
				System.out.format("found index at %d, %d.", x, y);
				_exist = true;
				break;
			}
			if (matrix[x][y] > num) {
				y--;
			} else {
				x++;
			}
		}
		
		return _exist;
		
	}

	
	private static boolean isExistByMartin(int[][] matrix, int num) {
		
		boolean _exist = false;
		boolean _continue = true;
		
		int x = 0;
		int y = 3;
		
		int element = matrix[x][y];
		
		
		if (element == num) {
			return true;
		}
		
		int k = 0;
		while (_continue) {
			k++;
			if (num > element) {
				element =  matrix[++x][y];
				if (element == num || (x>0 && matrix[x-1][y] < num  && element > num)) {
					_continue = false;
				}
			} else {
				if (y-1 < 0) {
					_continue = false;
				} else {
					element =  matrix[x][--y];	
				}
				
			}
			System.out.println("element:" + element);
			if (element == num) {
				_exist = true;
			} else {
				if (x+1 == matrix.length  || (y == 0 && x+1 == matrix.length)) {
					_continue = false;
				}
			}
		}
		
		return _exist;
		
	}

}
