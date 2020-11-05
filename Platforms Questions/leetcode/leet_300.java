class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
                return 0;
        // ******** RECURSION *********
        // return lis_rec(nums , 0 ,Integer.MIN_VALUE ,0 );
        // **************TABULATION************
        return lis_tab(nums);
    }
    public int lis_rec(int nums[] , int idx , int prev ,int lsf ){
        if(idx==nums.length)
        {
            return lsf;
        }int ans =0;
        
        for(int i=idx ;i <nums.length;i++){
            if(nums[i] > prev)
            ans=Math.max(ans, lis_rec(nums, i+1 , nums[i] , lsf+1));
        }
        // ******** TRIVIAL - WHY DON'T I SIMPLY RETURNED ans HERE AND USE SOMETING ELSE ?
        //   ANS-- SUPPOSE THERE IS A TESTCASE AT WHICH ANSWERS IS MADE AT ith INDEX AND
        //   I HAVEN'T MADE ANY CALL TO ANY ELEMENT IN FRONT OF ME THEN IN THIS CASE WE 
        //   WILL BE RETURNING A VALUE OF 0 WHICH IS WRONG SO IF THERE IS NO RECUSRIVE CALL
        //   IS MADE I HAVE A ALREADY BUILD ANS CALLED lsf WHICH IS NEED TO BE RETURNED
        return ans==0 ? lsf : ans;
    }
    public int lis_tab(int nums[] ){
        int dp[] = new int[nums.length];
        
        for(int i=0;i < dp.length;i++){
            int ans=0;
            for(int j=0;  j < i; j++){
                if(nums[i] > nums[j] && dp[j] >ans  ) ans=dp[j];
            }
            dp[i]= ans+1;
        }
        return dp[dp.length-1];
        
    }
}