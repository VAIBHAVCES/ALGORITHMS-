    // short keys:
    // println()- pln
    // 

    import java.util.*;
    import java.io.*;
    class main{
        
        //SOLUTION BEGIN
        long mod = 1000000000+7;
        void pre() throws Exception{}
        // long gcd(long a, long b){   
        //     if(a==0)return b;
        //     if(b==0)return a;
        //     if(a==b)return a;
        //     return a>b?gcd(a-b,b):gcd(a,b-a);
        // }
         long gcd(long A, long B) {
            if(B == 0) {
                return A;
            }
            return gcd(B, A % B);
        }
        void solve(int TC) throws Exception{
           
            int n = ni();
             int k = ni();
            HashMap<Integer, Integer>map = new HashMap<>();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                int val = ni();
                arr[i]=val;
                map.put(val ,map.getOrDefault(val, 0)+1);
            }
            int nn = map.keySet().size();
            int counter =0;
            for(int keys : map.keySet() ){
                int freq= map.get(keys);
                if(freq >= k ) map.put(keys,k);
                else counter+=freq;
            }
            counter/=k;
            for(int i=0;i<n;i++){
                int getted = map.get(arr[i]);
                if(getted==k){
                    p(arr[i]+" ");
                }else{
                    if(counter > 0){
                        if(getted-1==0)counter--;
                        map.put(arr[i],getted-1);
                        p(arr[i]+" ");
                    }else{
                        p("0 ");
                    }
                }
            }
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