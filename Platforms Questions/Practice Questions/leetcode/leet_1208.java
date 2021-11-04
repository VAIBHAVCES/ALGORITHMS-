class Solution {
    public int equalSubstring(String s, String t, int mc) {
        
        int si =0 , ei=0 , ans =0 ;
        while(ei < s.length()){
            
            if(mc >= 0){
                int val = (int)Math.abs(s.charAt(ei)-t.charAt(ei));            
                // System.out.println(s.charAt(ei)+" : "+t.charAt(ei)+" "+val);
                mc-= val;
                ei++;
            }
            
            while(mc< 0) {
                mc+= (int)Math.abs(s.charAt(si)-t.charAt(si));
                si++;
                
            }
                ans = Math.max(ans, ei-si );
                
        
        }
        return ans;
        
    }
}