
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[]= new int[n];
	    dp[0]=arr[0];
	    int ans = 0;
	    for(int i=0; i < n; i++){
	        
	        int max = 0;
	        for(int j =0 ;j<i;j++){
	            if(arr[j] <  arr[i] ){
	                max = Math.max(dp[j] , max );
	            }
	        }
	        dp[i]=max+arr[i];
	        ans = Math.max(dp[i] , ans );
	    }
	    return ans;
	    
	}  
}