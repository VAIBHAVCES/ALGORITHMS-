class Solution {
    public int targetSum_rec(int nums[] , int tar , int idx ){
        
        if(idx==nums.length ){
            if(tar==0)
                    return 1;
            return 0;
        }
            
        int neg= targetSum_rec(nums,tar-nums[idx] ,idx+1);
        int pos= targetSum_rec(nums,tar+nums[idx] ,idx+1);
        return neg+pos;
        
    }
    public int targetSum_mem(int nums[] , int tar , int n ,int sum , int dp[][]){
        
        if(n==0){
            if(sum==tar)
               return dp[n][sum]=1;
            return dp[n][sum]=0;
        }
        if(dp[n][sum]!=-1)  return dp[n][sum];
       
        int count=0;
        
        count+= targetSum_mem(nums,tar , n-1, sum-nums[n-1] ,dp );
        count+= targetSum_mem( nums,tar , n-1  ,sum +nums[n-1], dp );
        return dp[n][sum]=count;
        
    }
    public int findTargetSumWays(int[] nums, int S) {
        
        int sum=0 , n =nums.length;
        for(int ele : nums  )sum+=ele;
        
        if(sum < S || sum < -S){
            return 0;
        }
        // DP HERE WORKS IN  A WAY SIMILAR TO A NUMBER LINE 
        //  WE ARE CONSIDERING 0
        int dp[][]= new int[nums.length+1][2*sum+1];
        
        for(int arr[] : dp )
            Arrays.fill(arr,-1);
        int ans = targetSum_mem(nums,  S+sum , n , sum , dp); 
        return ans;
    }
}