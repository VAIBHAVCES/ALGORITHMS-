class Solution {
    static int moves[][] ={ {0,1},{0,-1},{1,0},{-1,0}};
    
    public int bfs_soln(int arr[][] ){
        
        ArrayDeque<Integer>bfs= new ArrayDeque<>();
        
        int n = arr.length;
        int m = arr[0].length;
        int ones =0 ;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    ones++;
                    if(i==0 || j ==0 || i==n-1 || j==m-1){
                        ones--;
                        bfs.addLast(i*m+j);
                        arr[i][j]=0;
                    }
                    
                }
                
            }
        }
        
        while(bfs.size() > 0 ){
            
            int top=bfs.removeFirst();
            int x = top/m;
            int y = top%m;
            
            for(int move[] : moves ){
                int i=x+move[0];
                int j=y+move[1];
                if(i>=0 && j>=0 && i<n && j<m && arr[i][j]==1){
                    arr[i][j]=0;
                    bfs.addLast(i*m+j);
                    ones--;
                }
            }
        
            
        }
        return ones;
        
        
    }

    
    public void dfs_marker(int arr[][] ,int i , int j ){
        
        int n = arr.length;
        int m = arr[0].length;
        arr[i][j]=0;
        for(int move[] : moves ){
            int x = i+move[0];
            int y = j+move[1];
             if(x>=0 && y>=0 && x<n && y<m && arr[x][y]==1){
                dfs_marker(arr,x,y);
             }
            
        }
    }
    public int dfs_soln(int arr[][] ){
        
        int n = arr.length;
        int m = arr[0].length;
        
        int ones =0 ;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    
                   
                    if(i==0 || j ==0 || i==n-1 || j==m-1){
                        dfs_marker(arr,i,j);
                    }
                    
                }
                
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    ones++;
                    }
                    
                }
                
            }
        
        return ones;
    }
    
    
    public int numEnclaves(int[][] arr) {
        // return bfs_soln(arr);
        return dfs_soln(arr);
        
    }
}