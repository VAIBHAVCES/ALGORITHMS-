class Solution {
     public  int burst_baloons_rec(int arr[] , int lo , int hi ){

        if(lo > hi)
            return 0;

        int lival= lo-1<0 ? 1 : arr[lo-1];
        int rival= hi+1>=arr.length ? 1 :arr[hi+1];
        int max_coins = Integer.MIN_VALUE;
        for(int cut = lo ; cut <= hi ; cut++){
            int left =burst_baloons_rec(arr, lo, cut-1);
            int right =  burst_baloons_rec(arr, cut +1, hi);
            int myAns= left+ lival*arr[cut]*rival + right ;
            max_coins = Math.max(max_coins , myAns);
        }
        return max_coins ;
    }
    public  int burst_baloons_mem(int arr[] , int lo , int hi ,int dp[][] ){

        if(lo > hi)
            return 0;
        if(dp[lo][hi]!=0)
            return dp[lo][hi];
        
        int lival= lo-1<0 ? 1 : arr[lo-1];
        int rival= hi+1>=arr.length ? 1 :arr[hi+1];
        int max_coins = Integer.MIN_VALUE;
        for(int cut = lo ; cut <= hi ; cut++){
            int left =burst_baloons_mem(arr, lo, cut-1 ,dp );
            int right =  burst_baloons_mem(arr, cut +1, hi ,dp );
            int myAns= left+ lival*arr[cut]*rival + right ;
            max_coins = Math.max(max_coins , myAns);
        }
        return dp[lo][hi]= max_coins ;
    }

    public int maxCoins(int[] arr) {
        return burst_baloons_mem(arr,0,arr.length-1,new int[arr.length][arr.length]);
            // return 0;
        }
}