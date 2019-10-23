public class Collatz_Prog {
	
	// Declare Global Variables Memory List and Key for knowing what index I have added values to.  
	static int list[] = new int[1000000];
	static int arrKey = 0; 
	

    public static void main(String[] args) {

    	// Algo implementation with memory 
        System.out.println("Collatz with memory: \n");
        long Start_time_1 = System.currentTimeMillis();
        for(int n=10000; n>= 1; n--){
        	collatz(n);
        	System.out.println("\n");
        }
        long Stop_time_1 = System.currentTimeMillis();
        long time1 = Stop_time_1 - Start_time_1;
        
        // Algo implementation without memory. 
        System.out.println("Collatz without memory: \n");
        long Start_time_2 = System.currentTimeMillis();
        for(int k=10000; k>=1; k--){
        	collatz2(k);
        	System.out.println("\n");        	
        }
        long Stop_time_2 = System.currentTimeMillis();
        
        // Print the times to compare. 
        System.out.println("Time with mem is: " + time1);
        long time2 = Stop_time_2 - Start_time_2;
        System.out.println("Time without mem is: " + time2);
    }

    // Loop through memory list to check for previous values. 
    public static boolean check_list(int i){    	
    	for(int j=0; j <= arrKey; j++){
    		if(list[j]==i) return true; 		
    	}
		return false;   
    }
    
    // Collatz Algo with memory. 
    public static void collatz(int n) {	
    	// If value is in memory then exit 
    	if (check_list(n) == true){
    		System.out.println("Break");
    		return;
    	}
    	// else add the value to the memory list. 
    	else{
    		list[arrKey] = n;
    		arrKey = arrKey + 1;
    	}
    	
    	
        System.out.print(n + ", ");
        if (n == 1) {
        	return;
        }
        else if (n % 2 == 0) {
        	collatz(n / 2);
        	return;
        }
        else {
        	collatz(3*n + 1);
        	return; 
        }
    }
    
    // Algo without memory. 
    public static void collatz2(int n) {		
        System.out.print(n + ", ");
        if (n == 1) {
        	return;
        }
        else if (n % 2 == 0) {
        	collatz2(n / 2);
        	return;
        }
        else {
        	collatz2(3*n + 1);
        	return; 
        }
    }
    
}