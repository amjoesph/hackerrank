package ha.algorithms;

import java.util.Scanner;

public class SolveGrades {

    static int solve(int[] grades){
        // Complete this function
    	
        for(int i=0; i < grades.length; i++){
            int k = 0;
        	if (grades[i] > 37) {
        		k =  grades[i] % 5 ;
        		if (k > 2) {
        			System.out.println(grades[i] + (5 - k));
        		} else {
        			System.out.println(grades[i]);
        		}
        	} else {
        		System.out.println(grades[i]);
        	}
        }

    	
    	return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int result = solve(grades);
//        System.out.println(result);
    }
}
