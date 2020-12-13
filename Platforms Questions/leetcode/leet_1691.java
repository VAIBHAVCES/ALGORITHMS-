class Solution {
    
    
    public int maxHeight(int[][] arr) {
    // MY APROACH - IF YOU ARE GIVEN WITH L,B,H  FIRST THING IS TO UNDERSTAND IS THAT
    // WE NEED TO PLACE A SMALLER BOX ON BIGGER BOX SO HOW WE CLASSIFY ONE BOX AS SMALLER
    // AND OTHER AS BIGEGER SO ONLY WAY TO DO IS BY COMPARING THEIR LENGTHS AND BREADTHS
    // OF EITHER BASE AREA SO TO ENSURE SORTED ORDER OF SMALLER TO BIGGER CUBES I ENSURED
    // THAT THEIR DIMENSIONS ARE SORTED THEN I WAS SURE THAT EVEN IN A SORTED ORDER 
    // ITS NOT TRUE THAT WE CAN JUST SIMPLY PLACE THEM OVER ONE ANOTHER SO WE APPLIED
    // LIS  SO OVERALL COMPLEXITY O(N^2);
        
    int n = arr.length;

    for(int i=0 ; i < n; i++ ){
         Arrays.sort(arr[i]);
    }
    Arrays.sort(arr , (a,b)->{
        if(a[0]-b[0]==0 ){
            
            if(a[1]-b[1]==0 ){
                return a[2]-b[2];
            }else{
                return a[1]-b[1];
            }
        
        }else return a[0]-b[0];
    });
    
    
    int dp[]= new int[n];
    int ans  = 0 ;
    for(int i=0 ; i < n; i++){
        int max = 0  ;
        for(int j=0 ;j<i; j++){
            if(arr[j][0]<=arr[i][0]&&arr[j][1]<=arr[i][1]&&arr[j][2]<=arr[i][2]&& dp[j] > max )             {
                max=dp[j];
            }
        }
        dp[i]=max+arr[i][2];
        ans = Math.max(ans, dp[i]);
    }
    System.out.println(ans);
        return ans;
        
        
    }
}