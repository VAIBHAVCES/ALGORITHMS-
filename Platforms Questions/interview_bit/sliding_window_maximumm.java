public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> arr, int n) {
    
        
        int si=0, ei=0 ;
        ArrayList<Integer>ans = new ArrayList<>();
        ArrayDeque<Integer>st = new ArrayDeque<>();
        while(ei < arr.size() ){
            // System
            if(ei-si< n ){
                
                while(st.size()>0 && arr.get(st.peekLast()) < arr.get(ei) ){
                    st.removeLast();
                }
                st.addLast(ei++);
            }
            if(ei-si== n){
                ans.add(arr.get(st.peekFirst()));
                si++;
                while(st.size() > 0 && st.peekFirst() < si){
                    st.removeFirst();
                }
            }
        }
        return ans;
    }

    
    
}
