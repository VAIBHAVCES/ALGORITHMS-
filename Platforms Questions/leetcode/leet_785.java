class Solution {
    
    public boolean bfs_bipartite_check(int vis[] , int src , int graph[][]){
        
        
        ArrayDeque<int[] >mem = new ArrayDeque<>();
        mem.add(new int[]{src,0});
        while(mem.size() > 0 ){
            
                int size= mem.size();
                while(size-- > 0 ){
                    
                        int top[] = mem.removeFirst();
                        if(vis[top[0]] == -1) {
                            vis[top[0]]=top[1];

                        }else{
                            if(vis[top[0]] != top[1])   return false;
                            continue;
                        }
                        for(int i=0; i < graph[top[0]].length;i++){
                            if(vis[ graph[top[0] ][i] ]==-1){
                                mem.addLast(new int[]{graph[top[0]][i] , (top[1]+1)%2 });
                            }
                        }

                }
            
            }
        
        return true;
    }
    //  method -2 logic same just tried saving some space by maintainaing level instead of a pair 
    public boolean bfs_bipartite_check02(int vis[] , int src , int graph[][]){
        
        
        ArrayDeque<Integer >mem = new ArrayDeque<>();
        mem.addLast(src);
        int lvl =0 ;
        while(mem.size() > 0 ){
                int size= mem.size();
                while(size-- > 0 ){
                    
                        int top= mem.removeFirst();
                        if(vis[top] == -1) {
                            vis[top]= lvl%2;

                        }else{
                            if(vis[top] != lvl%2 )   return false;
                            continue;
                        }
                        for(int i=0; i < graph[top].length;i++){
                            if(vis[ graph[top][i] ]==-1){
                                mem.addLast(graph[top][i]);
                            }
                        }

                }
            lvl++;
            
            }
        
        return true;
    }
    
    
    
    public boolean bfs_soln(int graph[][] ){
        int n = graph.length;
        int vis[]= new int[n];
    
        Arrays.fill(vis,-1);
        for(int i=0 ;i <n ; i++){
            if(vis[i]==-1){
                // line 39 - if any component is not bipratitte return false asap
                // if(  ! bfs_bipartite_check(vis,i,graph)  ) return false;
                if(  ! bfs_bipartite_check02(vis,i,graph)  ) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
       return bfs_soln(graph);
       
    }
}