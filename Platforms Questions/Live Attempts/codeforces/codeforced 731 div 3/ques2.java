    // short keys:
    // println()- pln
    // 

    import java.util.*;
    import java.io.*;
    public class main{
        
        //SOLUTION BEGIN
        long mod = 1000000000+7;
        void pre() throws Exception{}
        
        void solve(int TC) throws Exception{
            char str[] = nln().toCharArray();
            
            int si =0 , ei =0 ;
            char small  =(char)('z'+1);
            for(int i=0;i<str.length;i++ ){
                if(str[i]<=small)
                 {
                    small = str[i];
                     si = ei = i;
                 }   
            }
            // System.out.println("samlledst"+)
            int counter = 1;
            boolean ans  =true;
            if(small!='a'){
                pn("NO");
                return;
            }
            while(ans && counter<str.length){
                if(counter==str.length)break;
                small =(char)(small+1);
                // p("search for :"+small+"   ");
                if(si-1>=0 && str[si-1]==small)si--;
                else if(ei+1<str.length && str[ei+1]==small)ei++;
                else ans = false;
                counter++;
            }
            if(ans)pn("YES");
            else pn("NO");



            
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