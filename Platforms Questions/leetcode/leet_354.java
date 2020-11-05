class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
//       TO BE COMPLETED =
        // 1-  NLOGN APROACH OF LIS USING HASHMAPS    -------------NOT DONE 
        // 2- N^2 APROACH USING LIS ARRAYS ------------DONE 
        
    // APROACH - INTUTION BEHIND THIS QUESTION IS THAT FIRSTLY THESE FOLDERS ARE GIVEN IN UNSORTED ORDER
    // SO INITIALLY WE SHOULD SORT IT SO THAT WE CAN  UNIFORMY OBSERVE THE DIMENSIONS NOW WHEN THEY ARE SORTED
    // WHAT I CAN SAY IF I AM AT ith ARRAY then ITS 100% SURITY that envelope[i+1][0]  will always be grater than 
    // envelope[1][0] BECAUSE THEY ARE SORTED . SO ONLY WORK LEFT NOW IS THAT IN SOME WAY IF WE CAN FIND A INCREASING
    // SUBSEQUENCE  WE CAN FIND NON OVERLAPPING FOLDERS IMP CONDITIONS TO REMEBER HERE ARE : -
    // 1- EQUAL LENGTH POINTS ARE INVALID ONLY  ONE OF THEM WILL BE CONSIDERED IN LIS 
    // 2- TWO DIFFERENT LENGTH BUT SAME BREADTH WILL ALSO BE INVALID 
          
    Arrays.sort(  envelopes , ( a , b )->{ 
        if(a[0]-b[0] ==0 ){
            return a[1]-b[1];
        } else if(a[0]-b[0]>0 ) return 1;
        else   return -1 ;

    } ); 
        
        
        int ans = 0;
        int dp[] = new int[envelopes.length];
        for(int i=0 ;i <envelopes.length ;i++) {
            
            int max = 0;
            for(int j=0;j <i ;j++){
                if(envelopes[i][0]!=envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) max = Math.max(dp[j] , max );
            }dp[i]= max +1;
            
            ans = Math.max(ans , dp[i]);
        }
        
        return ans ;
        
    }
}