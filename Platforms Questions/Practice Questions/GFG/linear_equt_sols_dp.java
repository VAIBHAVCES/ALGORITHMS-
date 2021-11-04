import java.util.Arrays;
class linear_equt_sols_dp{


    // *************PROBLEM LINK :  -
    // https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
  
    public static int linear_equt_rec(int arr[], int consta, int idx) {

        if (idx == arr.length) {
            if (consta == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int sol = 0;
        for (int i = 0; i <= consta / arr[idx]; i++) {
            sol += linear_equt_rec(arr, consta - i * arr[idx], idx + 1);
        }
        return sol;

    }

    public static int linear_eq_mem(int arr[], int consta, int idx, int dp[][]) {

        if (consta == 0) {
            return dp[idx][consta] = 1;
        }
        if (idx >= arr.length && consta != 0) {
            return dp[idx][consta] = 0;
        }
        if (dp[idx][consta] != -1)
            return dp[idx][consta];
        int sol = 0;
        for (int val = 0; val <= consta / arr[idx]; val++) {
            if (consta - arr[idx] * val >= 0) {
                sol += linear_eq_mem(arr, consta - arr[idx] * val, idx + 1, dp);
            }

        }
        return dp[idx][consta] = sol;
    }
    public static int linear_eq_tab(int arr[] , int consta ){

        int dp[][]= new int[arr.length+1][consta+1];
        Arrays.fill(dp[arr.length] , 0 );
        dp[arr.length][0]=1;

        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<=consta;j++){

                int sol=0;
                for(int x=j;x>=0;x-=arr[i]){
                    sol+=dp[i+1][x];
                }
                dp[i][j]=sol;
            }
        }
        return dp[0][dp[0].length-1];


    }
  
    
    public static void main(String args[] ) {

	// Recursive soluton implementation
	int coeff[] = { 1, 2, 3 }, consta = 6;
        int ans = linear_equt_rec(coeff, consta, 0);
        
	// REGION -2 FOR MEMOIZATION AND TABULAITON
	int dp[][] = new int[coeff.length + 1][consta + 1];
	// 0 is also a viable ans in dp (memoization ) so prefer to fill with -1
	for(int dub[] : dp ){
		Arrays.fill(dub,-1);
    }
    int ans_mem = linear_eq_mem(coeff, consta, 0, dp);
    // TABULATED ANSWER
    int ans_tab = linear_eq_tab(coeff,consta);
    
    System.out.println("rec ans : " + ans + " , mem ans :  " + ans_mem+ " tabulated ans : "+ans_tab);
	

	}

}