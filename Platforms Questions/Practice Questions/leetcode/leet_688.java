class Solution {
    
    static int moves[][]={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public double recursion(int n , int k , int r , int c ){
        
        if(k==0)
        {
            return 1 ;
        }
        
        double sum = 0;
        for(int mov[] : moves ){
            int x =r+mov[0];
            int y = c+mov[1];
            if( x>=0 && y>=0 && x<n && y<n  )
                sum+= recursion( n, k-1, x , y );
        }
        sum/=8;
        return sum;
        
    }
    
    public double memoizatoin(int n , int k , int r , int c  ,  double dp[][][]){
        
        if(k==0)
        {
             return dp[k][r][c]= 1 ;
        }
        if(dp[k][r][c]!=0)
                return dp[k][r][c]; 
        
        double sum = 0;
        for(int mov[] : moves ){
            int x =r+mov[0];
            int y = c+mov[1];
            if( x>=0 && y>=0 && x<n && y<n  )
                sum+= memoizatoin( n, k-1, x , y ,dp);
        }
        sum/=8;
        return dp[k][r][c]= sum;
        
    }
    
    
    public double knightProbability(int N, int K, int r, int c) {
         // return recursion(N, K, r,c);
        //  ************ MEMOIZATOIN *********
        double dp[][][]= new double[K+1][N+1][N+1];
        return memoizatoin(N,K,r,c,dp);
        // return 0 ;
    }
}