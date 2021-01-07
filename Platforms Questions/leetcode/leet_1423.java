class Solution {
    public int maxScore(int[] arr, int m) {
        
        // System.out.println("length : "+arr.length);
        int si= 0, ei =0 , ssf =0 , min = Integer.MAX_VALUE, count = 0 ,k =arr.length-m ;
        long sum = 0;
 
        while(ei < arr.length ){
            if(count < k){
                sum+=(int)arr[ei];
                ssf+=arr[ei++];
                count++;       
            }
            if(si < arr.length && count == k){
                min = Math.min(min , ssf);
                ssf-=arr[si++];
                count--;
            }
        }
        return (int)(sum-min);
        
    }
}