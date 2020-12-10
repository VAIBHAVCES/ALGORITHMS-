/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public int wrong_ans(String str) {
        int n = str.length();
	        int ssf=0 ,ans=0;
	        
	        HashMap<Integer,Integer>map = new HashMap<>();
	        map.put(ssf,1);
	        
	        for(int i=0;i<n;i++){
	            int parsed= str.charAt(i)-'0';
	            ssf+= parsed==0 ?-3:parsed;
	            ans+=map.getOrDefault(ssf , 0 );
	            map.put(ssf, map.getOrDefault(ssf , 0 ) +1 );
	           // System.out.println(ssf+" --:-- "+ map+" - > "+ans);
	        }
	       // System.out.println(ans);   
	       return ans;
    }

	public static void main (String[] args) {
		// APROACH - IN FUNCTION WRONG ANS I TRIES TO DO SIMILAR TO QUESTION OF 0S AND 1S
		// THAT IS I TRIED TO NEUTRALIZE 0 WITH -3 BUT IT DIDN'T WORKED OUT BECAUSE FOR
		// A TESTCASE OF 202021010101 IT WAS FAILING BECAUSE 202021 CREATE A NUMBER TRAIL WHIHC
		// I WAS NOT EXPECTING SO TO IMPROVISE THAT ,  I USED AN ARRAY AND KEPT A NEW INTUTION
		// THAT AT IF AT JTH INDEX COUNT(1)-COUNT(0)= COUNT(2)-COUNT(1) IS SAME TO ANY ITH INDEX
		// THAN THAT MEANS NO OF 0S 1S AND 2S INCREASED IN SAME WAY THAT MEANS EQUAL NO OF
		//  0S , 1S AND 2S ARE APPENDED HENCE ANY POINT JTH WE WILL KEEP INCREMENTING OUR 
	    // ANS 
		Scanner scn = new Scanner(System.in);
		int tc = Integer.parseInt(scn.nextLine());
		while(tc-- > 0){
		    String str= scn .nextLine();
		    int arr[]=  new int[3];
		    int ans=0;
		    HashMap<String ,  Integer>map = new HashMap<>();
		    map.put( "0@0",1);
		    for(int i=0 ; i<str.length(); i++ ){
		        arr[(int)(str.charAt(i)-'0')]++;
		        String myAns= (arr[1]-arr[0])+"@"+(arr[2]-arr[1]);
		        ans+= map.getOrDefault(myAns , 0 );
		        map.put(myAns , map.getOrDefault(myAns , 0 )+1);
		 
		    }
		    System.out.println(ans);
		    
		}
	}
}