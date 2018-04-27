package ha.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Crossword_deb {

	static String inputStr = null;

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		
		String matrixIn[] = new String[10]; 
		for (int i = 0; i < 10; i++) {
			matrixIn[i] = scan.nextLine();
		}
		
		inputStr = scan.nextLine();
		String input[] = inputStr.split(";");
		scan.close();
		
		String matrix[][] = new String[10][10];
		
		//Load matrix
		for (int i = 0; i < 10; i++) {
			char row[] = matrixIn[i].toCharArray();
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = ""+row[j];
			}
		}
		
		String[] rowScan = new String[10];
		String[] colScan = new String[10];
		String[] interScan = new String[10];
		
		rowScan = scanHorizPositions(matrix, "-", rowScan);
		System.out.println(Arrays.toString(rowScan));
		colScan = scanVertPositions(matrix, "-", colScan);
		System.out.println(Arrays.toString(colScan));
		interScan = getIntersectioPositions(rowScan, colScan, interScan);
		System.out.println(Arrays.toString(interScan));
		
		List<String> inputUsed = new ArrayList<>();
		placeWordsInMatrix(matrix, rowScan, colScan, interScan, input, inputUsed);
		
		// only print: START
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
			
	}
	
	public static String[] scanHorizPositions(String[][] matrix, String char2Check, String[] rows) {
		int k = 0;
		boolean isfound = false;
		for (int i = 0; i < 10; i++) {
			if (isfound) {
				isfound = false;
				k++;
			} 
//			else {
//				rows[k]="";
//			}
			for (int j = 0; j < 10; j++) {
				if (matrix[i][j].equals(char2Check) && 
						( (j > 0 && matrix[i][j-1].equals(char2Check)) || (j+1 < 10 && matrix[i][j+1].equals(char2Check))) ) {
					if (rows[k] == null) {
						rows[k] = "";
					}
					rows[k] += i+","+j+";";
					isfound = true;
				}
			}
			
//			if (rows[k] == null || rows[k] == "") {
//				continue;
//			}
//			String[] positions = rows[k].split(";");
//			if (positions.length > 1) {
//				// TODO: to filter
//				int startPos = Integer.parseInt(positions[0].split(",")[1]);
//				int wlen = 1;
//				for (int l=1; l< positions.length; l++){
//					int endPos = Integer.parseInt(positions[l].split(",")[1]);
//					if (startPos+1 != endPos) {
//						if (wlen > 1 && matchWordsLen(wlen)) {
//							isfound = true;
//						}
//					} else {
//						startPos = endPos;
//						wlen++;
//					}
//				}
//				
//				if (wlen > 1 && matchWordsLen(wlen)) {
//					isfound = true;
//				} else {
//					isfound = false;
//					rows[k]="";
//				}
//				
//			} else {
//				isfound = false;
//				rows[k]="";
//			}
			
		}		
		return rows;
	}
	
	public static String[] scanVertPositions(String[][] matrix, String char2Check, String[] rows) {
		int k = 0;
		boolean isfound = false;
		for (int j = 0; j < 10; j++) {
			if (isfound) {
				isfound = false;
				k++;
			}
			for (int i = 0; i < 10; i++) {
				if (matrix[i][j].equals(char2Check) &&
						( (i > 0 && matrix[i-1][j].equals(char2Check)) || (i+1 < 10 &&  matrix[i+1][j].equals(char2Check)))
						) {
					if (rows[k] == null) {
						rows[k] = "";
					}
					
					rows[k] += i+","+j+";";
					isfound = true;
				}
			}
			
//			if (rows[k] == null || rows[k] == "") {
//				continue;
//			}
			
//			String[] positions = rows[k].split(";");
//			if (positions.length > 1) {
//				// TODO: to filter
//				int startPos = Integer.parseInt(positions[0].split(",")[0]);
//				int wlen = 1;
//				for (int l=1; l< positions.length; l++){
//					int endPos = Integer.parseInt(positions[l].split(",")[0]);
//					if (startPos+1 != endPos) {
//						if (wlen > 1 && matchWordsLen(wlen)) {
//							isfound = true;
//						}
//					} else {
//						startPos = endPos;
//						wlen++;
//					}
//				}
//				
//				if (wlen > 1 && matchWordsLen(wlen)) {
//					isfound = true;
//				} else {
//					isfound = false;
//					rows[k]="";
//				}
//				
//			} else {
//				isfound = false;
//				rows[k]="";
//			}
			
		}		
		return rows;
	}
	
	public static boolean matchWordsLen(int len) {
		boolean res  = false;
		String input[] = inputStr.split(";");
		
		for (String s : input) {
			if (s.length() == len) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public static String[] getIntersectioPositions(String[] rows, String[] cols, String[] inter) {
		
		String colStr = Arrays.toString(cols);
		int k =0;
		for (int i =0; i < rows.length; i++) {
			String cc = rows[i];
			if ( cc == null || cc == "") {
				continue;
			}
			
			for (String a : cc.split(";")){
				if (colStr.indexOf(a) != -1){
					inter[k] = a;
					k++;
				}
			}
			
		}
		
		return inter;
	}
	
	public static void placeWordsInMatrix(String matrix[][], String rowScan[], String colScan[], String interScan[], String input[], List inputUsed) {
		placeWordsInRowsMatrix(matrix, rowScan, colScan, interScan, input, inputUsed);
		placeWordsInColsMatrix(matrix, rowScan, colScan, interScan, input, inputUsed);
	}
	
	public static void placeWordsInRowsMatrix(String matrix[][], String rowScan[], String colScan[], String interScan[], String input[], List inputUsed) {
		for (String row : rowScan) {
			if (row == null || row.length() == 0)
				continue;
			String rowPos[] = row.split(";");
			String startPosN = rowPos[0];
			String endPosN = rowPos[rowPos.length -1];
			int startY = Integer.parseInt(startPosN.split(",")[1]);
			int endY = Integer.parseInt(endPosN.split(",")[1]);
			int startX = Integer.parseInt(startPosN.split(",")[0]);
			int endX = Integer.parseInt(endPosN.split(",")[0]);
			int len = (endY - startY) + 1;
			
			String toFill = "";
			
			for (String in : input) {
				if (in.length() == len && !inputUsed.contains(in)) {
					System.out.println("fillll:" + row);
					Map<String,String> positionalIndexes = new HashMap<String, String>();
					for (String inter : interScan) {
						if (inter != null && row.indexOf(inter) != -1) {
							positionalIndexes.put(String.valueOf( (row.indexOf(inter)/4) + 1 ), inter);
						}
					}
					
					if (positionalIndexes.size() > 0) {
						Iterator<String> itr = positionalIndexes.keySet().iterator();
						while(itr.hasNext()) {
							String key = itr.next();
							System.out.println(":k:" + key + ":va:" + positionalIndexes.get(key));
						}
					}
					
					
					
					toFill = in;
					break;
				}
			}
			
			if (toFill.equals("")) {
				break;
			}
			int k = 0;
			for (int j = startY; j<= endY; j++){
				matrix[startX][j]=""+toFill.charAt(k++);
			}
			inputUsed.add(toFill);
		}
	}
		
	public static void placeWordsInColsMatrix(String matrix[][], String rowScan[], String colScan[], String interScan[], String input[], List inputUsed) {
		
	}
	

}
