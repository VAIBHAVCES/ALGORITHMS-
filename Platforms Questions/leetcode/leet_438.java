class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     
        int si = 0 , ei =0 , ns = s.length() ,np =p.length();
        int freq[]= new int[256];
        for(char ch :  p.toCharArray()){
            freq[ch]++;
        }
        List<Integer>ans =new ArrayList<>();
        int count =np;
        while(ei < ns ){
            if(freq[s.charAt(ei++)]-- > 0 ) count--;
            while(count == 0){
                if(ei-si == np ) ans.add(si);
                
                if(freq[s.charAt(si++)]++ == 0 ) count ++;
                
                
            }
            
        }
        return ans;
    }
}