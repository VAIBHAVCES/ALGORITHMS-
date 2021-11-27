        // short keys:
        // println()- pln
        // 

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
                int n = ni();
                long arr[] = new long[n];
                for(int i=0;i<n;i++){
                    arr[i]=nl();
                }
                long ans  = 0 ;
                for(int i=2;i<=n;i++){
                    // System.out.println(i);
                    for(int x=0,y=x+i;y<=n-1;x++,y++){
                        
                        // find k 
                        long tar  = ((arr[y]-arr[x])/2)+arr[x] ;
                        int si  =x  , ei = y ; 
                        long sml = arr[x] , lg = arr[y];
                        while(si<=ei){
                            int mid = (si+ei)/2;
                            if(arr[mid]>tar){
                                lg = Math.min(lg, arr[mid]);
                                ei = mid-1;
                            }else if(arr[mid]<tar){
                                sml = Math.max(sml ,arr[mid]);
                                si = mid+1;
                            }else{
                                sml = lg = arr[mid];
                                break;
                            }

                        }
                        long contr = 0 ;
                        if(sml==lg && sml==tar){
                            contr=((arr[x]-tar)*(tar-arr[y]));
                        }else {
                            long m1 =((arr[x]-sml)*(sml-arr[y]));
                            long m2 =((arr[x]-lg)*(lg-arr[y]));
                            contr= Math.max(m1 , m2);
                        }
                        // pn("for : "+ tar+"with (" +x+" , "+y +") prev smaller: "+sml+" next  larger : "+lg+" contri : "+contr);
                        ans+=contr;
                    
                    
                    }
                    // System.out.println();
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