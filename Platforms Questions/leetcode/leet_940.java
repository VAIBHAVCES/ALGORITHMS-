class Solution {
    public int distinctSubseqII(String str) {
      // return pure_tab(str);
        
        return opt_tab(str);
        
        
    }
    
    public int pure_tab(String str ){
          int mod = 1000000007;
        int n  = str.length();
        int dp[]= new int[n+1];
        dp[0]=1;
        for(int  i=1;i<=n;i++){
            char ch = str.charAt(i-1);
            dp[i]=(2*dp[i-1]%mod)%mod;
            
            for(int j=i-1;j>=1;j--){
                
                if(str.charAt(j-1)==ch){
                    
                    dp[i]=( dp[i]%mod - dp[j-1]%mod + mod)%mod;
                    break;
                }
            }
            // System.out.println(i+" "+dp[i]);
            
        }
        return dp[n]-1;
    }

    public int opt_tab(String S ){
         int dp[]= new int[S.length()+1];
        dp[0]=1;
        int occur[]= new int[26];
        int mod=1000000007;
        Arrays.fill(occur,-1);
        
        for(int i=1;i<dp.length;i++){
            
            int j=i-1;            
            char ith=S.charAt(j);
            int idx= (int)(ith-'a');
            
            int sub=occur[idx]==-1?0 : dp[occur[idx]-1];
            
            dp[i]=( (dp[i-1]*2)%mod +mod- sub)%mod; 
            occur[idx]=i;
        }
        return dp[S.length()]-1;
    }
    
}