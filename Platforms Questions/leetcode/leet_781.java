class Solution {
    public int numRabbits(int[] ans) {
        if(ans.length==0) return 0 ;
        HashMap<Integer, Integer>map = new HashMap<>();
        int rabbits=0;
        for(int i=0 ;i < ans.length; i++){
            
            int val = ans[i];
            int freq= map.getOrDefault(val , 0 )+1;
            if(freq > val+1 ){
                rabbits+=freq-1;
                freq=1;
            }
            map.put(val , freq);
            
            
        }
        for(int i : map.keySet()){
            rabbits+=(i+1);
        }
        return rabbits;
    }
}