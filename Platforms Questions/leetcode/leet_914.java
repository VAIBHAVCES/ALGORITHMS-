class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length <=1) 
                return false;
        HashMap<Integer ,Integer >map = new HashMap<>();
        for(int i=0 ;i< deck.length;i++){
            map.put(deck[i] ,map.getOrDefault(deck[i], 0 )+1);
        }
        int min = (int)1e8;
        int max = -(int)1e8;
        for(int val : map.keySet()){
           min = Math.min(min, map.get(val));
           max = Math.max(max, map.get(val));
       }
        
        // lcm 
        int t1 =min;
        int t2 = max;
        while(t1%t2!=0){
            int rem = t1%t2;
            t1=t2;
            t2=rem;
        }
        int lcm =( min * max ) / t2;
        System.out.println(lcm);
         for(int val : map.keySet()){
             int temp= map.get(val);
             if(temp < lcm) return false;
             
         }
           return true;
        
    }
}