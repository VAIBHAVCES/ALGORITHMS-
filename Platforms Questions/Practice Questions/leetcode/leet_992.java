class Solution {
    public int subarraysWithKDistinct(int[] arr, int K) {
     
        
        // best explaination availaible and my source  :
        
        // https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/235235/C++Java-with-picture-prefixed-sliding-window
        
        int si =0 , ei =0 , prefix = 0 ,count =0 , res =0 ;
        int freq[] = new int[arr.length+1];
        
        while(ei < arr.length ){
            
            // FLOW OF ALGORITHM
            //  1- FREQ UPDATE OF EIth character
            //  2- CHECK EITHER ADDITION OF THIS CHARACTER HAS NOT CAUSED
            //  SIZE OF MAP GREATER THAN K (COUNT> K )
            //  2- PREFIX UPDATE (SHRINK STRING AS MUCH AS YOU CAN )
            //  3- ANSWER UPDATION IF NO OF CHARACTERS SO FAR==K 
        
            
            if(freq[arr[ei++]]++==0 ) count ++;
            if(count > K){
                // CRUCIAL STEP - HERE THINK THAT WHY I AM DDECREASING 
                // COUNT WITHOUT CHECKING THAT EITHER MY FREQ ==1 OR NOT
                // BEFORE REDUCTION ? 
                // BECUASE MY SI WILL BE AT A POINT WHERE ITS FREQ IS 1
                // FREQUENCY OF CHARACTER AT SI CAN NEVER BE GREATER THAN 1
                
                prefix=0;
                freq[arr[si++]]--;
                count--;
            }
            while(freq[arr[si]] > 1 ){
                prefix++;
                freq[arr[si++]]--;
            }
            if(count == K) res+= prefix+1;
            
        }
        return res;
        
    }
}