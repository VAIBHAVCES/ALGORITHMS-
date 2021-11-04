class Solution {
    public int findNumberOfLIS(int[] arr) {
        
        // APROACH - TABULATIVE - FIRST OF WRITE DOWN CODE FOR LIS SAME TO SAME WITH NO CHANGE NOW AT THIS MOMENT 
        // WE NEED TO REGISTER COUNT VALUES AND HOW WE DO THAT ? FIRST OF ALL CREATE A COUNT ARRAY 
        // NOW HOW TO FILL COUNT ARRAY ? - IF I AM AT CURRENTLY ith INDEX THEN FROM ALL ELEMENTS IN 0 TO I WE NEEED TO DO IF
        //  CHECK -1   ARR[I] > ARR[J] ITH IS GREATER THAN JTH ELEMENT {
        //          |
        //           ---------> IF(WE ARE GETTING A GREATER LENGTH UPDATE MAX_LEN_SO_FAR AND TOTL_FREQ_OF_MAX_LEN_SO_FAR
        //          |
        //           ---------> ELSE IF THE LEN IS SAME THAN MAX_LEN_SO_FAR ADD FREQ OF THIS  IN TOTL_FREQ_OF_MAX_LEN_SO_FAR
        //  EXIT OF JTH LOOP 
        //  LEN OF LIS ENDING AT ITH ELEMENT IS - DP[I] = MAX_LEN_SO_FAR+1
        //  FREQ OF LIS OF LENGTH MAX_LEN_SO_FAR ENDING AT ITH ELEMENT IS -COUNT[I] = TOTL_FREQ_OF_MAX_LEN_SO_FAR + 1
        //   BUT IN CASE WHERE THERE ARE ALL EQUAL ELEMENTS JTH LOOP WILL NEVER TUN AND IT WILL CAUSE TOTL_FREQ_OF_MAX_LEN_SO_FAR=0
        //   BUT THIS ONE ALSO HAS A LENGTH OF 1 SO IF IT IS NEVER UPDATED BY JTH LOOOP THEN WE NEED TO SET IT TO 1 OR INCREMENT BY 1
        
        int dp[] = new int[arr.length];
        int count[] = new int[arr.length];
        dp[0]=1;
        count[0]=1;
        int ans_ct= 1;
        int ans_len =1;
        for(int i =1;i<arr.length;i++){
            int max_len = 0;
            int max_ct=0;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    
                    if(max_len < dp[j] ) {
                        max_len =dp[j];
                        max_ct = count[j];
                    }else if(max_len == dp[j] ){
                        max_ct+=count[j];                
                    }
                }
            }
         dp[i]= max_len+1;  
         count[i]=max_ct==0? max_ct+1 :max_ct;
            
        if(ans_len== dp[i]) ans_ct+=count[i];
        else if(dp[i] >  ans_len ){  ans_ct = count[i];  ans_len = dp[i];}
            
            
    }
         
    
        return ans_ct;
    }
}