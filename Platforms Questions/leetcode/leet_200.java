class Solution {
    int moves[][]= {{-1,0},{1,0},{0,1},{0,-1}};
    public int dfs(int i, int j , char grid[][] , boolean vis[][]){
        
        if(grid[i][j]=='0' || vis[i][j]){
            return 0 ;
        }
        vis[i][j]=true;
        for(int move[] : moves ){
            int x = i+move[0];
            int y = j+move[1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
                dfs(x,y,grid,vis);
            }
        }
        return 0 ;
        
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        for(int i=0 ;i < grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j])
                {   ans++;
                    dfs(i,j,grid,vis );
                 }
            }
        }
        return ans;
        
    }
}