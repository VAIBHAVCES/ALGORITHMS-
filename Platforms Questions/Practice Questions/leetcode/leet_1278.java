class Solution {
    
    public int  minChange(String str , int lo , int hi ){
        
        int ans = 0 ; 
        while(lo < hi ){
            if(str.charAt(lo)!=str.charAt(hi) )ans++;
            lo++; hi--; 
        }
        return ans;
    }
     public int[][] minChaneDp(String s ){
            int n = s.length();
            int pal[][]= new int[n][n];
            for(int gap =1; gap < n ;gap++){
                
                for(int i=0 , j=i+gap ; i<n && j<n ; i++ ,j++){
                    
                    pal[i][j]=pal[i+1][j-1];
                    if(s.charAt(i)!=s.charAt(j) )  pal[i][j]++; 
                }
            }
        return pal ;
            
    }
    
    public int recursion(String s  , int k  , int lo, int hi )
    {
        if(k==1){
            return minChange(s,lo,hi);
        }
        
        int ans=Integer.MAX_VALUE;
        for(int cut = lo ;cut <= hi-k+1 ; cut++ ){
                
                int val = minChange(s,lo,cut) + recursion(s, k-1, cut+1, hi ); 
                ans= Math.min(ans, val) ;
        }
        return ans;
        
    }
    public int memoize(String s  , int k  , int lo, int hi , int dp[][][] )
    {
        if(k==1){
            return dp[lo][hi][k]= minChange(s,lo,hi);
        }
        if(dp[lo][hi][k]!=-1)   return dp[lo][hi][k];
        
        
        int ans=Integer.MAX_VALUE;
        
        for(int cut = lo ;cut <= hi-k+1 ; cut++ ){
            
                dp[lo][cut][1]= minChange(s,lo,cut);
                
                int val = dp[lo][cut][1] + memoize(s, k-1, cut+1, hi ,dp  ); 
                ans= Math.min(ans, val) ;
        }
        return dp[lo][hi][k]=ans;
        
    }
     public int memoize_2(String s  , int k  , int lo, int hi , int pal[][] ,int dp[][])
    {
        if(k==1){
            return pal[lo][hi];
        }
        if(dp[lo][k]!=-1) return dp[lo][k];
        
        int ans=(int)1e8;
        
        for(int cut = lo ;cut <= hi-k+1 ; cut++ ){
            
                int val = pal[lo][cut]+ memoize_2(s, k-1, cut+1, hi ,pal ,dp  ); 
                ans= Math.min(ans, val) ;
        }
        return dp[lo][k]=ans;
        
    }
    
   

        public int palindromePartition(String s, int k) {
        
            // *************RECURSION SOLUTION 
            // FAITH -  THIS IS A STANDARD CUT PROBLEM IN WHICH HERE WE NEED TO UNDERSTAND FOLLOWING POINTS:
            // 1- WE NEED TO MAKE SOME VARIABLE CUTS BECAUSE HERE I DONT KNOW WHICH SUBSTRING WILL GIVE 
            // ME SMALLEST NO OF STRING CHANGES ; SO FOR THAT PURPOUSE I WILL MAKE A FAITH THAT I WILL CUT
            // STRING UPTO  JTH VARIABLE AND FROM 0TH INDEX TO JTH VARIABLE I WILL FIND MIN NO OF CHAR 
            // CHANGES AND REUCSSION WILL GIVE ME MIN NO OF CUTS FOR  JTH+1 TO STRINGS.LENGTH()-1 ;
            // 2- NOW AS JTH WAS VARIABLE SO WE NEED EXTRACT MIN NO ALL AND NEEED TO RETURN THAT
            // 3- HERE THAT WORK WHICH I HAVE TO WHILE MAKING A RECURSION CALL IS A SUBPROBLEM WHICH 
            // IS FIND MIN NO CHANGES OF CHARACTERS TO CHANGE TO MAKE STRING PALINDEROME 
            // 4- IN 2ND MEMOIZATINO METHOD I HAVE AN OBSERVATION THAT IN MEOIZATION 1 MY hi VALUES 
            // IS ALWAYS FIXED SO I DONT NEED TO STORE THAT SO THIS CAUSED REDUCTION IN MY SPACE COMPLEXITY
            // FROM O(N^3) TO O(N^2);
            // 1- IF THE LENGTH OF STRING IS N THEN TO  DIVIDE IT INTO K SETS WHAT I CAN SAY IS IF 
            
//         return recursion(s,k, 0 , s.length()-1);
            
            //*************TABULATIVE SOLUTION ************
            
//             int dp[][][]= new int[s.length()][s.length()][k+1];
//             for(int a[][] : dp ){
//                 for(int b[] : a ){
//                     Arrays.fill(b,-1);
//                 }
//             }
//             return memoize(s,k ,0  ,s.length()-1 ,dp );
            
            // MEMOIZATION METHOD -2 SPACE EFFICIENT A BIT 
            int n = s.length();
            int pal[][]= minChaneDp(s);
            int dp[][]=new int [n][k+1];
            for(int sub[] :  dp ){
                Arrays.fill(sub, -1 );
            }
            
            
            return memoize_2(s, k , 0 , s.length()-1, pal , dp );
            
            // return tabulation(s,k);
            
        }
}