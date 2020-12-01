//************ MY FREE ADVICE FOR THIS QUESTION HERE IS THAT
// ON LEETCODE IT IS SUBMITTING BEST WITH QUICK SORT IDK WHY 


class Solution {
    public int[][] usingPriorityQueue(int [][]arr , int K){
      
            PriorityQueue<int[]>mem = new PriorityQueue<int[]>( (a,b)->{

                double dist1= Math.sqrt( Math.pow(0-a[1], 2 ) +  Math.pow(0-a[0], 2 ) );
                double dist2= Math.sqrt( Math.pow(0-b[1], 2 ) +  Math.pow(0-b[0], 2 ) );
                if(dist1-dist2 > 0 ) return 1; 
                else if(dist1-dist2 ==0)    return 0;
                else return -1;
                }  
            );
            for(int i=0;i<arr.length;i++){
               int sub[] = arr[i];
               mem.add(sub);
            }
            int i=0;
            int ans[][]=new int[K][2];
            while(K-->0){
                
                ans[i++]=mem.poll();
            }
        return ans;
    }
    //************ METHOD -2 = USING HEAP 
    public int compareTo(int li , int ri , int arr[][] ){
     
        double dist1= Math.sqrt( Math.pow(0-arr[ri][0], 2 ) +  Math.pow(0-arr[ri][1], 2 ) );
        double dist2= Math.sqrt( Math.pow(0-arr[li][0], 2 ) +  Math.pow(0-arr[li][1], 2 ) );
        int ans = -1;
        if(dist1-dist2 >0 ) ans= 1;
        else if(dist1-dist2==0 ) ans= 0 ;
        return ans;
    }
    public void downheapify(int arr[][] ,  int idx ,int n ){
        
        int li = idx*2+1;
        int ri = idx*2+2;
        int max = idx;
        if(li<=n && compareTo(li,max,arr) > 0  ) max = li;
        if(ri<=n && compareTo(ri,max,arr) > 0  ) max = ri;
        if(max !=idx){
            int temp[] = arr[max];
            arr[max]=arr[idx];
            arr[idx]=temp;
            downheapify(arr,max,n);
        }
        
    }
    
    //*********** METHOD -3 USING  SIMPLE SORTING AND EXTRACOIN
    public int[][] simpleSorting(int points[][] , int k ){
        Arrays.sort(points,(a,b)->{
            return (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]);
        });
        int ans[][]=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=points[i];
            
        }return ans;
    }
    public int[][] kClosest(int[][] arr, int K) {
    
        
        // return usingPriorityQueue(arr,K);
        // METHOD -2  CALLING AREA
            // |
            //  -->BUILD HEAPIFY 
    //         int n = arr.length-1;
    //         for(int i=n ; i>=0 ;  i-- )  {
    //             downheapify(arr, i ,n );

    //         int ans[][]= new int[K][2];
    //         for(int i=0; i<K;i++){

    //             ans[i]=arr[0];
    //             int temp[] = arr[0];
    //             arr[0]=arr[n-i];
    //             arr[n-i]=temp;
    //             downheapify(arr,0,n-i-1);
    //         }
    //         return ans;
        // METHOD -2 USING SIMPLE SORTING 
        return simpleSorting(arr,K);
    }
}