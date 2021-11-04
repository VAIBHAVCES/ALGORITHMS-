class Solution {

    // APROACH - IN THIS A SIMPLE BFS IS USED AS SOON AS WE ACHIEVE TARGET THAT
   // IS WHEN WE REACH TO [N-1][N-1]  INDEX THEN WE RETURN AT WHICH LEVEL THIS
   // VALUE WAS  
   //  WHY CAN'T WE USE DFS HERE ?
   // SIMPLE REASON ASSUME STANDING ON INITIAL YOU REACH TO A INDEX N-1,N-2 OR 
   //  N-2,N-1 NOW AT THIS POINT YOU FIND NO WAY (JUST A IMAGINARY POSITION) 
   //  THEN YOU WILL WAY TRAVERSE BACK YOUR WHOLE PATH AND IN VERY WORST CASE IT
   //  CAN PUSH YOUR COMPLEXITY TO O(N^4)


    int moves[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1} };
    public int bfs_soln(int graph[][] ){
        
        int n =  graph.length;
        int m = graph[0].length;
        if(graph[0][0]==1 || graph[n-1][m-1]==1 )   return -1 ;
        ArrayDeque<Integer>mem = new ArrayDeque<>();
        mem.addLast(0);
        graph[0][0]=1;
        int lvl= 1 ; 
        while(mem.size() > 0 ){
            
            int size= mem.size() ;
            while(size-- > 0 ){
                
                int top = mem.removeFirst();
                int x = top/m;
                int y = top%m;
                if(x==n-1 && y==m-1)    return lvl;
                for(int moves[] : moves){
                    int i = x+moves[0];
                    int j = y+moves[1];
                    if(i>=0 && j>=0 && i<n && j<m && graph[i][j]==0 ){
                        mem.addLast(i*m+j);
                        graph[i][j]=1;
                    }
                }
            }
            lvl++;
        }
        
    return  -1;
    
    }
    
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        return bfs_soln(grid);
        // return 0 ; 
    }
}