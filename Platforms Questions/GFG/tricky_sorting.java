class Solution{
    static int sortingCost(int N, int arr[]){
        // APROACH TOTTAL NO OF OPERATIONS = ARRAY LENGTH -
        //            NO OF ELEMENTS ALREADY IN A ASCENDING ORDER 
        int swaps = 0;
        int map[]=  new int[N+1];
        for(int i=0 ;i<arr.length;i++){
            map[arr[i]]=i;
        }
        int ans=0 , temp=1;
        for(int i=1; i<N;i++){
            // this conditions is basically  checking how many elems are already in a 
            // ascending order so tottal no of min  operations it would take to
            // turn this array into a sorted array would be equals to tottal no of 
            // elements minus no of elements already in a sorted order 
            
            
                temp++;
            }else{
               
                temp=1;
            }
             ans = Math.max(ans, temp) ;
            
        }
        return N-ans;
    }
}