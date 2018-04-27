package ha.warmup;

public class MinJumpsEndofArray {
	
	
	public static int[] minJumps(int[] arr) {
		int jumpFrom[] = new int[arr.length];
		int jumpCount[] = new int[arr.length];
		
		for(int i=1; i < arr.length ; i++){
			jumpCount[i] = Integer.MAX_VALUE-1;
        }
		
		for (int i= 1; i<arr.length;i++) {
			for (int j=0; j<i; j++){
				
				if (arr[j] +j  >= i) {
					if (jumpCount[i] > jumpCount[j] + 1 ) {
						jumpCount[i] = jumpCount[j] + 1;
						jumpFrom[i] = j;
					}
				}
			}
		}
		
		return jumpCount;
	}
	
	
	public static int[] minJump(int arr[],int result[]){
        
        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
    	System.out.println("debugging:::START");
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
            	
            	System.out.println("j:" +j + ":arr[j]:" + arr[j] +":i:" + i);
            	System.out.println("jump[i]" + jump[i] + ":jump[j]:" + jump[j] );
            	System.out.println("~~~~~~~");
            	
                if(i <= arr[j] + j){
                    if(jump[i] > jump[j] + 1){
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
    	System.out.println("debugging:::END");
        
        return jump;
    }
	
	
    public static void main(String args[]) {
        int arr[] = {2,6,3,2,3,4,5,1,2,8};
        
        int r[] = new int[arr.length];
        int result[] = minJump(arr,r);
        System.out.println("====== counts =======");
        for (int i=0; i< result.length; i++) {
        	System.out.println(result[i]);
        }
        System.out.println("======path=======");
        for (int i=0; i< r.length; i++) {
        	System.out.println(r[i]);
        }
        System.out.println("====== Martin logic =======");
        
        result = minJumps(arr);
        
        for (int i=0; i< result.length; i++) {
        	System.out.println(result[i]);
        }
        

    }

}
