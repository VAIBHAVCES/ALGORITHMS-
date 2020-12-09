class Solution {
    public int[] usingPQ(int arr[] , int k ){
        
        int n =arr.length;
        int ans[]= new int[n-k+1];
        PriorityQueue<int[]>mem = new PriorityQueue<>((a,b)->{
            return b[0]-a[0];
        });
        for(int i=0;i<k;i++) mem.add(new int[]{arr[i],i});
        for(int i=0; i<ans.length;i++){
            
            // remove
            while(mem.peek()[1] < i){
                mem.poll();
            }
            //place 
            ans[i]=mem.peek()[0];
            // add 
            if(i+k < arr.length)
                mem.add(new int[]{arr[i+k],i+k});
                
        }
        return ans;
    }
    public int[] usingArrays(int arr[] , int k ){
        int n =arr.length;
        ArrayDeque<Integer>mem = new ArrayDeque<>();
        int ans[] = new int[n-k+1];
        int idx=0;
        for(int i =0 ; i< n ; i++ ){
            while(mem.size()!=0 && i-k >= mem.getFirst() ) mem.removeFirst();
            while(mem.size()!=0 && arr[mem.getLast()] <=arr[i]) mem.removeLast();
            
            mem.addLast(i);
            if(i  >=k-1 ) ans[idx++]= arr[mem.getFirst()];
        }
        return ans;
        
        
    }
    public int[] maxSlidingWindow(int[] arr, int k) {
        // return usingPQ(arr , k );
         return   usingArrays(arr ,k );
        
    }
}