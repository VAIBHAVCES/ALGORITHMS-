class Solution {
    static int moves[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
    
    public void mark_lamps(int colony[][] , int lamps[][] ){
        
        int n = colony.length;
        for(int cord[] : lamps ){
                 int x =cord[0];
                 int y =cord[1];
                 colony[x][y]=1; 
                
                }
              
    }
    public boolean check(int colony[][] , int i , int j  ){
       int n = colony.length;
        for(int z=0;z<moves.length;z++){
             int move[] = moves[z];
             int x = i;
             int y = j;
            while( y>=0 && x>=0 && x<n && y<n ){
                // System.out.println("bulb at : "+x+" "+y+" for: "+i+" "+j);
                if(colony[x][y]==1){
                    return true;}
                x+=move[0];
                y+=move[1];
            }
        }
        return false;
        
    }
    public void turn_off(int colony[][] , int cords[]){
         int n = colony.length;
       
        for(int move[] : moves ){
            
            int x = cords[0] + move[0];
            int y = cords[1] + move[1];

            if( y>=0 && x>=0 && x<n && y<n ){
                colony[x][y]=0;
                
            }
        }
        
    }
    public int[] bruteforce(int n , int lamps[][],  int queries[][] ){
        int colony[][] = new int[n][n];
        mark_lamps(colony, lamps );
        int ans[]=  new int[queries.length];
        for(int i=0; i<queries.length;i++){
            if( check(colony,queries[i][0] ,queries[i][1] ) ){
                ans[i]=1;
                // the same coordinate where we are can also be on bulb so turn that off also;
                colony[queries[i][0]][queries[i][1]]=0;
                
                turn_off(colony,queries[i]);
            }
        }
        return ans;
        
    }
    
    
    public int[] usingHashMaps (int lamps[][], int queries[][] ){
        
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> diag= new HashMap<>();
        HashMap<Integer, Integer> antidiag = new HashMap<>();
        HashMap<Integer, Boolean> onoff = new HashMap<>();
        
        int size= lamps.length;
        for(int cordinates[] : lamps ){
            int x = cordinates[0];
            int y = cordinates[1];
            
            row.put(x,row.getOrDefault(x,0)+1);
            col.put(y,col.getOrDefault(y,0)+1);
            diag.put(x+y,diag.getOrDefault(x+y,0)+1);
            antidiag.put(x-y,antidiag.getOrDefault(x-y,0)+1);
            onoff.put(x*size+y,true);
            
        }
        int ans []=  new int[queries.length];
        for(int i=0; i<queries.length; i++){
            
            int x = queries[i][0] , y= queries[i][1];
            if(row.getOrDefault(x,0) >0||col.getOrDefault(y,0)>0||diag.getOrDefault(x+y ,0)>0||antidiag.getOrDefault(x-y ,0) > 0 )             {
                ans[i]=1;
            }
            
            for(int dir[] : moves ){
                int m = x+dir[0];
                int n = y+dir[1];
                
                if( onoff.getOrDefault(m*size+n , false) ){
                        row.put(m,row.getOrDefault(m,1)-1);
                        col.put(n,col.getOrDefault(n,1)-1);
                        diag.put(m+n,diag.getOrDefault(m+n,1)-1);
                        antidiag.put(m-n, antidiag.getOrDefault(m-n,1)-1);
                        onoff.put(m*size+n,false);
                    
                }
            }
            
        }
        return ans;
        
        
        
        
    }
    
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        
        // return bruteforce(N,lamps,queries);
        
        // solution of : - https://leetcode.com/problems/grid-illumination/discuss/243076/Java-Clean-Code-O(N)-Time-and-O(N)-Space-Beats-100
        return usingHashMaps(lamps, queries);
    
    
    }
}