class Solution {
    public int longestOnes(int[] A, int K) {
        int si =0 ,ei=0 , n = A.length , count = K ,len =0 ;
        while(ei < n ){
            
            if(A[ei++]==0) count-- ;
            
            if(count>= 0) len = Math.max(len, ei-si);
            while(count < 0 ){
                if(A[si++]==0) count++;
            }
            
        }
        return len;
    
    }
}