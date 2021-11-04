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
            int narr[]  = new int[n];
            int marr[]  = new int[m];
            int zeros = 0;
            while(i<n){
                narr[i]=ni();
                zeros=narr[i]==0?zeros+1:zeros;
                i++;
            }
            i=0;
            while(i<m) {
                marr[i]=ni();
                zeros=marr[i]==0?zeros+1:zeros;
                i++;
            }
            int ni = 0 ; 
            int mi = 0 ; 
            StringBuffer sb = new StringBuffer();
            while(ni < n && mi < m){
                // pn("infy");
                if(narr[ni] <  marr[mi]){
                    if(narr[ni]==0){
                        k++;
                    }else if(narr[ni] > k){
                        pn("-1");
                        return;
                    }
                    sb.append(narr[ni]+" ");
                    ni++;
                    

                }else{
                    if(marr[mi]==0){
                        k++;
                    } else if(marr[mi] > k){
                        pn("-1");
                        return;
                    }
                    sb.append(marr[mi]+" ");
                    mi++;
                    
                }
            }

            while(ni< n){
                if(narr[ni]==0){
                    k++;
                }else if(narr[ni] > k){
                    pn("-1");
                    return;
                }
                sb.append(narr[ni]+" ");
                ni++;
                

            }

            while(mi<m){
                if(marr[mi]==0){
                    k++;
                } else if(marr[mi] > k){
                    pn("-1");
                    return;
                }
                sb.append(marr[mi]+" ");
                mi++;
                

            }
            pn(sb.toString());
            
            
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