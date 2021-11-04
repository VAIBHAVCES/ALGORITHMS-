class Solution {

     int moves[][]= {{-1,0},{1,0},{0,1},{0,-1}};
    public int dfs(int i, int j , int grid[][] , boolean vis[][]){

        if(  i <0 || j <0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0  ){
            return 1;
        }
        if( vis[i][j])
            return 0;    
        vis[i][j]=true;
        int  sides =0;
        for(int move[] : moves ){
            int x = i+move[0];
            int y = j+move[1];
    
                sides+=dfs(x,y,grid,vis);
            
        }
        return sides ;

    }
    public int islandPerimeter(int[][] grid) {
        
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        for(int i=0 ;i < grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j])
                {   
                    return dfs(i,j,grid,vis );
                }
            }
        }
        return 0 ;
        
    }
}