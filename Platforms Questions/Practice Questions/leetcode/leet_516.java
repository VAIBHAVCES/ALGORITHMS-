class Solution {
    
     public  int mem(String x , int i , int j , int dp[][]){
        if(i>=j)
            return dp[i][j]= i>j ? 0:1;
         
        if(dp[i][j]!=-1)    return dp[i][j];
        if(x.charAt(i)==x.charAt(j))   return dp[i][j]=mem(x, i+1, j-1, dp) +2;
        else  return dp[i][j]=Math.max(mem(x, i+1, j, dp) ,  mem(x, i, j-1, dp));
    }
    public int tabulation(String s  ){
        
        int n = s.length();
        int dp[][]=new int[n][n];
        for(int  diag =0; diag<n; diag++){
            for(int  i=0 ,j =i+diag ; i <n && j<n ;i++ ,j++){
                
                if(diag==0 )dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]= dp[i+1][j-1]+2;
                }else{
                    dp[i][j]= Math.max(dp[i][j-1] , dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
        
        
    }
    public int longestPalindromeSubseq(String x) {
        int n = x.length();
        
        // MEMOIZATION
        // int dp[][]= new int[n][n];
        // for(int sub[] : dp){
        //     Arrays.fill(sub,-1);
        // }
       // return mem( x, 0 , n-1,dp);
       // TABULATION
        return tabulation(x );
        
    
    
    }
}