
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
    public static void print3d(int arr[][][] ){
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j][0]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j][1]+" ");
            }
            System.out.println();
        }
    } 
    // *********************************************
    

    // ***************************************** CUT SET 
    public static class Pair{

        int val;
        String st;
        Pair(int x, String y ){
            val= x;
            st = y;
        }
    }

 

    // print bracket configuration of matrix chain multiplication
    public static Pair matrix_chain_rec_bracks(int arr[] , int lo, int hi ){

        if(lo+1==hi)
            return new Pair(0,(char)('A'+lo) +"");
        int ans = Integer.MAX_VALUE; 
        String myAns="";
        for(int ul = lo+1; ul<hi ;ul++){
            Pair left=  matrix_chain_rec_bracks(arr, lo , ul );
            Pair right = matrix_chain_rec_bracks(arr, ul , hi);
            int temp = left.val+ right.val + arr[lo] *arr[ul] *arr[hi] ;
            if( temp < ans ){
                ans = temp;
                myAns="("+left.st+right.st+")";

            }
        }
        return new Pair(ans, myAns);
    }
    public static Pair matrix_chain_tab_bracks(int arr[] ){

        int n = arr.length;
        int dp[][]= new int[n][n];
        String sdp[][]= new String[n][n];

        for(int gap= 1; gap < n;gap++){

            
            for(int i=0 , j =i+gap ; i<n && j<n ;i++ , j++){

                if(gap==1){
                    String baseCase=(char)('A'+i) +"";
                    sdp[i][j]=baseCase;
                    continue;
                }else{
                    int min = Integer.MAX_VALUE;
                    String myAns="";
                    for(int temp = i+1 ; temp < j ; temp++ ){
                
                        int ourAns= dp[i][temp]+dp[temp][j] +arr[i]*arr[temp]*arr[j];
                        if(ourAns < min ){
                            min = ourAns ;
                            myAns="("+sdp[i][temp] +sdp[temp][j] +")";
                        }
                        sdp[i][j]=myAns;
                    }
                    dp[i][j]=min==Integer.MAX_VALUE ? 0 : min;
                    
                }
            }
        }
        // print2d(dp);
        return new Pair( dp[0][n-1] , sdp[0][n-1] ) ;

    }
        



    
    public static void main (String args[ ]) {

        // int arr[] = {10,30,5,60};
        // int arr[]  = {10, 20, 30}  ;
        // int arr[] = {40, 20, 30, 10, 30};
        int arr[]= {10, 20, 30, 40, 30} ;

        //  Q-3 PRINT ANSWER STRING OF MCM -
	// RECUSRIVE SOLUTION 
        Pair  p =matrix_chain_rec_bracks(arr, 0, arr.length-1);
        System.out.println("min no of calclations: "+p.val + " and formation : "+p.st);
        
	// TBULATIVE SOLUTION  
	 p =matrix_chain_tab_bracks(arr);
        System.out.println("min no of calclations in tabulation : "+p.val + " and formation : "+p.st);
    }
}
