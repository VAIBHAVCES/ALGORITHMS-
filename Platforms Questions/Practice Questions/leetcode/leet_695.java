class Solution {
    static int moves[][]= {{-1,0},{0,1},{0,-1},{1,0}};
    public int dfs(int i , int j , boolean vis[][] , int grid[][] ){
        
        
        if(vis[i][j] || grid[i][j]==0)
                return 0 ; 
        vis[i][j]=true;
        int sum=0;
        for(int move[] : moves){
            int x  = i+move[0];
            int y  = j+move[1];
            if(x< grid.length && y < grid[0].length && x>=0 && y>=0) 
                    sum+= dfs(x,y,vis,grid);
        }
        return sum+1;
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean vis[][]= new  boolean[grid.length][grid[0].length];
        int  max = 0;
        for(int i=0 ; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j]!=0 && !vis[i][j])
                    max = Math.max(max, dfs(i,j,vis ,grid) );
            }
        }
        return max;
    
    }
}