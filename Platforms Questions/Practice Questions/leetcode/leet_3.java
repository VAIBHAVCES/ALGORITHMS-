class Solution {
    public int lengthOfLongestSubstring(String s) {
        int freq[]= new int[256];
        int si=0, ei=0 , n = s.length() ,len =0;
        int ans =0 ;
        while(ei < n ){
          
            freq[s.charAt(ei)]++;
            if(freq[s.charAt(ei)]==1){
                len++;
            }
            ans = Math.max(ans, len);
            while(freq[s.charAt(ei)]> 1 ){
                if(freq[s.charAt(si++)]--==1) len--;
            }
            ei++; 
        }
        return ans;
    }
}