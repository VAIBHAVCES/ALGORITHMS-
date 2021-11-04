    // short keys:
    // println()- pln
    // 

    import java.util.*;
    import java.io.*;
import java.lang.reflect.Array;
    public class main{
        
        //SOLUTION BEGIN
        long mod = 1000000000+7;
        void pre() throws Exception{}
        
        void solve(int TC) throws Exception{
            
            int k=  ni() , n= ni() ,m =ni();
            int i=0;
            // scn.nextLine();
            int arr[]  = new int[n+m];
            int zeros = 0;
            while(i<n){
                arr[i]=ni();
                zeros=arr[i]==0?zeros+1:zeros;
                i++;
            }
            m+=i;
            while(i<m) {
                arr[i]=ni();
                zeros=arr[i]==0?zeros+1:zeros;
                i++;
            }
            m-=n;
            Arrays.sort(arr);   
            for( i=0 ; i<(n+m);i++){
                // pn("ith :"+arr[i]+" "+n+" "+m+" "+(arr[i]<=(k+zeros))+" "+(k+zeros));
                if(arr[i]!=0 && arr[i]>(k+zeros) ){

                    pn("-1");
                    return;
                }
                // else {
                // }
            }
            for( i=0;i<(n+m);i++)p(arr[i]+" ");
            pn("");
            


            
        }
        //SOLUTION END
        void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
        static boolean multipleTC = true;
        FastReader in;PrintWriter out;

        void run() throws Exception{
            in = new FastReader();
            out = new PrintWriter(System.out);
            int T = (multipleTC)?ni():1;
            pre();for(int t = 1; t<= T; t++)solve(t);
            out.flush();
            out.close();
        }

        void p1d(Object o[] ){
            for(Object ele : o){
                p(ele);
                p(" ");
            }
        }
        
        void pn1d(Object o[] ){
            for(Object ele : o){
                pn(ele);
            }
        }
        public static void main(String[] args) throws Exception{
            new main().run();
        }
        int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
        void p(Object o){out.print(o);}
        void pn(Object o){out.println(o);}
        void pni(Object o){out.println(o);out.flush();}
        String n()throws Exception{return in.next();} // string input 
        String nln()throws Exception{return in.nextLine();} // 
        int ni()throws Exception{return Integer.parseInt(in.next());}
        long nl()throws Exception{return Long.parseLong(in.next());}
        double nd()throws Exception{return Double.parseDouble(in.next());}

        class FastReader{
            BufferedReader br;
            StringTokenizer st;
            public FastReader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public FastReader(String s) throws Exception{
                br = new BufferedReader(new FileReader(s));
            }

            String next() throws Exception{
                while (st == null || !st.hasMoreElements()){
                    try{
                        st = new StringTokenizer(br.readLine());
                    }catch (IOException  e){
                        throw new Exception(e.toString());
                    }
                }
                return st.nextToken();
            }

            String nextLine() throws Exception{
                String str = "";
                try{   
                    str = br.readLine();
                }catch (IOException e){
                    throw new Exception(e.toString());
                }  
                return str;
            }
        }
    }