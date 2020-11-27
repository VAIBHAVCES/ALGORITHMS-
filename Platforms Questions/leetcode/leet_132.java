class Solution {
    public boolean[][] pal_dp(String str ){
        int n = str.length();
        boolean dp[][]= new boolean[n][n];
        for(int gap=0; gap <n; gap++){
            for(int i=0 , j= i+gap ;i<n && j <n ;i++,j++){
                if(gap==0)  dp[i][j]=true;
                else if(gap==1  )  dp[i][j]=str.charAt(i)==str.charAt(j);
                else if(str.charAt(i)==str.charAt(j)){
                    dp[i][j]= dp[i+1][j-1] ? true:false;
                }
                else dp[i][j]=false;                
            }
        }
        return dp;
    }
    public int min_cut_rec(String str , int lo , int hi , boolean dp[][]){
        if(lo > hi )
            return 0;
        int ans = (int)1e8;
        for(int cut =lo ; cut<= hi ;cut++){
            
             if(dp[lo][cut]){
                 int myans= min_cut_rec(str,cut+1,hi,dp)+1;
                 ans = Math.min(ans , myans); 
            }
               
        }
        
        return ans;
    }
    // METHOD - MEOIZATION - 1
    public int min_cut_mem(String str , int lo , int hi , boolean dp[][] ,int vis[]){
        if(lo > hi )
            return  0;
        int ans = (int)1e8;
        if(vis[lo]!=-1)  return vis[lo];
            
        for(int cut =lo ; cut<= hi ;cut++){
            
             if(dp[lo][cut]){
                 
                 int myans= min_cut_mem(str,cut+1,hi,dp,vis)+1;
                 ans = Math.min(ans , myans); 
            }
               
        }
        
        return vis[lo]=ans;
    }
    // METHOD - MEOIZATION -2 
    public boolean palin_check(String str , int lo , int hi ){
        
        while(lo <= hi){
            if(str.charAt(lo)!=str.charAt(hi))  return false; 
            lo++;
            hi--;
        }
        return true;
    }
    public int min_cut_mem2(String str , int lo , int hi  ,int vis[] ){
        
        if(lo > hi )
            return vis[lo]= 0;
        
        int ans = (int)1e8;
        
        if(vis[lo]!=-1)  return vis[lo];
            
        for(int cut =lo ; cut<= hi ;cut++){
            
             if(palin_check(str,lo,cut) ) {
                 
                 int myans= min_cut_mem2(str,cut+1,hi,vis)+1;
                 ans = Math.min(ans , myans); 
            }
               
        }
        
        
        return vis[lo]=ans;
    }
    
    
   
    
    public int minCut(String s) {
        
        
        int n= s.length();
        // RECURSION
        // int ans= min_cut_rec(s,0,s.length()-1,pal);
        // return ans-1;
        
        // MEMOIZATION METHOD -1 
        // boolean pal[][]= pal_dp(s);
        int dp[]= new int[n+2];
        Arrays.fill(dp,-1);
        // return min_cut_mem(s,0,s.length()-1,pal,dp)-1;
        // MEMOIZATION METHOD -2 
        return min_cut_mem2(s,0,s.length()-1,dp)-1;
    
    }
}