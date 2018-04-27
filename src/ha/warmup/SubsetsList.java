package ha.warmup;

import java.util.ArrayList;
import java.util.List;

public class SubsetsList {

	public static void main(String[] args) {
		
		String[] names = {"Jane","Bob","Matt","Sara"};
		String[] subset = names;
		List<String> namesList = new ArrayList<>(); 
		for (String s : names) {
			namesList.add(s);
		}

		List<String> generatedList = new ArrayList<>(); 
		generateSubSets(names, subset, "", 0, generatedList);
		
		for (String str : generatedList) {
			System.out.println(str);
		}
		generatedList.clear();
		System.out.println("=====================");
		
		sublistsHelper1(namesList,generatedList, 0, 0);
		
	}
	
	
	public static void generateSubSets(final String[] names, String[] subset, String prefix, int position, List<String> generatedList) {
		
		if (position >= names.length) {
			return;
		}
		
		for (int j = position; j < subset.length; j++) {
			if ( prefix == "") {
				prefix = subset[j];
			} else {
				prefix = prefix + "," + subset[j];
			}
			if ( ! generatedList.contains(prefix)) {
				generatedList.add(prefix);
			}
			
			for (int i = j; i < subset.length; i++) {
				if ( i != j) {
					generatedList.add(prefix + "," + subset[i]);	
				}
				
			}
		}
		position++;
		generateSubSets(names, names, "", position, generatedList);
	}
	
	
	static void sublists (List<String> nameList, List<String> generatedList) {
		sublistsHelper(nameList, generatedList, 0, 0);
	}
	
	static void sublistsHelper (List<String> nameList, List<String> generatedList, int i, int  j) {
		if (nameList.size() == 0) {
			System.out.println("(())i:" + i +":j:" + j);
			System.out.println(generatedList.toString());
		} else {
			String first = nameList.get(0);
			nameList.remove(0);
			generatedList.add(first);
			
			i++;
			System.out.println("i:" + i +":j:" + j);
			
			sublistsHelper(nameList, generatedList, i, j);

			generatedList.remove(generatedList.size() - 1);
			j++;
			System.out.println("::i:" + i +":j:" + j + ":first:" + first);
			sublistsHelper(nameList, generatedList, i, j);
			System.out.println(">>>i:" + i +":j:" + j  + ":first:" + first);
			nameList.add(0, first);
		}
	}
	
	public static void sublistsHelper1(List<String> nameList, List<String> generatedList, int i, int j) {
		sublistsHelper1(nameList,generatedList);
	}
	//mimic the above method
	public static void sublistsHelper1(List<String> nameList, List<String> generatedList) {
		if (nameList.size() == 0) {
			System.out.println(generatedList.toString());
		} else {
			String first = nameList.get(0);
			generatedList.add(first);
			nameList.remove(0);
			sublistsHelper1(nameList, generatedList);
			
			generatedList.remove(generatedList.size() -1);
			sublistsHelper1(nameList, generatedList);
			
			nameList.add(0, first);
		}
	}
}
