/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static ArrayList<Integer> firstNegative(int arr[] , int k , int n ){
        
        int si=0,ei=0;
        ArrayList<Integer>ans = new ArrayList<>();
        ArrayDeque<Integer>mem = new ArrayDeque<>();
        while(ei < n ){
            
            if(ei-si < k ){
                if(arr[ei] < 0 )
                    mem.addLast(ei);
                ei++;
            }
            
            if(ei-si ==k ){
                ans.add(mem.size()!=0 ?arr[mem.peekFirst()] : 0 ) ;
                si++;
                while(mem.size() > 0 && si > mem.peekFirst() ){
                    mem.removeFirst();
                }
            }
            
        }
        return ans;
    }
	public static void main (String[] args) {
	    
	    Scanner scn = new Scanner(System.in);
	    int tc = scn.nextInt();
	    while(tc-- > 0 ){
	        
	        int n = scn.nextInt();
	        int arr[] = new int[n];
	        for(int i=0; i<n ; i++){
	            arr[i]=scn.nextInt();
	        }
	        int k = scn.nextInt();
	        ArrayList<Integer>ans =firstNegative(arr, k ,n);
	        for(int ele: ans){
	            System.out.print(ele+" ");
	        }
	        System.out.println();
	        
	    }
		//code
	}
}