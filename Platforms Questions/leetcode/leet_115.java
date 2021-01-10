class Solution {
    public int numDistinct(String s, String t) {
        // int slen = s.length();
        // int tlen = t.length();
        // int dp[][]= new int[slen+1][tlen+1];
        // for(int sub[] : dp){
        //     Arrays.fill(sub,-1);
        // }
        
        // EXPECTATOIN  IF S = 'BABGBAG' AND T ='BAG' IF WE ARE AT 0TH CHARACTER THEN 
        // WE CAN KEEP FAITH THAT RECURSION CALL TO REMAINING STRING OF S CAN GIVE US NUMBER
        // OF SUBSEQUENCES WE CAN FROM S[1:T] WHICH  T[1:T.LENGH] SO THAT WE CAN COMBINE 0TH CHAR
        // IN FRONT OF ALL THAT RESULTS
        // MY OPERATIONS IN THIS :- IF OUR CHARACTERS ARE EQUAL THEN IT MAY BE POSSIBLE THAT SAME CHARACTER
        // CAN BE FOUND ALSO IN REMAING STRING SO ONE TIME WE INCREASE ONLY POINTERS OF S ANDIN ANOTHER CASE
        // WE INCREASE BOTH POINTERS TO SEARCH FOR REMAINING CHARACHTERS OF T IN S ;
        
        // TRIVIAL ? - IN THIS QUESSTION COMPLEXITY OF MEMOIZED SOLUTION IS LESSER THAN TABULATION
        // SOLUTION THINK WHY ?
        
        // RECURSIVE APROACH  
        // int ans =  rec_ans(s,t,0,0,dp);
        
        // TABULATION
        int ans = tab(s,t);
        return ans;
    
    }
    
    public int rec_ans(String s , String t , int x , int y , int dp[][]){
        
        if( y==t.length()){
            return dp[x][y]=1;
        }
        if(x==s.length()){
            return dp[x][y]=0;
        }
        if(dp[x][y]!=-1)
            return dp[x][y];
        if(s.charAt(x)!=t.charAt(y)){
            return dp[x][y]=rec_ans(s,t,x+1,y,dp);
        }
        return dp[x][y]=rec_ans(s,t,x+1,y+1,dp)+rec_ans(s,t,x+1,y,dp);
            
        
        
    }
    
    public int tab(String s , String t ){
        
        int slen = s.length();
        int tlen = t.length();
        int dp[][]= new int[tlen+1][slen+1];
        dp[tlen][slen]=1;
        for(int i=tlen ;i >=0 ;i--){
            
            for(int j=slen-1;j>=0;j--){
                if(i==tlen){
                    dp[i][j]=1;
                }
                else if(s.charAt(j)==t.charAt(i)){
                    dp[i][j]=dp[i][j+1]+dp[i+1][j+1];
                }else{
                    dp[i][j]=dp[i][j+1];
                }
            }
            
        }
        return dp[0][0];
        
    }


}