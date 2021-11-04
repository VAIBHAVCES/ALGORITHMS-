
import java.util.Arrays;
public class file2 {

    //************** UTILITY FUNCTIONS    ******************  */
    public static void print1d(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");

        }
        System.out.println();

    }
    public static void print2d(int arr[][]) {
        for (int sub[] : arr) {
            print1d(sub);
        }
    }
    public static void fill2d(int arr[][], int val) {

        for (int temp[] : arr) {
            Arrays.fill(temp, val);
        }
    }
    // *********************************************


    // ***************************************** CUT SET 
    
    public static int matrix_chain_rec(int arr[] , int lo, int hi ){

        if(lo+1==hi)
            return 0;
        int ans = Integer.MAX_VALUE; 
        for(int ul = lo+1; ul<hi ;ul++){
            ans = Math.min( ans , matrix_chain_rec(arr, lo , ul ) + matrix_chain_rec(arr, ul , hi) + arr[lo] *arr[ul] *arr[hi] );
        }
        return ans;
    }

    public static int matrix_chain_mem(int arr[] ,int lo , int hi , int dp[][] ){

        if(lo+1 == hi )
            dp[lo][hi]=0;

        if(dp[lo][hi]!=-1)
            return dp[lo][hi];

        int ans = Integer.MAX_VALUE;
        for(int ul = lo +1 ; ul < hi ; ul++)
        {
            ans = Math.min(ans , matrix_chain_mem(arr, lo, ul, dp)+ matrix_chain_mem(arr, ul,  hi, dp) +arr[lo]*arr[ul]*arr[hi]);
        }
        dp[lo][hi]=ans;
        return ans;
    }
   
    public static int matrix_chain_tab(int arr[] ){

        int n = arr.length;
        int dp[][]= new int[n][n];

        for(int gap= 1 ; gap < n;gap++){

            for(int i=0 , j =i+gap ; i<n && j<n ;i++ , j++){

                int min = Integer.MAX_VALUE;
                for(int temp = i+1 ; temp < j ; temp++ ){
                     min = Math.min(min , dp[i][temp]+dp[temp][j] +arr[i]*arr[temp]*arr[j] );
                }
                dp[i][j]=min==Integer.MAX_VALUE ? 0 : min;
            }
        }
        // print2d(dp);
        return dp[0][n-1];

    }

    
    public static void main (String args[ ]) {
	

	// ************* TEST CASES 
	
        // int arr[] = {10,30,5,60};
        // int arr[]  = {10, 20, 30}  ;
        // int arr[] = {40, 20, 30, 10, 30};
        // int arr[]= {10, 20, 30, 40, 30} ;
        
	// ***********FOR RECUSRION*************
	int ans =  matrix_chain_rec(arr , 0 , arr.length-1);
        
	//************ FOR MEMOIZATION***************
	int dp[][]= new int[arr.length][arr.length];
        System.out.println("recusrive ans :" +ans);
        fill2d(dp, -1);
	//*************** FOR TABULATION**************
        ans = matrix_chain_mem(arr, 0 , arr.length-1 ,dp );
        // print2d(dp);
        System.out.println("memoized ans : "+ans);
        ans = matrix_chain_tab(arr);
        System.out.println("tabulated ans : "+ans);
    }
}
