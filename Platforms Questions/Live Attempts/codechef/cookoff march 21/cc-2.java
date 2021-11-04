import java.util.*;
import java.io.*;

public class CodeChef {

    public static void weight(Scanner scn ) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       
        int tc = Integer.parseInt(bf.readLine());
        while(tc-- > 0 ){
            String line[] = bf.readLine().split(" ");
            int w1 = Integer.parseInt(line[0]);
            int w2 = Integer.parseInt(line[1]);
            int x1 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            int m =  Integer.parseInt(line[4]);
            int diff = w2-w1;
            if( diff >= x1*m && x2*m>=diff){
                System.out.println(1);
            }else System.out.println(0);

        }        

    }


    public static void pawri(Scanner scn ){

       

    }
    public static void main(String[] args)  throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        // weight (scn);
        pawri(scn);

    }
}




for(int i=0;i<line2.length();i++){
                
    StringBuilder temp = new StringBuilder();
    
    System.out.println("inner "+i+" "+line2.charAt(i)+" "+i);
    if(line2.charAt(i)=='p'){
        int j = i ;
        for( ; j< i + 5 && j +i < line2.length(); j++){
            temp.append(line2.charAt(j));
            if(line2.charAt(j)==pawri.charAt(j-i)){
                continue;
            }else{
                break;
            }
    }

        if(j==i+5){
            // just change 
            ans.append("pawri");
            i =  j-1 ; 
        }else {
            i=j-1;
            ans.append(temp);
        }
    }
    else ans.append(line2.charAt(i));
}
System.out.println(ans.toString());



String line[]= bf.readLine().split(" ");     
        int tc= Integer.parseInt(line[0]);
        while(tc-- > 0){
            String pawri ="party";
            String line2 = bf.readLine();
            StringBuilder ans = new StringBuilder();
            for(int i=0;i<line2.length();i++){

                if(line2.charAt(i)=='p'){

                        int ul = i+5<line2.length()?i+5:  line2.length();
                        String sub = line2.substring(i , ul );
                        if(sub.equals(pawri)){
                            ans.append("pawri");
                            i= i+4;
                        }else {
                            ans.append(line2.charAt(i));
                        }

                }else{
                    ans.append(line2.charAt(i));
                }
            }
            System.out.println(ans);
        }