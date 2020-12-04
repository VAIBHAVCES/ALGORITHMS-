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
		    
		        String str = scn.nextLine();
		        int n  = str.length();
		        int freq[] = new int[128];
		        int ulen =0 ; 
		        for(int i=0 ;i < n; i++){
		             freq[str.charAt(i)]=1;
		        }
		        for(int ele:  freq) ulen+= ele ;
		        int si =0  , ei =0 , len = (int)1e8 , count = ulen;
		        while(ei < n ){
		            if( freq[str.charAt(ei++)]-- > 0 ) count--;
		            while(count==0 ){
		                
		                if(ei- si < len ) len = ei- si ;
		                if(freq[str.charAt(si++)]++ ==0) count ++;
		            }
		            
		        }
		System.out.println(len==(int)1e8 ?0 : len );
		}
	}
}