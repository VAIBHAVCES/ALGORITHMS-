class Solution {
    public int usingArrays_n2_tc(int arr[] ,int difference) {
        int dp[]= new int[arr.length];
        int ans =0 ;
        for(int i = 0 ; i<arr.length;i++){
            
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j]== arr[i]-difference){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i]=max+1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        
    
    }
    public int longestSubsequence(int[] arr, int difference) {
        
        
        //  APROACH =  OUR BASIC AIM IS TO USE TO CONCEPT SIMILAR TO LONGEST INCREASING SUBSEQUENCE AS PER WHICH 
        // FROM PREVIOUS IF WE CAN MAKE CALL ARR[I]-DIFFERENCE ELEMENT WHICH THIS WILL GIVE US MAX LENGTH OF ARRITHEMATIC 
        // SEQUENCE OF GIVEN DIFFERENCE BUT DOING THIS WAS GIVING US TIMME COMPLEXITY OF O(N^2) SO TO OPTIMIZE IT TO 
        // LINEAR TIME COMPLEXIT WE OPTIMIZED IT USING HASHMAP
        int dp[]= new int[arr.length];
        int ans =0 ;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0 ; i<arr.length;i++){
            
            int max = 0;
            int temp = map.getOrDefault(arr[i]-difference , 0 )+1;
            map.put ( arr[i] , temp);
            ans = Math.max(ans , temp);
        }
        return ans;
        
    }
}