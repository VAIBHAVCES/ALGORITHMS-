class Solution {
    public  boolean isSimilar(String s1 , String s2 ){
        int count =0 ;
        for(int i=0 ;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i) && ++count > 2) return false;
        }
         return true;
    }
    public int myParent(int parent[] , int p ){
        if(parent[p]==p)    return p ; 
        else return parent[p]=myParent(parent,  parent[p]);
    }
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        int count = n ; 
        int parent[]= new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        for(int i=1 ;i <n;i++){
            for(int j=0; j<i; j++){
                
                // System.out.println(strs[i]+" "+strs[j]+" "+isSimilar(strs[i],strs[j]));
                if(isSimilar(strs[i],strs[j])){
                    int p1 = myParent(parent ,i );
                    int p2 = myParent(parent ,j );
                    // System.out.println(i+" : "+p1+" ,  "+j+" : "+p2);
                    if(p1!=p2){
                         count--;
                         parent[p1]=p2;
                        
                    }
                }
                
            }
            
        }
        return count ;
        
    }
}