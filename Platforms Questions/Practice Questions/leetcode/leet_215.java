class Solution {
    
    // *************** METHOD -1 - USING SIMPLE PQ O(NLOGk)
    public int method1(int[] nums, int k) {
        
            int n = nums.length;
            PriorityQueue<Integer>pq = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);
                if(pq.size()> k ){
                    pq.poll();
                }
            }
         return pq.poll();
            
            
     }
    //************* METHOD - 2- USING BUILHEAPIFY 0=- complexity to be exact 2n+klogn
    public void downheapify(int arr[] , int idx , int n ){
        
        int li = 2*idx+1;
        int ri = 2*idx+2;
        int max= idx;
        if(li <=n && arr[li]> arr[max] ) max =li;
        if(ri <=n && arr[ri]> arr[max] ) max =ri;
        
        if(max!=idx){
            
            swap(arr,max,idx);
            downheapify(arr,max,n);
        }
        
    }
    public void swap(int arr[] , int max , int idx ){
        
            int temp = arr[idx];
            arr[idx]= arr[max];
            arr[max]= temp ;
    }
    
    
    public int findKthLargest(int[] arr, int k) {
        // return method1(arr ,k );
        // ************* METHOD -2 
        int n =arr.length;
        // --------------BUILD HEAPIFY
        for(int i=n-1;i>=0;i--){
                 downheapify(arr,i,n-1);
        }
        
        //-------------- THIS IS SIMILAR TO PQ REMOVING 0TH ALWAYS GIVES MAX IN N-1-i ELEMENTS
        // =------------ COMPLEXITY KLOGN
        for(int i=0;i<k-1;i++){
            
            swap(arr,0,n-1-i);
            downheapify(arr,0,n-i-2);
                
        }
        return arr[0];
    }
}