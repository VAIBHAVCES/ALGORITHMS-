// I DONT HAVE LEETCODE PREMIUM BUT HAVE TESTED THIS CODE ON MY DEFAULT TESTCASES
// CONTACT ME IF ANY MISTAKE FOUND


 public static int myParent(int  parent[]  , int p){
        if(parent[p]==p) return parent[p];
        else return parent[p]=myParent(parent,parent[p]);
    }
    

public static int leet1168(int n, int wells[] , int pipes[][]){

        ArrayList<int[]>mem = new ArrayList<>();
        for(int ele[]:pipes) mem.add(ele);
        for(int i=0;i<wells.length;i++){
            mem.add(new int[]{0,i+1,wells[i]});
        }
        Collections.sort(mem , (a,b)->{
            return a[2]-b[2];
        });
        int parent[]= new int[n+1];
        for(int i=0;i<parent.length;i++) parent[i]=i;
        int ans = 0 ;
        for(int ele[] : mem ){
            int p1 = myParent(parent,ele[0]);
            int p2 = myParent(parent,ele[1]);
            if(p1!=p2){
                parent[p1]=p2;
                ans+= ele[2];
            }
        }
        return ans; 
    }
