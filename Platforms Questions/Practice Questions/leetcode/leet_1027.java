class Solution {
    public int longestArithSeqLength(int[] arr) {
        
        //  APROACH - SAME CONCEPT AS WE HAVE USED IN LEETCODE 1218 ,I.E FROM PREVIOUS ELEMENT WE NEED INFORMATION 
        // THAT OF WHAT LENGTH AND WITH WHAT DIFFERENCE WE GET MAX ANS AND DO WE FORM THAT DIFFERENCE AT ITH ELEMENT NOW
        // MEANS NOW WE ALSO NEED TO STORE THE DIFFERENCE WHICH WE WERE NOT DOING IN LEETCODE 1218 IN THAT PROBLEM WE WERE 
        // GIVEN WITH THE DIFFERENCE SO WE DON'T NEEDED TO STORE THAT BUT IN HERE WE ALSO NEEDED TO STORE THAT 
        int n = arr.length;
        HashMap<Integer , Integer>map[] = new  HashMap[n];
        for(int i=0;i<n;i++) map[i]= new HashMap<>();
        int ans =0;
        for(int i=0;i <n ; i++ ){
            
            for(int j=0;j<i;j++){
                int diff= arr[j] -arr[i];
                int val = map[j].getOrDefault(diff , 1 ) +1;
                map[i].put(diff ,  val );
                ans = Math.max(ans ,val);
            }
            
        }
        return ans;
    }
}