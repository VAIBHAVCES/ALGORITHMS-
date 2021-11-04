class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int V)
    {
    
    
    // POINT TO BE NOTED - REMEMBER HERE WE NEED TO HANDLE MULTIPLE COMPONENTS OF GRAPH
    // ALSO  , IF THERE ARE MULTIPLE COMPONENETS AND IF ANY OF THE COMPONENTS HAVE CYCLE 
    // THEN YOU HAVE TO RETURN TRUE FOR WHOLE GRAPH.
   ArrayDeque<Integer>mem = new ArrayDeque<>();
   int idx=0;
     int i=0 ;
     int n = graph.size();
     boolean vis[] = new boolean[n];
     while(i < n ){
         

           mem.addLast(i);
           while(mem.size()> 0 ){
               
               int top = mem.removeFirst();
               if(vis[top]){
                   return true;
               }
               i++;
               vis[top]=true;
               for(int ele :  graph.get(top) ){
                   if(!vis[ele]) mem.addLast(ele);
               }
           }
       
     }
       return false;

    }
}