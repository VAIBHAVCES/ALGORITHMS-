/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
		int tc= scn.nextInt();
		while(tc-- > 0 ){
		    
		    int n  = scn.nextInt();
		    int arr[] = new int[n];
		    int k = scn.nextInt();
		    for(int i=0;i<n;i++){
		        arr[i]=scn.nextInt();
		    }
		    int ptr =0;
		    int ans[]= new int[n];
		    PriorityQueue<Integer>mem = new PriorityQueue<>();
		    
		    for(int i=0;i<n;i++){
		        
		        mem.add(arr[i]);
		        if(mem.size() > k ){
		            ans[ptr]=mem.poll();
		            ptr=ptr+1;
		        }
		      //  System.out.println(" pq: "+mem+" ptr ; "+ptr);
		    }
		  //  System.out.println("ptr  : "+ptr );
		    while(mem.size() > 0 ){
		        ans[ptr++]=mem.poll();
		    }
		    for(int ele :ans){
		        System.out.print(ele+" ");
		    }
		    System.out.println();
		
		    
		    
		}
	}
}