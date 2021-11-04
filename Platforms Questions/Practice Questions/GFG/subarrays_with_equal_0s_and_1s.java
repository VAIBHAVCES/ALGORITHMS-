class countsubArray
{
    // arr[] : the input array
    // N : size of the input array
    
    // return the number of subarrays with equal 0s and 1s
    static int countSubarrWithEqualZeroAndOne(int arr[], int N)
    {
        // add your code here
        // APROACH - HERE I CAN MAKE A CONTIGUOUS SUM ARRAY WHICH STORES SUM OF ALL
        // ELEMENTS UPTO ITH INDEX BUT PROBLEM WITH THAT IS 0+ANY NUMBER = ANY NUMBER
        // THAT MEAN WE CAN DETECT OCCURENCE OF 0 HOW MANY TIMES IT COMES SO TO NEUTRALIZE
        // THAT - EFFECT I USED 0 AS -1 AND JUST APROACHED BY CONTIGUOUS SUM ARRAY
        int ssf=0 ,ans= 0;
        HashMap<Integer ,Integer >map = new HashMap<>();
        map.put(ssf,1);
        for(int i=0;i<arr.length; i++){
            ssf+=arr[i]==0?-1:arr[i];
            ans += map.getOrDefault(ssf , 0);
            map.put(ssf , map.getOrDefault(ssf , 0)+1 );
            
        }
     
        return ans;
    }
}
