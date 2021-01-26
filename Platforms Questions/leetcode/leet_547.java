class Solution {
    public void mark_dfs(int arr[][] , boolean vis[] , int i ){
        
        vis[i]=true;
        for(int j=0 ; j <arr.length ; j++){
            if(i!= j  && arr[i][j]==1 && !vis[j]){
                mark_dfs(arr,vis,j);
            }
        }
        
    }
    public int dfs_soln(int arr[][] ){
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
    
    //*************UNION FIND APROACH
    //*********************************
    //********************************
    
    public int myParent(int parent[] , int p ){
        if(parent[p]==p)    return p;
        else return parent[p]=myParent(parent, parent[p] );
    }
    public int unionFind(int arr[][] ){
        int n = arr.length;
        int parent[]= new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        
        for(int i=0 ;i <arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i][j]==1){
                    
                    int p1= myParent(parent,i );
                    int p2 = myParent(parent,j);
                    if(p1!=p2){
                        parent[p2]=p1;
                    }
                }
            }
        }
        int ans =0 ; 
        for(int i=0;i<n;i++) {
          if(  parent[i]== i) ans++;
        }
        return ans;
    }
    
    public int findCircleNum(int[][] arr) {
        // return dfs_soln(arr);
        return unionFind(arr);
        
        
    }
}