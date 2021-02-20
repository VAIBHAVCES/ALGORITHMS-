class Solution {
    int dir[][]={{0,1},{0,-1},{-1,0},{1,0}};
    int n ; 
    public int swimInWater(int[][] grid) {
        // return rec(grid);
        
        // OBSERVE THESE BOTH PRIORITY SOLUTION CAREFULLY HOW   JUST BY CHANGING 2 LINES
        // WE HAVE REDUCED TIME COMPLEXITY SO MUCH THIS IS TRIVIAL  TO UNDERSTAND HOW 
        // WE REDUCED COMPLEXITY
        // return pqmethod2(grid);
        // return pqmethod(grid);
        return binarsearchMethod(grid);
    }
        
    public boolean dfsValidityCheck(int arr[][], boolean vis[][], int mid,int i , int j ){
        
        // System.out.println(" move  " +mid+" "+i+" "+j );
        if(i==n-1 && j==n-1 && arr[i][j]<=mid){
            return true;
        }
        if(arr[i][j] > mid )
                return false;
        vis[i][j]=true;
        boolean check = false;
        for(int move[] : dir){
            int r = i  + move[0];
            int c = j + move[1];
            
            if(r>=0 && c>=0 && r<n && c<n && !vis[r][c]){
               if( dfsValidityCheck(arr,vis,mid,r,c) ) return true;   
            }
        }
        // vis[i][j]=false;
        return check; 
        
    }
    public int binarsearchMethod(int arr[][] ){
        n = arr.length;
        int lo = 0 ; 
        int hi = n*n-1;
        int ans = hi;
         while(lo <= hi ){
             int mid =  (lo + hi)>>1;
             boolean vis[][]= new boolean[n][n];
             boolean resposne =  dfsValidityCheck(arr,vis,mid,0,0);
                 // System.out.println(lo+" "+hi+" "+mid);
             if(resposne ){
                 ans = mid;
                 hi = mid-1 ;
             }else{
                 lo = mid +1 ;
             }
         }
        return ans;
        
    }
    public int pqmethod2(int arr[][]){
        n = arr.length;
        int max = -1 ; 
        PriorityQueue<Integer>mem = new PriorityQueue<>((a,b)->{
            return arr[a/n][a%n] - arr[b/n][b%n];
        });
        boolean vis[][]=new boolean[n][n];
        mem.add(0);
        while(mem.size() > 0 ){
            int top = mem.remove();
            max =  Math.max(max, arr[top/n][top%n]);
            vis[top/n][top%n]=true;
            if(top/n==n-1 && top%n==n-1)
                    return max;
            for(int move[] :  dir){
                int r = top/n+move[0];                
                int c = top%n+move[1];
            // System.out.println("top : "+top+" : "+r+" "+c+" "+mem);
                if(r>=0 && c>=0 && r<n&& c<n && !vis[r][c]){
                    mem.add(r*n+c);
                }
            }
        }
        return max; 
    }
    public int pqmethod(int arr[][]){
        n = arr.length;
        int max = -1 ; 
        PriorityQueue<Integer>mem = new PriorityQueue<>((a,b)->{
            return arr[a/n][a%n] - arr[b/n][b%n];
        });
        boolean vis[][]=new boolean[n][n];
        mem.add(0);
        while(mem.size() > 0 ){
            int top = mem.remove();
            max =  Math.max(max, arr[top/n][top%n]);
            // vis[top/n][top%n]=true;
            if(top/n==n-1 && top%n==n-1)
                    return max;
            for(int move[] :  dir){
                int r = top/n+move[0];                
                int c = top%n+move[1];
            // System.out.println("top : "+top+" : "+r+" "+c+" "+mem);
                if(r>=0 && c>=0 && r<n&& c<n && !vis[r][c]){
                    vis[r][c]=true;
                    mem.add(r*n+c);
                }
            }
        }
        return max; 
    }
    public int rec(int arr[][] ) {
         n = arr.length;
         boolean vis[][]= new boolean[n][n];
         int dp[][]= new int[n][n];
         for(int sub[] :  dp ) Arrays.fill(sub , - 1);
         return rec_helper(arr,0,0,arr[0][0], vis, dp );
        
    }
    public int rec_helper(int arr[][],int x , int y , int t, boolean vis[][], int dp[][]){
        if(x== n-1 && y == n-1){
            return dp[x][y]  = Math.max(t, arr[x][y]);
        }
        if(dp[x][y]!=-1 && t>= dp[x][y])    
            return dp[x][y];
        
        
        vis[x][y]=true;
        int min = (int)1e9;
        for(int move[] :  dir){
            int i = x + move[0];
            int j = y + move[1];
            // System.out.println("    "+i+" , "+j+" : "+t);
            if(i >= 0 && j >=0 && i < n  && j <n  && !vis[i][j]){
                min = Math.min ( min , rec_helper(arr,i,j,Math.max(t,arr[i][j]), vis , dp));
            }
        }
        vis[x][y]=false;
        return dp[x][y]=min ;
    }
}