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
    public int targetSum_tab(int nums[] , int tar , int sum ){
        
        // DONE NOTHING JUST TRIED TO UNDERSTAND BEHAVIOUR OF DP IN MEMOIZATION
        // SEE THIS SAMPLE DP FOR [1,1,1,1,1] AND TAR = 3; 
        //0 0 0 0 0 1 0 0 0 0 0 
        //0 0 0 0 1 0 1 0 0 0 0 
        //0 0 0 1 0 2 0 1 0 0 0 
        //0 0 1 0 3 0 3 0 1 0 0 
        //0 1 0 4 0 6 0 4 0 1 0 
        //1 0 5 0 10 0 10 0 5 0 1 
        
        int dp[][]= new int[nums.length+1][2*sum+1];
        dp[0][sum]=1;
        for(int i=1; i <dp.length ;i++ ){
            for(int j=0;j<dp[0].length; j++){
                
                if( (j-nums[i-1]) >=0 ) 
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                if(j+nums[i-1] < dp[0].length )
                    dp[i][j]+=dp[i-1][j+nums[i-1]];
            }
        }
     
        for(int i=0; i<dp.length;i++){
            for(int ele : dp[i]) System.out.print(ele+  " ");
            System.out.println();
        }
        return dp[dp.length-1][tar];
    }
    public int findTargetSumWays(int[] nums, int S) {
        
        int sum=0 , n =nums.length;
        for(int ele : nums  )sum+=ele;
        
        if(sum < S || sum < -S){
            return 0;
        }
        // DP HERE WORKS IN  A WAY SIMILAR TO A NUMBER LINE 
        //  WE ARE CONSIDERING 0
        //***************** MEMOIZATION 
//         int dp[][]= new int[nums.length+1][2*sum+1];
        
//         for(int arr[] : dp )
//             Arrays.fill(arr,-1);
//         int ans = targetSum_mem(nums,  S+sum , n , sum , dp); 
//         return ans;
//         **************TABULATION 
            return targetSum_tab(nums,S,sum);
    }
}