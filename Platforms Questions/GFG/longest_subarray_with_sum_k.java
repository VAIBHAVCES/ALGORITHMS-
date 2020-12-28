/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
	    Scanner scn = new Scanner(System.in);
	    int tc = scn.nextInt();
	    
	    while(tc-- > 0){
	        int n = scn.nextInt();
    	    int k = scn.nextInt();
    	    int arr[] = new int[n];
    	    for(int i=0;i<n;i++){
    	        arr[i]=scn.nextInt();
    	    }    
    	    System.out.println(longestsawsk(arr,k));
	        
	    }
	    
	    
	}
	public static int longestsawsk(int arr[] , int k ){
	     
	   int n = arr.length;
	   int ssf =0 ;
	   int ans = 0;
	   HashMap<Integer,Integer>map = new HashMap<>();
	   map.put(0,-1);
	   for(int i=0 ; i<n ; i++){
	       ssf+=arr[i];
	       if(map.containsKey(ssf-k) ){
	           ans = Math.max(ans , i-map.get(ssf-k));
	       }
	           if(!map.containsKey(ssf) )  map.put(ssf,i);
	       
	   }
	   return ans;
	    
	}
}