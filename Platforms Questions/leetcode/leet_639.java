class Solution {
    
    int mod=1000000007;
    public int dc3_rec(String x, int idx) {
        
        char ith = x.charAt(idx);
        int ans=0;
        // IN THIS REGION WE ARE CONSIDERING THAT Ith CHARACTER
        // IF NOT PAIRS WITH ANY CHARACTER THEN HOW MANY SOLUTIONS
        // IT CAN FORM 

        int single_char= dc3_rec(x ,  idx + 1);
        if(ith>='1' && ith <='9'){
             ans =( ans%mod + single_char%mod)%mod;
        }else if(ith== '*'){
                 ans =(9+ single_char%mod)%mod;
        }
        // NOW WE WILL TRY TO FORM PAIR THAT IF ITH CHARACHTER FORMS PAIR
        // WITH CHARACTER NEXT TO IT THEN EITHER THAT CASE IS POSSIBLE OR NOT 
        // IF POSSIBLE HOW MUCH IT WILL CONTRIBUTE TO ANS
        
        if(idx+2 <= x.length()){
            int pair_char =dc3_rec(x, idx+2 );
            char nextchar =x.charAt(i+1);
            if(ith=='1' && nextchar =='*' ) ans =( ans%mod + 9*pair_char)%mod;
            else if(ith=='2' && nextchar =='*' ) ans =( ans%mod + 6*pair_char%mod)%mod;
            else if(ith=='*' && nextchar =='*' ) ans =( ans%mod + 15*pair_char%mod)%mod;
            else if(ith=='*' && nextchar >='1' && nextchar<='9') ans =( ans%mod + 106)%mod;
        }
        
    }
    public int numDecodings(String s) {
        return dc3_rec(s, 0 ) ;
	//************MORE APROACHES ARE YET TO BE ADDED HERE 
	-- APROACH -1  -  USING RECURSION   --- DONE 
	-- APRAOCH -2  - USING MEMOIZATION
	-- APROACH -3  - USING TABULATION 
	-- APROACH -4  - CONSTANT SPACE LINEAR TIME WITH HELP OF POINTERS 
 
    }
}