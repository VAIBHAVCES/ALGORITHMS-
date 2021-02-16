class Solution {
    public int trapRainWater(int[][] arr) {
        // MT APROACH HERE IS BASICALLY FIRST OF ALL I HAVE ADDED 
        // ALL BORDER ELEMENTS IN A PRIORTY QUEUE AND HAVE WRITTEN A 
        // COMPARRATOR ON BASED OF THEIR HEIGHTS NOW WHAT I KNOW IS EVERY
        // TIME I POP A ELEMENT FROM PQ THIS WILL BE THE SMALLEST IN TERMS 
        // OF HEIGHT AND WHILE POPING ELEMENTS I AM MAINTAINIG A VALUE MAX WHICH
        // CAN BECAME A BORDER WALL FOR SMALLER HEIGHTS,  IN SHORT IF MY POPPED
        // ELEMENTS IS SMALLER THAN MAX THEN IT SHOWS THAT MY MAX ELEMENT IS 
        // ACTING AS A SMALLEST BORDER ELEMENT  AND ONLY THAT MUCH OF WATER CAN
        // BE PLACED ABOVE THIS ELEMENT
        
        int n = arr.length , m = arr[0].length;
        PriorityQueue<Integer>mem = new PriorityQueue<Integer>((a,b)->{
            return arr[a/m][a%m] - arr[b/m][b%m] ;
        });
        boolean vis[][]=new boolean[n][m];
        
        for(int i=0; i<n;i++){
            for(int j =0 ;j<m ; j++){
                if(i==0 || j==0 ||  i==n-1|| j==m-1){
                    mem.add(i*m+j);
                    vis[i][j]=true;
                }
            }
        }
        int dir[][]= new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int water =0 , max  = 0;
        while(mem.size() > 0 ){
            int top = mem.remove();
            int x  = top/m;
            int y = top%m;
            max =  Math.max(max, arr[x][y]);
            water+= Math.max(0 ,  max -arr[x][y]);
            
            for(int move[] :  dir){
                int i = x + move[0];
                int j = y + move[1];
                if(i>0 && j>0 && i<n && j<m && !vis[i][j]){
                    mem.add(i*m+j);
                    vis[i][j]=true;
                }
                
            }
            
        
    }
        return water;
}
}