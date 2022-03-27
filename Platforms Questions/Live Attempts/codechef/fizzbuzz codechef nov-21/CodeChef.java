
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
                int k = ni();
                
                ArrayList<Integer>mem =  new ArrayList<>();
                for(int i=0;i<n;i++){
                    int inp = ni();
                    if(mem.size()==0 || mem.get(mem.size()-1)!=inp) mem.add(inp);
                }
                if(k==1){
                    pn(0);
                    return;
                }// pn("mem: ");
                // pn(mem);
                if(n==k){
                    for(int i=0;i<k;i++) p(n-2+" ");
                    
                    pn("");
                }else{
                    int map[][] = new int[k][2];
                    for(int i=0;i<mem.size();i++){
                        map[mem.get(i)-1][0]++;
                        if(i>0 && i<mem.size()-1){
                            int prev = mem.get(i-1);
                            int next = mem.get(i+1);
                            if(prev==next) map[mem.get(i)-1][1]++;
                        }
                    }
                    for(int i=0;i<map.length;i++){
                        p(mem.size()-1-map[i][0]-map[i][1]+" ");
                    }   
                    pn("");
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