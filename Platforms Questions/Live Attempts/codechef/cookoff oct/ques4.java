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

            void solve(int TC, int TTC) throws Exception{
                
                int n = ni();

                int ones[] = new int[n/2];
                Integer zeros[]= new Integer[n-(n/2)];
                int x=0, y=0;

                int sumOfOnes = 0 ;
                for(int i=0;i<n;i++){

                    int inp = ni();
                    if(i%2==0)zeros[x++]=inp;
                    else{
                        ones[y]=inp;
                        // pn("summing: "+inp+" and  : "+i);
                        sumOfOnes+=ones[y];
                        y++;
                    }
                }

                Arrays.sort(ones);
                Arrays.sort(zeros,Collections.reverseOrder());
                int ans = 0 ;
                y = 0;
                x=0;
                for(int i=0;i<n;i++){
                    if(i%2==0){
                        p(zeros[x++]+" ");
                    }else{
                        p(ones[y++]+" ");
                    }
                }
                pn("");

                y = 0;
                x=0;
                while(y<ones.length){
                    // pn(" += "+sumOfOnes+"*"+zeros[x]);
                    ans+=sumOfOnes*zeros[x];
                    x++;
                    sumOfOnes-=ones[y];
                    y++;
                }
                pn(ans);
                

            }
            //SOLUTION END
            void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
            static boolean multipleTC = true;
            FastReader in;PrintWriter out;

            void run() throws Exception{
                in = new FastReader();
                out = new PrintWriter(System.out);
                int T = (multipleTC)?ni():1;
                pre();for(int t = 1; t<= T; t++)solve(t,T);
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