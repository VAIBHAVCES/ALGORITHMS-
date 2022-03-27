
        import java.util.*;
        import java.io.*; 
        class CodeChef{
            
            //SOLUTION BEGIN
            long mod = 1000000000+7;
            void pre() throws Exception{}
            ArrayList<Integer> getPrimes(int n ){
                int num = (int)Math.sqrt(n);
                ArrayList<Integer>ans = new ArrayList<>();
                boolean sieve[] = new boolean[num+1];
                for(int  i=2;i<=num;i++){
                    if(!sieve[i]){
                        ans.add(i);
                        for(int j=i*i;j<=num;j+=i){
                            sieve[j]=true;
                        }
                    }
                }
                return ans;

            }
            void solve(int TC, int TTC) throws Exception{
                long n = nl();
                long m = nl();
                long zeros = (n-m);
                if(m>(n/2)){
                    pn(zeros);
                }
                else if(m==0){
                    pn((n*(n+1))/2);
                }
                else if(n==m){
                    pn(0);
                }else if(((zeros+1)==m) || ((m+1)==zeros)){
                    pn(zeros);
                } else if(zeros>=0){
                    long pl= zeros/(m+1);
                    long rem  = zeros - (pl*(m+1));
                    long npl= pl+1;
                    long ans = rem*(npl*(npl+1))/2 +  (m+1-rem)*(pl*(pl+1))/2;
                    pn(ans);
                }

                
            }
            long wrapper(long pl, long n , long m , long zeros  ){
                long ep = Math.min(zeros/pl , m);
                long rem = zeros-(ep*pl);
                long ans =  (ep*(pl*(pl+1))/2 ) + (rem*(rem+1))/2;
                return ans;
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