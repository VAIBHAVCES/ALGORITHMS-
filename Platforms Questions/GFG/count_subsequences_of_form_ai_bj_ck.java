class Solution
{
    public int fun(String s)
    {
        
        int  mod = 1000000007;
        int a =0 , b =0 , c= 0;
        for(int i=0 ;i <s.length(); i++ ){
            
            if(s.charAt(i)=='a')
                a = (a%mod  + (1 + a%mod )%mod)%mod;
            else if(s.charAt(i)=='b'){
                b = (b%mod  + (a%mod + b%mod)%mod  )%mod;
            }
            else{
                c = (c%mod  + (b%mod+c%mod)%mod)%mod;
            }
        }
        // Write your code here
    return c;
    }
}