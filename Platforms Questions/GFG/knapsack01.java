
//  QUESTION LINK - https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/ 

import java.util.*;
import java.lang.*;
import java.io.*;

class knapsack01{
    
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		while(tc-- >0 ){
		    
		  //  ***********INPUT AREA ***********
		    int n = scn.nextInt();
		    int lim= scn.nextInt();
		    int weight[] = new int[n];
		    int vals[] = new int[n];
		    for(int i=0;i<n;i++) vals[i]=scn.nextInt();
		    for(int i=0;i<n;i++) weight[i]=scn.nextInt();
		    
		  //  **************** RECURSION****
		  //APROACH - MOTIVE IS TO FILL BAG WITH WEIGHTS OF ONLY THOSE 
		  //WHICH CAN GIVE US MAXIMUMM WEIGHT IN END , SO A VERY SIMPLE
		  // APROACH CAN BE WE CHECK BY INCLUDING AND EXCLUDING THAT WHAT
		  // EFECT THEY PRODUCE ON OUTPUT AND  IN THAT WE CAN GET MAX PROFIT 
		  
		  //  System.out.println(knapsack_rec(weight , vals , lim , n));

		  //  ****************MEMOIZATION *********
		  
		  // APROACH - BY OBSERVING RECURSION TREE WE CAN ANALYZE THAT N( IDX IN RECUSION) 
		  // AND LIMIT_WEIGHT_SO_FAR ARE TWO FACTOR WHICH ARE CHANGING AT EACH STEP SO 
		  // THESE 2 CAN NE STORED TO AVOID OVERLAPPING SUB PROBLEM
		  
		  //int dp[][]= new int[n+1][lim+1];
		  //for(int arr[] : dp ) Arrays.fill(arr,-1);
		  //System.out.println(knapsack_mem(weight,vals ,lim ,n ,dp ) );
		  
		  //************** TABULATION************
		  System.out.println(knapsack_tab(weight,vals , lim ));
		}
	}	
	public static int knapsack_rec(int weight[] , int vals[] , int lim , int n ){
		    
		    if(n==0 || lim == 0){
		        return 0;
		    }
		    int ans = 0;
		    if(lim-weight[n-1] >=0){
		        ans= Math.max( ans , knapsack_rec(weight , vals , lim-weight[n-1] , n-1)+vals[n-1] );
		    }
		        ans= Math.max( ans , knapsack_rec(weight , vals , lim , n-1) );
		
		    return ans;
		}
	
	public static int knapsack_mem(int weight[] ,int vals[] , int lim  ,int n  ,int dp[][]) {
	    
	     if(n==0 || lim == 0){
		        return dp[n][lim]=0;
		    }
		    
		 if(dp[n][lim]!=-1) return dp[n][lim];
		 
		    int ans = 0;
		    if(lim-weight[n-1] >=0){
		        ans= Math.max( ans , knapsack_mem(weight , vals , lim-weight[n-1] , n-1 ,dp )+vals[n-1]);
		    }
		        ans= Math.max( ans , knapsack_mem(weight , vals , lim , n-1 , dp) );
		
		    return dp[n][lim]=ans;
	    
	}	
		
	public static int knapsack_tab(int weight[],  int vals[] , int lim ){
	    int n = weight.length;
	    int dp[][] =  new int[n+1][lim+1];
	    for(int i=1;i<=n;i++){
	        
	        for(int wei=1;wei<=lim;wei++){
	            if(wei-weight[i-1]>=0)
	                dp[i][wei] =Math.max( dp[i-1][wei] , dp[i-1][wei-weight[i-1]] + vals[i-1] );
	            else 
	                dp[i][wei]=dp[i-1][wei];
	            
	        }
	    }
        return dp[dp.length-1][lim];
	    
	    
	}
	
}