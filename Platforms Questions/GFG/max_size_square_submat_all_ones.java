/*package whatever //do not write package name here */

// ****************QUESTION LINK ----https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/ 
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    //  METHODS -
    //   1-- RECURSION -- DONE 
    //   2-- MEMOIZATION -- DONE 
    //   3-- TABULATION -- DONE 
    
    // APROACH - BASIC INTUTION IS I HAVE GIVE CALL TO RIGHT ELEMENT, DIAGONAL ELEMENT  AND 
    //  BELOW ELEMENT THAT INCLUDING ITH ELEMENT GET THE DIMENSION OF SQUARE THESE ELEMENTS CAN
    // FORM AND MY DIMENSION WILL MIN OF ALL 3 +1  . IN MY CODE THERE IS ONE TESTCASE IT WAS FAILING
    //  THAT IF ARR IS LIKE [1,1,1,1,1] RIGHT WILL GIVE 5 AND I HAVE NOT CONSIDERED OUTPUT OF NEXT
    //  ROW AND NEXT COLUMNS SO BECAUSE WHICH MY CODE WORKED BUT I WAS NOT ABLE TO PREDICT IT IS SQUARE 
    // OR NOT 
    
    // SIMPLE LANGUAGE MEANING ---- PLACES WHERE I HAVE CHECKED FOR I+1 < N OR J+1 <M AT THOSE 
    // CONDITIONS WHAT I COULD DO IS THAT I COULD HAVE RETURNED 0 AND SO IN THAT WAY I COULD SAVE A 
    // A LOT OF LINE OF CODES . 
    
    // ****************** RECURSION*********
    public static int square_finder_rec(int i , int j , int arr[][] ){

        int n = arr.length;
        int m = arr[0].length;
        if(arr[i][j]==0)
            return 0 ;

        int min =Integer.MAX_VALUE;
        if(j+1 < m)
            min = Math.min ( min , square_finder_rec(i, j+1, arr) );
        if(i+1 < n)
            min = Math.min ( min , square_finder_rec(i+1, j, arr) );     
        if(i+1 < n && j+1 < m)
            min = Math.min ( min , square_finder_rec(i+1, j+1, arr) );
        return (min ==Integer.MAX_VALUE? 0: min )+ 1;

    }
    public static int sub_squares_rec(int arr[][] ) {

        int n = arr.length;
        int m = arr[0].length;

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    int temp = square_finder_rec(i,j,arr);
                    if(i+temp<=n && j+temp<=m) 
                        ans  = Math.max ( ans , temp );
            }
        }
        return ans;
    }
	
    // *******************MEMOIZATION *************
    public static int square_finder_mem(int i , int j , int arr[][]  ,int dp[][]){

        int n = arr.length;
        int m = arr[0].length;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(arr[i][j]==0)
            return dp[i][j]=0 ;
            

        int min =Integer.MAX_VALUE;
        if(j+1 < m)
            min = Math.min ( min , square_finder_mem(i, j+1, arr , dp) );
        if(i+1 < n)
            min = Math.min ( min , square_finder_mem(i+1, j, arr , dp) );     
        if(i+1 < n && j+1 < m)
            min = Math.min ( min , square_finder_mem(i+1, j+1, arr ,dp) );
        return dp[i][j]=(min ==Integer.MAX_VALUE? 0: min )+ 1;

    }
	public static int sub_squares_mem(int arr[][] ) {

        int n = arr.length;
        int m = arr[0].length;
        int dp[][]= new int[n+1][m+1];
        for(int sub[] :  dp)    Arrays.fill(sub,-1);
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    int temp = square_finder_mem(i,j,arr,dp);
                    if(i+temp<=n && j+temp<=m) 
                        ans  = Math.max ( ans , temp );
            }
        }
        return ans;
    }
	///********************** TABULATION **************
	
	public static int sub_squares_tab(int arr[][]){
	    int n = arr.length;
	    int m = arr[0].length;
	    int ans = 0;
	    int dp[][]= new int[n+1][m+1];
	    for(int i=n-1;i>=0;i--){
	        for(int j= m-1; j>=0;j--){
	            
	            if(arr[i][j]==1)
	                dp[i][j]= Math.min( dp[i+1][j] , Math.min(dp[i+1][j+1] , dp[i][j+1] ) )+1;
	            
	            ans = Math.max(ans, dp[i][j]);
	        }
	    }
	    return ans;
	    
	}
	
	public static void main (String[] args) {
		//code
	 
	 Scanner scn  = new Scanner(System.in);
	
	 int tc= scn.nextInt();
	 while(tc-- > 0 ){
	     
	     int m = scn.nextInt();
	     int n = scn.nextInt();
	     int arr[][]= new int[m][n];
	     for(int i=0;i<m;i++){
	         for(int j=0;j<n;j++) arr[i][j]=scn.nextInt();
	     }
	   //  **** RECURSION CALLING AREA********
	   // int ans = sub_squares_rec(arr);
	   //  ***** MEMOIZATION CALLING AREA******
	   // int ans = sub_squares_mem(arr);
        //  ************* TABULATION CALLING AREA **********
        int ans= sub_squares_tab(arr);
        System.out.println(ans );
    
	     
	 }
	    
	    
	    
	}
}