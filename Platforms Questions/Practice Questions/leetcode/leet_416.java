class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        // return rec(nums,0,sum,0);
        return tab(nums,sum);
    }
    public boolean rec(int nums[] , int ss , int bs ,  int idx){
        
        if(ss < 0 || bs < 0)
                return false;
        if(ss==bs){
            return true;
        }
        if(idx==nums.length){
            if(ss==bs)
                return true;
            else return false;
        }
        boolean ans = false;
        //include
            ans = ans || rec(nums, ss+nums[idx] , bs-nums[idx] , idx+1);
        //not include
            ans = ans || rec(nums,ss,bs,idx+1);
        
        return ans;
    }
    // using knapsack(i)
    public boolean tab(int  nums[] ,int sum){
	// APROACH = WHAT IS MY APROACH ? 
	// FIRST THING FIRST TO DIVIDE IT INTO 2 EQUIVALENT PAIRS OF VALUES
	// I CAN SAY THAT IF SUM OF ALL ELEMS IS ODD THEN IT IS NOT POSSIBLE TO 
	// DIVIDE IT INTO TWO HALVES
	// NOTATION-2 - IF SOMEHOW I CAN FIGURE OUT A OPTIMAL WAY TO FINF THAT SUM 
	// OF ARRAY DIVISIBLE BY 2 CAN BE FORMED USING SOME OF ELEMENTS OF ARRAY SO
	// THEN CONCLUDE THAT OTHER HALF IS ALSO OF SAME VALUE AND HENCE MY RESULT
	// IS TRUE AND WHENEVER WE NEED TO FIND A TARGET VALUE FROM MULTIPLE VALUES
	// WE PREFER TO USE KNAPSACK (0-1)

        
        if(sum%2!=0)
                return  false;
        
        int n = nums.length;
        int target = sum/2;
        boolean dp[][]= new boolean[n+1][target + 1];
        for(int i=0; i<dp.length;i++){
            dp[i][0]=true;
        }
        
        for(int i=1; i<=n;i++){
            for(int j=1; j<=target;j++){
                boolean ans = false;
                ans = ans || dp[i-1][j];
                if(j-nums[i-1]>=0){
                    ans=  ans || dp[i-1][j-nums[i-1]];
                }
                dp[i][j]=ans;
            }
            
        }
        
        // for(boolean sub[] : dp){
        //     for(boolean ele: sub){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }
        return dp[nums.length][target];
        
    }
    
}