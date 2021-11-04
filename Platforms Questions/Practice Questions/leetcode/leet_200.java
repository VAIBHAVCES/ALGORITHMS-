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
    public int dfs_soln(char[][]grid){
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
    
    public int myParent(int parent[] , int p ){
        if(parent[p]==p)    return p;
        else return parent[p] = myParent(parent,parent[p]);
    }
    public int unionFindSoln(char grid[][] ){
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        int parent[]= new int[n*m];
        for(int i=0;i<parent.length;i++) {
            if(grid[i/m][i%m]=='1') count++;
            parent[i]=i;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                    if(grid[i][j]=='1'){

                        int p1 = myParent(parent,i*m+j);
                        
                        if(i+1<n && grid[i+1][j]=='1'){
                            int p2 = myParent(parent , (i+1)*m+j );
                            if(p1!=p2)
                            { 
                                parent[p2]=p1;
                                  count--;
                            }
                        }
                        if(j+1<m && grid[i][j+1]=='1'){
                            int p2 = myParent(parent,i*m+(j+1));
                            if(p1!=p2)
                            { 
                                parent[p2]=p1;
                                  count--;
                            }
                        }
                    }
                    
                    
                }
            }
            return count;
        
        }
    

    public int numIslands(char[][] grid) {
       // return dfs_soln(grid);
        return unionFindSoln(grid);   
        // return 0;
    }
}