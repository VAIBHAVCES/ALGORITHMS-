class Solution {
    public boolean canReorderDoubled(int[] A) {

        Integer arr[]=  new Integer[A.length];
        for(int i=0 ; i< A.length; i++ ){
            arr[i]=A[i];
        }
        
        Arrays.sort(arr, (a,b)->{
            return Math.abs(a)-Math.abs(b);
        });
        HashMap<Integer,Integer>mem = new HashMap<>();
        for(int i=0 ; i< A.length; i++ ){
            mem.put(A[i] , mem.getOrDefault(A[i], 0)+1 );
        } 
        
        int i=0;
        while(i<A.length){
            if(mem.get(arr[i])==0 ){
                i++;
                continue;
            }
            if(mem.getOrDefault(2*arr[i] , 0 ) <=0 ) return false;
            
            mem.put(arr[i] , mem.getOrDefault(arr[i] ,  0 )-1);
            mem.put(2*arr[i] , mem.getOrDefault(2*arr[i] ,  0 )-1);
            i++;
            
        
        }
        return true;
    }
}