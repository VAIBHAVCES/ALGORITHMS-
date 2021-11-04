    // short keys:
    // println()- pln
    // 

    import java.util.*;
    import java.io.*;
    class CodeChef{
        //SOLUTION BEGIN
        void pre() throws Exception{}
        void solve(int TC) throws Exception{
            String line = nln();
            String splitted[]= line.split(" ");
            int idx =0 ; 
            while(splitted[idx].equals(" ")){
                pn("--"+splitted[idx]+"--");
                idx++;
            }
            line = splitted[idx];
            if(line.length()<=3){
                pn("Error");
                return ;
            }
            String starting = line.substring(0,2);
            String ending=line.substring(line.length()-1,line.length());
            boolean ans = true;
            ans = ans && starting.equals("</");
            ans = ans && ending.equals(">");
            
            // pn(starting+","+ending);
            if(!ans){
                pn("Error  ");
                return ;
            }
            for(int i=2;i<line.length()-1;i++){
                ans = ans && (line.charAt(i)>='a' && line.charAt(i)<='z' )|| (line.charAt(i)>='1' && line.charAt(i)<='9');
                if(!ans){
                    pn("Error");
                    return ;
                }   
            }
            pn("Success");
            
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