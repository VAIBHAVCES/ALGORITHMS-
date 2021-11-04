    // short keys:
    // println()- pln
    // 

    import java.util.*;
    import java.io.*;
import java.lang.reflect.Array;
     class CodeChef{
        
        //SOLUTION BEGIN
        long mod = 1000000000+7;
        void pre() throws Exception{}
        
        boolean isPrime(long n){
            for(int i=2;i*i<=n;i++){
                if(n%i==0)return false;
            }
            return true;
        }

        void solve(int TC) throws Exception{
            
            // String line[] = nln().split(" ");
            
            long n1 = nl();
            long n2 = nl();
            long max = Math.max(n1, n2);
            long min = Math.min(n1, n2);
            // pn(min+" "+max);
            // pn(n1+" "+n2);
            if((max%min==0)||(max%2==0 && min%2==0)){
                pn("0 ");
                return;
            }
            long idea = (long)Math.ceil(max/min);
            long diff = 
            // if((max%2==0 && min%2!=0)|| (max%2!=0 &&min%2==0) ){
                pn("1");
                // return;
            // }
            // both odd 
            // i
                     
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
            new CodeChef().run();
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