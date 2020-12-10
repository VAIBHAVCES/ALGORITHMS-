/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		
		while(tc-- > 0 ){
		    
		    int n = scn.nextInt();
		    int  min=(int)1e8 ;
		    int min2=(int)1e8; 
		    HashSet<Integer>mem= new HashSet<>();
	       
	        for(int i=0 ;i <n;i++)  {
	            
		        int val =scn.nextInt();
		        if(val< min ){
                     min2 =min;
                     min =val;
                 }else {
                     min2 =Math.min(min2,val);
                 }
		        mem.add(val);
	            
	        }
	        if(n<=2){
	            System.out.println("YES");
	            continue;
	        }
		    int diff = min2-min;
		    boolean ans = true;
		    while(mem.size() > 0  && ans ){
		        if(mem.contains(min))
		            mem.remove(min);
		        else{
		           ans =false;
		        }
		        min+=diff;		            
		    }
		    if(ans)
		        System.out.println("YES");
	        else 
	             System.out.println("NO");
	        
	    }
	    
	    
	}
}