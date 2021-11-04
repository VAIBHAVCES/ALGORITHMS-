class solve{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        
        
        int si=0 ,   ei =0 ;
        ArrayDeque<Integer>mem=new ArrayDeque<>();
        ArrayList <Integer> ans = new ArrayList <Integer> ();
        while(ei < arr.length ) {
            
            if(ei- si < k ){
                while(mem.size()>0 &&  arr[mem.peekLast()] <arr[ei])
                {
                    mem.removeLast();
                }
                mem.addLast(ei++);
                
            }  
            if(ei-si==k){
                ans.add(arr[mem.peekFirst()]);
                si++;
                while(mem.size() > 0 && mem.peekFirst() < si){
                    mem.removeFirst();
                }
                
            }
            
        }
        return ans;
        
    }
}