class Solution {
    
    public int cc_rec(int coins[] , int amt , int csf){
        if(amt==0)
                return csf;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i < coins.length;i++){
            if(amt-coins[i]>=0){
                ans = Math.min(ans ,cc_rec(coins , amt - coins[i] ,csf+1) );
            }
        }
        return ans;
    
        
    }
    public int cc_mem(int coins[] , int amt , int dp[]){
        if(amt==0)
                return dp[amt]=0;
         if(dp[amt]!=-1 )
                return dp[amt];
        int ans = Integer.MAX_VALUE;
        for(int i=0; i < coins.length;i++){
            if(amt-coins[i]>=0){
                ans = Math.min(ans ,cc_mem(coins , amt - coins[i] ,dp) );
            }
        }
        return dp[amt]=ans==Integer.MAX_VALUE ? Integer.MAX_VALUE : ans+1;
    
        
    }
    public int cc_tab(int coins[] , int amount ){
        
        int dp[]= new int[amount + 1];
        dp[amount]=0;
        
        for(int i =amount-1 ;i >=0;i-- ){
        
            int min = Integer.MAX_VALUE;
            for(int coin : coins ){
                // System.out.println(" i "+i+ " coin " +coin  );
                if(coin <= amount && i+coin <=amount){
                    min = Math.min(min , dp[i+coin] );
                }
            }
            dp[i] = min==Integer.MAX_VALUE ? Integer.MAX_VALUE  : min+1;  
        }
        return dp[0];
        
    }
    public int coinChange(int[] coins, int amount) {
        
        // EXPLANATION :  - WHAT I AM TRYING TO DO IS THAT FOR ANY AMOUNT 'X' , I ITERATE 
        // OVER WHOLE COIN ARRAY AND CONSIDERING GIVING FAITH THAT GIVING RECUSIVE CALL TO 
        // X-COINS[i] WILL PROVIDE ME WITH MIN NO OF COINS REQUIRED TO ACHIEVE AMOUNT X  USING
        // ith COING , ALL  I HAVE TO DO IS FIND MIN NO OF COINS REQUIRED TO ACHIEVE X FROM ALL  
        // WHICH COINS ARRAY AND HAVE RETURN MIN +1 , ALSO REMEMBER WHEN WE WILL REACH 0 THAT I
        // A BASE CASE BECAUS THERE ARE 0 WAYS TO ACHIEVE 0 FROM ANY NO OF COINS
        
        if(amount == 0)
                return 0;
//        ****************** RECURSIVE **************
        
        //  int ans = cc_rec(coins , amount ,0 );
        //  return ans == Integer.MAX_VALUE ? -1 : ans;
        
        // *************** MEMOIZATION **********
        
//         int dp[]= new int[ amount +1 ];
//         Arrays.fill(dp ,-1);
//         int ans= cc_mem(coins , amount , dp );
        
//         return ans==Integer.MAX_VALUE?-1 :ans ;
        
//         ***************TABULATOIN*********
        
        //  int ans= cc_tab(coins , amount );
        // return ans==Integer.MAX_VALUE?-1 :ans ;
        
    }
}