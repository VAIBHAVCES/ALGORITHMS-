/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
	    int tc = Integer.parseInt(scn.nextLine());
	    while(tc-- > 0 ){
	        
	        int freq[] = new int[128];
	        String s1 = scn.nextLine();
	        int n = s1.length();
	        int si =0 , ei=0 ,len = -(int)1e8 , count =0 ;
	        while(ei < n ){
	            
	            System.out.println("before else: "+ei+" : "+count );
	            if(freq[s1.charAt(ei)]++==0) { ei++ ; count ++; }
	            else{
	                System.out.println("inside else: "+ei);
	                while(freq[s1.charAt(ei)]!=0){
	                    freq[s1.charAt(si++)]--;
	                    count--;
	                }
	            }
	            len = Math . max (count , len );
	            
	        }
	        
	        System.out.println(len);
	    }
	    
	    
	}
}