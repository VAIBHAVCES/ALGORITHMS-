public class Solution {
    
    public boolean isReflected(int[][] points) {
        int max = -(int)1e8 , min = (int)1e8;
        HashSet<String>mem = new HashSet<>();
        
        for(int arr[] : points){
        
            mem.add(arr[0]+"@"+arr[1]);
            max =Math.max(arr[0] , max);
            min = Math.min(arr[0], min);
        }
        int sum = max + min ;
        for(int sub[] : points){
            boolean resp =mem.contains((sum-sub[0])+"@"+sub[1]);
            if(!resp)   return false;
        }
        
        
        return true;
        
    }
    
}