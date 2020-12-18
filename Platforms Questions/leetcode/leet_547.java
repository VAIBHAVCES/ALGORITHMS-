class Solution {

	
    public void mark_dfs(int arr[][] , boolean vis[] , int i ){
        
        vis[i]=true;
        for(int j=0 ; j <arr.length ; j++){
            if(i!= j  && arr[i][j]==1 && !vis[j]){
                mark_dfs(arr,vis,j);
            }
        }
        
    }
    public int findCircleNum(int[][] arr) {
        
        int n = arr.length ,ans =0;
        boolean vis[] = new boolean[n];
        for(int i=0 ; i<n ; i++){
            if(!vis[i] ){
                ans++;
                mark_dfs(arr,vis,i);
                
            }
        }
        return ans;   
    }
}