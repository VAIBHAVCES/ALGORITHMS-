import java.util.*;
import java.io.*;

 class CodeChef {


    public static void main(String[] args)  throws java.lang.Exception {
        // Scanner scn = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        while(tc-- > 0 ){
           
            String line[] = bf.readLine().split(" ");
            int n= Integer.parseInt(line[0]);
            int k= Integer.parseInt(line[1]);
            int ssf[]= new int[n];
            line = bf.readLine().split(" ");
            ssf[0]=line[0].charAt(0)-'0';
            for(int i =1 ;  i < line.length;i++){
                ssf[i]= ssf[i-1]+line[i].charAt(0)-'0';
            }
            int minWindow = k ; 
            for(int i= k-1; i< line.length;i++){
                int prev = i-k>=0 ? ssf[i-k]: 0;
                minWindow =Math.min(ssf[i]-prev, minWindow );
            }
            // System.out.println("min windows is  : "+minWindow);
            // System.out.println("number of  one : "+ssf[line.length-1]);
            int ans =( (minWindow *(minWindow+1)) / 2) + ssf[line.length-1]-minWindow;
            System.out.println(ans);

        }
    }
}