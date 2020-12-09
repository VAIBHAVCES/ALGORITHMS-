class Solution {
    public int subarraySum(int[] nums, int k) {
    
        int ssf[]= new int[nums.length];
        ssf[0]=nums[0];
        for(int i=1;i<ssf.length;i++){
            ssf[i]=nums[i] +ssf[i-1];
        }
        
        HashMap<Integer ,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans=0 ;
        for(int i=0;i<ssf.length;i++){
        
            ans+=map.getOrDefault(ssf[i]-k ,0);
            map.put(ssf[i], map.getOrDefault(ssf[i] , 0 )+1 );
        }
        return ans;
        
    
    
    }
}s