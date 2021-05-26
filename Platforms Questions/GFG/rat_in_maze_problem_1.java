class Solution {
    static int dir[][]= new int[][]{  {1,0},{0,-1},{0,1},{-1,0}};
    static String moves[]= new String[]{"D","L","R","U"};
    
    public static int helper(ArrayList<String>ans , String asf , int i, int j , int arr[][] ){
        
        // System.out.println(i+" "+j+"--"+asf);
        
        if(arr[i][j]==0){
            return 0;
        }
        int n = arr.length , m =arr[0].length;
        if(i==n-1 && j==m-1){
            ans.add(asf);
            return 1;
        }
        
        int count =0 ;
        arr[i][j]=-1*arr[i][j];
        for(int k =0 ;k<dir.length;k++ ){
            
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x>=0 && y>=0 && x<n && y<m && arr[x][y]>=0 ){
                
                count+=helper(ans, asf+moves[k] , x ,y , arr);
                
            }
            
        }
        
        arr[i][j]=-1*arr[i][j];
        return count;
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String>ans  = new ArrayList<>();
        int ans2 =helper(ans, "",0,0,m);
        return ans;
    }
}