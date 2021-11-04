class Solution{
// ********** VERY STANDARD PROBLEM OF LONGEST PALINDROMIC SUBSEQUENCE 
// REFER IT IF YOU DIDN'T GET IT 
    static int kPalindrome(String str, int n, int k)
    {
        // code here
        // int n = str.length();
        int dp[][]= new int[n][n];
        for(int gap=0 ;gap < n ;  gap++){
            
            for(int i=0 , j =i+gap; i <n && j<n;i++,j++){
                if(gap==0) dp[i][j]=1;
                else if(str.charAt(i)==str.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else dp[i][j]=Math.max(dp[i][j] , Math.max(dp[i][j-1]  , dp[i+1][j] ) ) ;
                
            }
        }
        
        
        return n-ans<=k;
    }
}