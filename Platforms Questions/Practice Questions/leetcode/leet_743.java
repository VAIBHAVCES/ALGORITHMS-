class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<int[]>graph[] = new ArrayList[n];
        for(int i=0; i<n;i++){
            graph[i]= new ArrayList<>();
        }
        for(int sub [] : times  ){
            graph[sub[0]-1].add(new int[]{sub[1]-1,sub[2]});
        }
        PriorityQueue<int[]>mem= new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        mem.add(new int[]{k-1,0 });
        int dis[] = new int[n];
        Arrays.fill(dis, (int)1e9);
        while(mem.size() > 0 ){
            int top[] = mem.remove();
            for(int[] edge  : graph[ top[0] ]){
                if(edge[1]+top[1] <  dis[edge[0]]){
                    
                    dis[edge[0]]=edge[1]+top[1];
                    mem.add(new int[]{edge[0] , edge[1]+top[1] });
                }
            }
            
        }
        int ans = 0 ; 
        dis[k-1]=0;
        for(int i=0;i<dis.length;i++){
            System.out.println(dis[i]);
            if(dis[i]==(int)1e9) return -1; 
            ans = Math.max(ans, dis[i]);
        }return ans;
        
    }
}