// LEETCODE 301 
 public static int parent301(int parent[] ,int p ){
     if(parent[p]==p)  return p;
     else return parent[p]=parent301(parent, parent[p]);
 }
 public static ArrayList<Integer> leetcode301(int n , int m , int positions[][] ){

        int par[]= new int[n*m],count = 0;
        Arrays.fill(par,-1);
        ArrayList<Integer>ans =  new ArrayList<>();

        for(int pos[]: positions){
            
            int idx = pos[0]*m+pos[1];
            if(par[idx]==-1 ) {
                par[idx]=idx;
                count++;
            }
            int p1 = -1 , p2=-1;
            if(idx-m>=0 && par[idx-m]!=-1){
                   p1 = parent301(par,idx);
                   p2 = parent301(par,idx-m);
            }
            if(idx-1>=0 && par[idx-1]!=-1){
                   p1 = parent301(par,idx);
                   p2 = parent301(par,idx-1);
            }
            if( p1!=-1&& p2!=-1&&p1!=p2){
                    par[p2]=p1;
                    count--;
            }
            ans.add(count);            

        }
        return ans;
    }
 