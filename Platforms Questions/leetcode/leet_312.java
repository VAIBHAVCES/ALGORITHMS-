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
    public static int burst_baloons_tab(int arr[] ){

        int n = arr.length;
        int dp[][]= new int[n][n];
        for(int gap =0 ; gap<n;gap++){

            for(int i=0 , j= i+gap ;i<n&& j<n;i++,j++){
                int lval = i-1>=0 ? arr[i-1] :1;
                int rval = j+1<n ? arr[j+1] :1;
                 
                if(gap==0){
                    dp[i][j]= lval*arr[i]*rval;
                    continue;
                }else{

                    int max_coins = Integer.MIN_VALUE;
                    for(int cut = i; cut <= j ; cut++){
                        int left =  i >cut-1 ?0 : dp[i][cut-1];
                        int right = cut+1 > j ?0 : dp[cut+1][j];
                        int myAns= left+ lval*arr[cut]*rval + right ;
                        max_coins = Math.max(max_coins , myAns);
                    }
                    dp[i][j]=max_coins;
                }
            }

        }

        // print2d(dp);
        return dp[0][n-1];
    }
    public int maxCoins(int[] arr) {
        if(arr.length==0)
                return 0; 
        // return burst_baloons_mem(arr,0,arr.length-1,new int[arr.length][arr.length]);
            // return 0;
        return burst_baloons_tab(arr);    
    }
}