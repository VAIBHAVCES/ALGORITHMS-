// ******************gfg min cost to connect all CITIES
public static int primsAlgoMinCost(int arr[][]){

    // ArrayDeque<int[]>= new ArrayDeque<>();
    // mem.top()[0] -  vtx 
    // mem.top()[1] - par 
    // mem.top()[2] - weight
    PriorityQueue<int[]>mem=new PriorityQueue<>( (a,b)->{
        return a[2]-b[2];
    }) ; 
    mem.add(new int[] { 0 , -1, 0});
    int ans =0 ;
    boolean vis[]= new boolean[arr.length];
    int  nn = 1;
    while(mem.size() > 0){
        int top[]= mem.remove();
        if(vis[top[0]]){
            continue;
        }
        ans+=top[2];
        vis[top[0]]=true;
        nn++;
        for(int i = top[0]+1 ; i < arr[0].length ;i++){
            if(arr[top[0]][i] >0 && !vis[i] ){
                mem.add(new int[]{i,top[0], arr[top[0]][i] });
            }
        }
    }
    return ans;

}



public static void minCostCities(){

    int arr[][]= {{0, 1, 1, 100, 0, 0},
    {1, 0, 1, 0, 0, 0},
    {1, 1, 0, 0, 0, 0},
    {100, 0, 0, 0, 2, 2},
    {0, 0, 0, 2, 0, 2},
    {0, 0, 0, 2, 2, 0}};
    System.out.println(primsAlgoMinCost(arr));


}
