/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
	    Scanner scn = new Scanner(System.in);
	    int n = Integer.parseInt(scn.nextLine());
	    while(n-->0){
	        String str =scn.nextLine();
	        if(getAns(str)) System.out.println("Yes");
	        else System.out.println("No");
	    }
	   
	    
	}
	public static boolean getAns(String str){
	    
	    
	    HashMap<Character, Integer>map = new HashMap<>();
	    for(int i=0;i < str.length();i++){
	        map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
	    }
	    boolean check=false;
	    for(char ch : map.keySet()){
	        if(map.get(ch)%2!=0){
	            if(check) return false;
	            else check=true;
	        }
	    }
	    return true;
	}
}