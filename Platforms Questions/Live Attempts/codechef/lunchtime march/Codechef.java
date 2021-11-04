    import java.util.*;
    import java.io.*;

    class Codechef{

        public static double log2(int N ,int base )
        {
    
            // calculate log2 N indirectly
            // using log() method
            double result = (int)(Math.log(N) / Math.log(base));
    
            return result;
        }
        public static void main(String[] args) throws Exception{
        
                BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
                int tc  = Integer.parseInt(bf.readLine());
                while(tc-- > 0 ){

                    String line[]= bf.readLine().split(" " );
                    long dist =  Long.parseLong(line[0]) ;
                    long tarM =  Long.parseLong(line[1]);
                    long totM =  Long.parseLong(line[2]);
                    
                    // double distM  = dist/60;
                    // double timeForFull = dist *2 / 60;
                    long laps = (totM/ dist*2)*60;
                    // long laps = (long)(totM/timeForFull);
                    // System.out.println(timeForFull+ " "+tarM+" "+totM);
                    long rem = (totM%dist)%60;
                    long diff = tarM- laps*dist- rem * dist;
                    if(diff <= 0 )
                        System.out.println( laps+ "YES");
                    else 
                        System.out.println("NO");
                    
                    


                }
        }

    }