    // short keys:
    // println()- pln
    // 

    import java.util.*;
    import java.io.*; 
     class CodeChef{
        
        //SOLUTION BEGIN
        long mod = 1000000000+7;
        void pre() throws Exception{}
        
        void solve(int TC) throws Exception{
            

                int n = ni();
                int orig = n;
                int a = ni();
                int b  = ni();
                int of = 0 , ef = 0;
                int ev_count = 0, od_count = 0;
 
                while (n%2==0)
                {
                    ef++;
                    n /= 2;
                }
        
                // n must be odd at this point.  So we can
                // skip one element (Note i = i +2)
                for (int i = 3; i <= Math.sqrt(n); i+= 2)
                {
                    // While i divides n, print i and divide n
                    while (n%i == 0)
                    {
                        if(i%2==0)ef++;
                        else of++;
                    }
                }
                
                // for(int i=2;i<orig;i++){
                //     while(n%i==0){
                //         n/=i;
                //         if(i%2==0)ef++;
                //         else of++;
                //         // System.out.println(i+" "+n);
                //     }
                //     if(n==1)break;
                // // }
                // ef = ev_count/2;
                // of = od_count/2;
                System.out.println("of: "+of+" ef : "+ef);
                
                // System.out.println("of: "+ev_count+" ef : "+od_count);

                if(a>=0&&b>=0){
                    pn(a*ef+b*of);
                }else if(a>=0&&b<0){
                    pn(a*ef+b);
                }else if(a<0&&b>=0){
                    pn(a+b*of);
                }else{
                    pn(a+b);
                }
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