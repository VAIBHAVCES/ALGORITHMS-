class Solution
{
    long subCount(long arr[] ,int n,int k)
    {
        
        long ssf[] = new long[arr.length];
        ssf[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            ssf[i]=ssf[i-1]+arr[i];
        }
        HashMap<Long ,  Long >map = new HashMap<>();
        map.put((long)0,(long)1);
        long ans = 0 ;
        for(int i=0;i<arr.length;i++){
            
            long rem  =Math.abs(ssf[i]%k);
            ans+= map.getOrDefault(rem, (long)0 );
            map.put( rem , map.getOrDefault( rem ,(long)0 ) + 1);
            
        }
        return ans;
        
        
    }
}