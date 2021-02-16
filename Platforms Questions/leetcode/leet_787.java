class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // GRAPH BUILDING PROCEDURE 
        ArrayList<int[]>[]graph= new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i< flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph[u].add(new int[]{v,w});
            
        }
        // BFS AREA 
        
        k++;
        PriorityQueue<int[]>mem= new PriorityQueue<>( (a,b)->{
            return a[1]-b[1];
        });
        
        mem.add(new int[]{ src , 0 , k } );
        // top[0] -> vtx  , top[1]-> wsf , top[2]-> k
        
        while(mem.size() >  0 ){
            int top[]= mem.remove();
            if(top[2] < 0 ) continue; 
            if(top[0]==dst ) return top[1];
            for(int child[] :  graph[top[0]] ){
                
                    mem.add(new int[]{child[0], top[1]+child[1] , top[2]-1  });
            }
        }
    return -1 ;
    
    }
}

