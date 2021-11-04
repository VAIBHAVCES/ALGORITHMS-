import java.util.*;
import java.io.*;
class main{

    public static void main(String args[]) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input4(bf);
        
    }
    public static void ques1(int x1, int x2, int y1 , int y2 , int z1 ,int z2){
        if(x2 >= x1 && y2 >= y1 && z2<=z1){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

    public static void input1( BufferedReader bf) throws Exception{
         int n=  Integer.parseInt(bf.readLine());
        while(n-->0){

            String line[] = bf.readLine().split(" ");
            int x1=  Integer.parseInt(line[0]);
            int x2=  Integer.parseInt(line[1]);
            int y1=  Integer.parseInt(line[2]);
            int y2=  Integer.parseInt(line[3]);
            int z1=  Integer.parseInt(line[4]);
            int z2=  Integer.parseInt(line[5]);
            ques1( x1,  x2,  y1 ,  y2 ,  z1 , z2);
        }
    }
    
    public static void input2( BufferedReader bf) throws Exception{
         int n=  Integer.parseInt(bf.readLine());
        while(n-->0){

             HashSet<Integer>track = new HashSet<>();
            int len =  Integer.parseInt(bf.readLine());
            String line[] = bf.readLine().split(" ");

            int ans = 0;
            for(int i=0;i<line.length;i++){
                int ele =Integer.parseInt(line[i]);
                if( track.size()<7) {
                   if(ele>=1 && ele<=7) track.add(ele);
                    ans++;
                }
            }
            System.out.println(ans);
        
        }
    }

     public static void input3( BufferedReader bf) throws Exception{
            String line[] = bf.readLine().split(" ");
            int n=  Integer.parseInt(line[0]);
            int q=  Integer.parseInt(line[1]);
            int arr[] = new int[n];
            line = bf.readLine().split(" ");
            for(int i=0;i<n;i++ ){
                arr[i]=Integer.parseInt(line[i]);
            }
            Arrays.sort(arr);
        while(q-->0){
            int xi=  Integer.parseInt(bf.readLine());
            ques3(arr,xi,n);
        }
    }
    public static void ques3(int arr[] , int xi, int n){
        if(xi > arr[n-1]){
            System.out.println("POSITIVE");
            return ;
        }
        if(xi < arr[0]){
            System.out.println( n%2==0?"POSITIVE":"NEGATIVE");
            return ;
        }
        int si =0 , ei = n-1 , firstGreater = n-1;
        // for(int vals: arr){
        //     System.out.print(vals+" - ");
        // }
        while(si<=ei){
            // System.out.println("si : "+si+" , ei :"+ei+" "+xi);
            int mid = (si+ei)/2;
            if(arr[mid]>xi){
                ei=mid-1;
                firstGreater=mid;
            }else if(arr[mid]<xi){
                si=mid+1;
                // firstGreater = si;
            }else{
                System.out.println("0");
                return ;
            }
        }
        int count =0 ;
        // System.out.println("first greater is :"+firstGreater);
        for(int itr = firstGreater;itr<n;itr++){
            if(itr<0) count++;
        }
        // int firstPositive = bst(arr, 0);
        int greater = n-firstGreater;
        // int smaller = n-greater;
        
        // System.out.println("greater : "+greater+" "+firstGreater+" val : "+arr[firstGreater]);
        if(greater%2==0){
            System.out.println("POSITIVE");
            return;
        }
        System.out.println("NEGATIVE"); 


    }

    public static void ques4(String str){
        int ones = 0;
        for(int i=0;i<str.length();i++) ones+=str.charAt(i)-'0';
        int n=  str.length();
        int minChanges = (int)1e9;
        for(int factor=1;factor<=n;factor++){
            if(n%factor!=0)continue;
            // now i is a factor of n
            // System.out.println("facory : "+factor);
            for(int d=0;d<factor;d++){
                // because any facot can have d-1 no of combinations
                int realOnes= 0;
                for(int j=d;j<n;j+=factor){
                    realOnes+=str.charAt(j)-'0';
                }
                minChanges = Math.min(minChanges, n/factor+ones-2*realOnes);
            }

        }
        System.out.println(minChanges);


    }
    public static void input4( BufferedReader bf) throws Exception{
        int n=  Integer.parseInt(bf.readLine());
        while(n-->0){
            int len =  Integer.parseInt(bf.readLine());
            String steroid = bf.readLine();
            ques4(steroid);
        }
    }
}