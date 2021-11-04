class Solution {
    public String minWindow(String s, String t) {
        
        
        int nt = t.length();
        int ns = s.length();
        
        int freq[]= new int[128];
        for(int i=0 ; i< t.length(); i++){
            freq[t.charAt(i)]++;
        }
        int si=0, ei=0 , len=(int)1e8 , count=nt , head =0 ;
        while(ei <  ns ){
            
            if(freq[s.charAt(ei++)]-- >0 ) count--;
            while(count==0){
            if(len > ei -si)
            {
                len = ei-si;
                head =si;
            }
                if(freq[s.charAt(si++)]++ ==0 ) count++;
            }
        }
        return len==(int)1e8 ?"":s.substring(head, head +len) ;
    }
}