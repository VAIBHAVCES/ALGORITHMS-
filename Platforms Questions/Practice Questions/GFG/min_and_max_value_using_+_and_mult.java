
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
    
   
    
    public static int eval(char op , int  x , int y ){
        if(op=='+') return x+ y;
        else if(op=='*') return x*y;
        else return -1;
    }
    public static int[] eval_rec(String exp , int lo , int hi ){
        if(lo==hi){
            return new int[]{Integer.parseInt(exp.charAt(lo)+""),Integer.parseInt(exp.charAt(lo)+"")};
        }
        int ans = Integer.MIN_VALUE;
        int  min_ans = Integer.MAX_VALUE;
        for(int i=lo+1 ; i <= hi ; i+=2 ){

                int left[] =eval_rec(exp ,lo , i-1 ); 
                int right []= eval_rec(exp , i+1 , hi );
                ans =Math.max( ans , eval(exp.charAt(i) , left[0], right[0]) );
                min_ans = Math.min(min_ans , eval(exp.charAt(i) , left[1], right[1]));
            
            }
            return new int[]{ans ,min_ans }; 
    }
    public static int [] eval_mem(String exp , int lo , int hi ,int dp[][][] ){

        if(lo==hi ){
            int dig = Integer.parseInt(exp.charAt(lo)+"");
            dp[lo][hi][0]=dp[lo][hi][1]=dig;
            return new int[]{dig,dig};
        }
        if(dp[lo][hi][0]!=-1 || dp[lo][hi][1]!=-1){
            return new int[]{dp[lo][hi][0],dp[lo][hi][1]};
        } 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int ul = lo+1 ; ul <= hi ; ul+=2){
            int left[] = eval_mem(exp,lo,ul-1 ,dp);
            int right[] = eval_mem(exp , ul+1 ,hi , dp);
            max = Math.max( max , eval(exp.charAt(ul) ,  left[0] , right[0] ));
            min = Math.min( min , eval(exp.charAt(ul) ,  left[1] , right[1] ));
        }
         dp[lo][hi][0]=min;
         dp[lo][hi][1]=max;
        return new int[]{max,min };

    }
    public static int []eval_tab(String exp ){
        int n = exp.length();
        int max[][]= new int[n][n];
        for(int gap = 0 ; gap <n;gap+=2 ){

            for(int i=0 , j =i+gap ; i<n && j <n ;i+=2,j+=2){
                if(gap==0)  max[i][j]=Integer.parseInt(exp.charAt(i) + "");
                else {
                    int max_val =  Integer.MIN_VALUE;
                    for(int ul = i+1 ; ul <= j ; ul+=2)
                    {
                        max_val = Math.max(max_val,eval(exp.charAt(ul) ,max[i][ul-1] , max[ul+1][j]  ) );
                    }
                    max[i][j]=max_val;
                }
            }

        }

        int min[][]= new int[n][n];
        for(int gap = 0 ; gap <n;gap+=2 ){

            for(int i=0 , j =i+gap ; i<n && j <n ;i+=2,j+=2){
                if(gap==0)  min[i][j]=Integer.parseInt(exp.charAt(i) + "");
                else {
                    int min_val =  Integer.MAX_VALUE;
                    for(int ul = i+1 ; ul <= j ; ul+=2)
                    {
                        min_val = Math.min(min_val,eval(exp.charAt(ul) ,min[i][ul-1] , min[ul+1][j]  ) );
                    }
                    min[i][j]=min_val;
                }
            }

        }

        print2d(min);

            return new int[]{max[0][n-1] , min[0][n-1] };


    }
    
    

    
    public static void main (String args[ ]) {
	
	
	//************ TEST CASES 
        String exp = "1+2*3+4*5";
        // String exp = "4*7+2+3*6";
        // String exp = "1*1+1+1*1";
	
	// RECURSIVE SOLUTION AREA 

        int ans[] = eval_rec(exp, 0 ,exp.length()-1);
        System.out.println("recusrive ans :- max " +ans[0]+" min : "+ans[1]);
        
	// **************MEMOIZED SOLUTION AREA 

	int n= exp.length();
        int dp[][][]= new int[n][n][2];
        for(int sub[][] : dp) fill2d(sub,-1);
        ans= eval_mem(exp , 0 , exp.length()-1, dp );
        System.out.println("memoized  ans :- max " +ans[0]+" min : "+ans[1]);
        //*************** TABULATED SOLUTION AREA 

        ans = eval_tab(exp);
        System.out.println("tabulated ans  : " +ans[0]+" min: "+ans[1]);
        

    }
}
