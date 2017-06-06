package ha.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Crossword {

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
//				System.out.println("in string:" + in);
				if (in.length() == len && !inputUsed.contains(in)) {
//					System.out.println("fillll:" + row);
					Map<String,String> positionalIndexes = new HashMap<String, String>();
					Map<String,String> interPositionIndex = new HashMap<String, String>();
					
					for (String inter : interScan) {
						if (inter != null && row.indexOf(inter) != -1) {
							// to get a map of intersected position and letters 
							// e.g. 3,1; is D
							String letter = String.valueOf(in.charAt(row.indexOf(inter)/4));
							positionalIndexes.put(inter, letter);
							
							// to get a map of position and letters 
							// e.g. 3 is D
							for (String col : colScan) {
								if (col != null && col.indexOf(inter) != -1) {
									interPositionIndex.put(String.valueOf(col.indexOf(inter)/4), letter);
								}
							}
							
						}
					}
					
					
					if (positionalIndexes.size() > 0) {
						Iterator<String> itr = positionalIndexes.keySet().iterator();
						while(itr.hasNext()) {
							String key = itr.next();
//							System.out.println(":position index:" + key + ":va:" + positionalIndexes.get(key));
						}
						
						itr = interPositionIndex.keySet().iterator();
						while(itr.hasNext()) {
							String key = itr.next();
//							System.out.println(":intersection position index:" + key + ":iiiva:" + interPositionIndex.get(key));
						}
						
						itr = interPositionIndex.keySet().iterator();
						boolean inStrPositionContains = false;
						Boolean[] positionalStatus = new Boolean[interPositionIndex.keySet().size()];
						Arrays.fill(positionalStatus, Boolean.FALSE);
						int pos = 0;
						while(itr.hasNext()) {
							String key = itr.next();
							String _char = interPositionIndex.get(key);
							for (String otherin : input) {
								if (otherin.length() > Integer.parseInt(key)) {
//									System.out.println("other:"+otherin + ":char to check:"+ _char + ":@pos:" + key);
//									System.out.println("found char:" + otherin.charAt(Integer.parseInt(key)));
//									System.out.println("bool check (!otherin.equals(in)):" + !otherin.equals(in));
//									System.out.println("bool check (!inputUsed.contains(otherin)):" + !inputUsed.contains(otherin));
//									System.out.println("bool check (_char.equals(otherin.charAt(Integer.parseInt(key)))):" + _char.equals(String.valueOf(otherin.charAt(Integer.parseInt(key)))) );
									if (!otherin.equals(in) && !inputUsed.contains(otherin) && _char.equals(String.valueOf(otherin.charAt(Integer.parseInt(key))))) {
//										System.out.println("are we here..");
										inStrPositionContains = true;
										positionalStatus[pos] = true;
										break;
									}
								}
							}
							
							if (!inStrPositionContains) {
//								System.out.println("its a wrong string... lets go to the next one");
								inStrPositionContains = false;
							}
							pos++;
						}
						
						// check if a string matches all intersecional positions
						boolean fillStatus = true;
						int k = 0;
						for (Boolean positionStatus : positionalStatus) {
//							System.out.println("pos:" + k++ +":" + positionStatus.booleanValue());
							fillStatus = fillStatus && positionStatus.booleanValue();
						}
						
						if (fillStatus) {
							toFill = in;
							break;
						}
					} else {
						toFill = in;
						break;
					}
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
//		System.out.println("******* IN COL ********");
		for (Object str: inputUsed) {
//			System.out.println(str.toString());
		}
		for (String col : colScan) {
			if (col == null || col.length() == 0)
				continue;
			
			String colPos[] = col.split(";");
			String startPosN = colPos[0];
			String endPosN = colPos[colPos.length -1];
			int startY = Integer.parseInt(startPosN.split(",")[1]);
			int endY = Integer.parseInt(endPosN.split(",")[1]);
			int startX = Integer.parseInt(startPosN.split(",")[0]);
			int endX = Integer.parseInt(endPosN.split(",")[0]);
			int len = (endX - startX) + 1;
			
//			System.out.println("col 2 fill:" + col + ":len:" + len);
			
			String toFill = "";
			
			for (String in : input) {
//				System.out.println("in string:" + in);
				if (in.length() == len && !inputUsed.contains(in)) {
//					System.out.println("fillll:" + col);
					Map<String,String> positionalIndexes = new HashMap<String, String>();
					Map<String,String> interPositionIndex = new HashMap<String, String>();
					
					for (String inter : interScan) {
						if (inter != null && col.indexOf(inter) != -1) {
							// to get a map of intersected position and letters 
							// e.g. 3,1; is D
							String letter = String.valueOf(in.charAt(col.indexOf(inter)/4));
							positionalIndexes.put(inter, letter);
//							System.out.println("filling:" + inter + ":with:" + letter);
							
							// to get a map of position and letters 
							// e.g. 3 is D
							interPositionIndex.put(String.valueOf(col.indexOf(inter)/4), letter);
//							System.out.println("inter filling:" + String.valueOf(col.indexOf(inter)/4) + ":with:" + letter);
							
						}
					}
					
					
					if (positionalIndexes.size() > 0) {
						Iterator<String> itr = positionalIndexes.keySet().iterator();
						while(itr.hasNext()) {
							String key = itr.next();
//							System.out.println(":position index:" + key + ":va:" + positionalIndexes.get(key));
						}
						
						itr = interPositionIndex.keySet().iterator();
						while(itr.hasNext()) {
							String key = itr.next();
//							System.out.println(":intersection position index:" + key + ":iiiva:" + interPositionIndex.get(key));
						}
						
						itr = interPositionIndex.keySet().iterator();
						boolean inStrPositionContains = false;
						Boolean[] positionalStatus = new Boolean[interPositionIndex.keySet().size()];
						Arrays.fill(positionalStatus, Boolean.FALSE);
						int pos = 0;
						while(itr.hasNext()) {
							String key = itr.next();
							String _char = interPositionIndex.get(key);
							for (String otherin : input) {
								if (otherin.length() >= Integer.parseInt(key)) {
//									System.out.println("other:"+otherin + ":char 2 check:"+ _char + ":@pos:" + key);
//									System.out.println("found char:" + otherin.charAt(Integer.parseInt(key)));
//	//								System.out.println("bool check (!otherin.equals(in)):" + !otherin.equals(in));
//									System.out.println("bool check (!inputUsed.contains(otherin)):" + !inputUsed.contains(otherin));
//									System.out.println("bool check (_char.equals(otherin.charAt(Integer.parseInt(key)))):" + _char.equals(String.valueOf(otherin.charAt(Integer.parseInt(key)))) );
									if (!inputUsed.contains(otherin) && _char.equals(String.valueOf(otherin.charAt(Integer.parseInt(key))))) {
//										System.out.println("are we here..");
										inStrPositionContains = true;
										positionalStatus[pos] = true;
										break;
									}
								}
							}
							
							if (!inStrPositionContains) {
//								System.out.println("its a wrong string... lets go to the next one");
								inStrPositionContains = false;
							}
							pos++;
						}
						
						// check if a string matches all intersecional positions
						boolean fillStatus = true;
						int k = 0;
						for (Boolean positionStatus : positionalStatus) {
//							System.out.println("pos:" + k++ +":" + positionStatus.booleanValue());
							fillStatus = fillStatus && positionStatus.booleanValue();
						}
						
						if (fillStatus) {
							toFill = in;
							break;
						}
					} else {
						toFill = in;
						break;
					}
				}
			}
			
			if (toFill.equals("")) {
				break;
			}
			int k = 0;
			for (int j = startX; j<= endX; j++){
				matrix[j][startY]=""+toFill.charAt(k++);
			}
			inputUsed.add(toFill);
		}
	}
	

}
