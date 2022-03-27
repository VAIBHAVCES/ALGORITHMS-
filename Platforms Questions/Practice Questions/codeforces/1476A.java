import java.util.*;
 
public class main {
 
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int tc  = scn.nextInt();
        while(tc-->0){
 
            double n = scn.nextDouble();
            double k = scn.nextDouble();
            System.out.println(pattern(n,k));
        }
        
    }
 
    public static int pattern(double n , double k) {
       int ans = 0; 
        if(n>k){
            double xfactor = Math.ceil(n/k);
            // System.out.println("test : "+k+" : "+n+ " : "+xfactor);
            ans = (int)Math.ceil((k*xfactor)/n);
        }else if(n<=k){
            ans = (int)Math.ceil(k/n);
        }
        return ans;
 
    }
}