class Solution {
    // ALL POSSIBLE SOLUTOINS DONE 
    public int bruteforce(int arr[] ){
        int ans =0 ;
        for(int len=2;len<arr.length;len++){

            for( int i=0; i<arr.length-len ; i++ ){
                
                int d = arr[i+1]-arr[i];
                int j=i;
                
                for( ; j<=i+len  && j+1<=i+len; j++){
                    if(arr[j+1] -arr[j] !=d ){
                            break;
                        }
                }
                if(j==i+len )
                        ans++;
                        
                
            }
            
        }
        return ans; 
    }
    public int linear_memory_sol(int arr [] ) { 
        
        int ans =0;
        int dp[]= new int[arr.length];
        for(int idx= 2; idx<arr.length;idx++){
             if(arr[idx-2] +arr[idx] == 2* arr[idx-1]){
                dp[idx]=dp[idx-1]+1;
                ans+=dp[idx];
             }
        }
        return ans;
    }
    public int most_optimized_sol(int arr[] ){
        int prev =0 ;
        int ans=0 ;
        for( int idx=2 ;idx<arr.length;idx++){
            if(arr[idx-2] + arr[idx] == 2*arr[idx-1] ){
                    prev++;
            }else{
                prev=0;
            }
            ans+=prev;
        }
        return ans;
    }
    
    public int numberOfArithmeticSlices(int[] arr ) {

        // APROACH - PURELY RANDOM SOLUTION , LEAST LENGTH WE CAN ACHIEVE IS OF 3 ELEMENTS SO
        // STARTING FROM 3 UPTO ARR.LENGTH WE WILL FIND ALL CONTIGUOUS SUB ARRAYS AND CHECK BY HELP
        //  OF THEIR DIFFERENCES THAT EITHER THEY ARE AP OR NOT ;
        // return bruteforce ;
        
        
        //  APROACH DP - ONE PATERN WE CAN OBSERVE IS THAT STARTING FROM 2ND INDEX WHENEVER A NEW ELEMENT COMES
        // AND IF IT IS AND AP WITH ALL PREV ELEMENTS THEN IT FORM TOTTAL NO OF  SUBARRAYS (ARITHEMETIC ) AS ITS BEEN
        // FORMED BY I-1TH ELEMENT E.G 1, 3, 5, NOW IF 7 COMES AS A ELEMENT IT WILL CONTINUOSLY FORM AN AP BUT HOW 
        // TO CHECK HOW MANY SLICES ITS BEEN FORMING THAT WE CAN CHECK FROM SLICES[I-1]+1 HENCE NO OF SUB SLICES FORMED 
        // AT ITH LOCATION WILL BE 2 AND TOTTAL ANS WILL BE 3 SO LET'S TRY TO USED IT 
        // return linear_memory_sol(arr);
        
        //  APROACH -3 - FROM PREVIOUS APROACH WHY I CAN OBSERVE IS THAT I ONLY HAVE USE OF DP[I-1] THAT 1 PREVIOUS
        // ELEMENT ALL OF THE LINEAR STORAGE IS WASTE ALL I NEED IS PREVIOUS ELEMENT HENCE ITS POSSIBLE TO COMPLETE
        // THIS SOLUTION IN A CONSTANT SPACE 
        
        return most_optimized_sol(arr);
          
    }
}