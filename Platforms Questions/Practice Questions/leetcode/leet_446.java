class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer>map[]= new HashMap[n];
        for(int i=0;i<n;i++) map[i]= new HashMap<>();
        int ans =0;
        for(int i=0;i<n;i++) {
            
            for(int j=0;j<i;j++){
                
                long diff= (long)arr[i]-(long)arr[j];
                if(diff>=Integer.MAX_VALUE || diff<=Integer.MIN_VALUE)
                    continue;
                int jth = map[j].getOrDefault((int)diff,0);
                int ith = map[i].getOrDefault((int)diff,0);
                ans+= jth;
                map[i].put((int)diff , jth+ith+1);
            }
        }
        
        return ans;
    }
}