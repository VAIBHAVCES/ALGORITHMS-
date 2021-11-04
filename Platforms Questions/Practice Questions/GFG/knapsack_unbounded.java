//  QUESTION LINK : -https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        // -**********RECURSION *********
        // APROACH - THIS PROBLEM IS SIMILAR TO VERY STANDARD DP PROBLEM OF 
        // COIN CHANGE WITH INFINTE COINS COMBINATION SO WHAT CAN WE USE AS 
        // RECUSRIVE FAITH HERE IS  - THEIR IS FUNCTION WHICH WILL GIVE US MAX
        // VALUE POSSIBLE FROM A PARTICULAR WEIGHT NOW WHAT WE HAVE TO DO IS THAT 
        // USING ALL WEIGHT BALLS WE WILL GIVE CALL AND WILL RETURN MAX OF ALL + MYVAL 
        
        // return knapSack_rec(val , wt , W);
        // ************** MEMOIZATOIN ********
        // WE DONT NEED HERE TO USE 2D DP HERE BECAUSE HERE VALUE ACHIEVED AT EVERY WEIGHT
        // IS INDEPENDENT OF WHICH WEIGHT SACKS WE HAVE USED SO FAR WE CAN USE AS MANY TIMES
        // AS WE WANT 
        int dp[]= new int[W+1];
        Arrays.fill(dp,-1);
        return knapSack_mem(val ,wt, W, dp);
        
        
    }
    public static int knapSack_rec(int val[] , int wt[] , int w) {
        
        if(w==0)
            return 0;
        int ans=0; 
        for(int wei=0;wei <wt.length ; wei++){
            if(w-wt[wei]>=0 ) ans =Math.max(ans ,knapSack_rec(val , wt, w-wt[wei] ) +val[wei] );
        }
        return ans;
    }
    
    public static int knapSack_mem(int val[] , int wt[] , int w, int dp[]) {
        
        if(w==0)
            return dp[w]=0;
        if(dp[w]!=-1)
            return dp[w];
        int ans=0; 
        for(int wei=0;wei <wt.length ; wei++){
            if(w-wt[wei]>=0 ) ans =Math.max(ans ,knapSack_mem(val , wt, w-wt[wei] ,dp ) +val[wei] );
        }
        return dp[w]=ans;
    }
    
}