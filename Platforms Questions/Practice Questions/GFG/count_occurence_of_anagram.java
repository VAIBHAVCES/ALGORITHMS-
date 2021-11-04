
class Solution {

    int search(String t, String s) {
        // code here
        int ns = s.length() ,  nt = t.length();
        int si =0 , ei =0 , count = nt ;
        int freq[]=  new int[256];
        int ans = 0 ;
        
        // System.out.println(t+" "+s);
        for(char ch :  t.toCharArray()){
            freq[ch]++;
        }
        
        while(ei < ns) {
            
            if(freq[s.charAt(ei++)]-- > 0){
                count--;
            }
            
            while(count == 0){
                if(ei-si==nt )ans++;
                if(freq[s.charAt(si++)]++ == 0) count++;
            }
        }
        return ans;


    }
}