/**
  THIS WAS A PREMIUM QUESTION ON LEETCODE THATS WHY THIS CODE IS BASED ON 
  LINTCODE 434 WHICH IS SAME AS LEET QUESTION SO CHANGE THE CODE AS PER YOUR
  REQUIREMENT IF YOU ARE SUBMITTING IT ON LEETCODE 

 */

public class Solution {
    
         public  int parent301(int parent[] ,int p ){
             if(parent[p]==p)  return p;
             else return parent[p]=parent301(parent, parent[p]);
         }
         static int dir[][]=new int[][]{{-1,0} , {0,-1} ,{0,1},{1,0}};
         
         public  List<Integer> leetcode301(int n , int m , int positions[][] ){
        
                int par[]= new int[n*m],count = 0;
                Arrays.fill(par,-1);
                List<Integer>ans =  new ArrayList<>();
        
                for(int pos[]: positions){
                    
                    int idx = pos[0]*m+pos[1];
                    if(par[idx]==-1 ) {
                        par[idx]=idx;
                        count++;
                        for(int moves[] : dir){
                            int x = pos[0]+moves[0];
                            int y = pos[1]+moves[1];
                            if(x>=0 && y>=0 && x<n&&y<m &&par[x*m+y]!=-1){
                                int p1 = parent301(par,x*m+y);
                                if(p1!=idx){
                                    par[p1]=idx;
                                    count--;
                                }
                            }
                            
                        }
                    }
                    ans.add(count);
                }
                    
                return ans;
            }

    
        public List<Integer> numIslands2(int n, int m, Point[] operators) {
        
            // System.out.println("detected "+operators.length);
            if(operators==null||operators.length==0){
                return new ArrayList<Integer>();
            }
            
            int position[][]= new int[operators.length][2];
            for(int i=0;i<operators.length;i++){
                position[i][0]=operators[i].x;
                position[i][1]=operators[i].y;
            
            }
            
            return leetcode301(n,m,position);
        }
}