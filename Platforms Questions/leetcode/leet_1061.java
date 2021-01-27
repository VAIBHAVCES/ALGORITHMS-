//  I DONT HAVE PREMIUM SUBSCRIPTION OF LEETCODE SO FORGIVE ME FOR THEIR SYNTAX

//LEETCODE 1061
 public static int char_parent(int par[] , int p){
        if(par[p]==p)   return p; 
        else return par[p]=char_parent(par, par[p]);
 }
 public static String smallest_equivalent_string(String a , String b , String s){

    int par[]= new int[26];

    for(int i=0;i<par.length;i++){
        par[i]=i;
    }
    for(int i=0 ;i<a.length();i++){
        if(a.charAt(i)!=b.charAt(i)){
            int p1 = char_parent(par , a.charAt(i)-'a');
            int p2 = char_parent(par , b.charAt(i)-'a');
            if(p1!=p2){
                if(p1 < p2){
                    par[p2]=p1;
                }else{
                    par[p1]=p2;
                }
            }

        }
    }
    StringBuilder sb = new StringBuilder();

    for(int i=0;i<s.length();i++){
        int x = char_parent(par,s.charAt(i)-'a');
        sb.append(  (char)(x+'a') );
    }
    return sb.toString();

