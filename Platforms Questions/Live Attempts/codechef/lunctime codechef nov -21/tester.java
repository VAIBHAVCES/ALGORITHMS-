

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

 class tester {
	 static int[][] dp=new int[1000001][2];
	 static String s;
	 static List<Integer> al=new ArrayList<>();
static class FastReader {
	
		
        BufferedReader bro;
        StringTokenizer st;
 
        public FastReader()
        {
            bro = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bro.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = bro.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	public static void main(String[] args) {
		try
		{
			FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(System.out);
            int t=sc.nextInt();
            while(t-->0)
            {
            	int n;
            	n=sc.nextInt();
            	long[] arr=new long[n];
            	long sum=0L,mx,mn;
            	for(int i=0;i<n;i++) arr[i]=sc.nextLong();
            	for(int i=0;i<n;i++)
            	{
            		mx=mn=arr[i];
            		List<Long> al=new ArrayList<>();
            		for(int j=i;j<n;j++)
            		{
            			mn=Math.min(mn,arr[j]);
                        mx=Math.max(mx,arr[j]);
                        al.add(arr[j]);
                        if(j-i>= 2)
                        {    
                            int ind=LowerBound(al,(mx+mn)/2,0,al.size());
                            long ans=0L;
                            if(al.get(ind)!=al.get(al.size()-1))
                                ans=Math.max(ans,(mx-al.get(ind))*(al.get(ind)-mn));
                            
                            if(al.get(ind)!=al.get(0))
                             {
                            	ind--;
                            	ans=Math.max(ans,(mx-al.get(ind))*(al.get(ind)-mn));
                             }

                            sum+=ans;
                        }
            		}
            	}
            	System.out.println(sum);
    		}
	        out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static int recursive_lower_bound(long array[], int low,int high, long key)
	{
	// Base Case
	if (low > high) {
	return low;
	}
	
	// Find the middle index
	int mid = low + (high - low) / 2;
	
	// If key is lesser than or equal to
	// array[mid] , then search
	// in left subarray
	if (key <= array[mid]) {
	
	return recursive_lower_bound(array, low,
	                mid - 1, key);
	}
	
	// If key is greater than array[mid],
	// then find in right subarray
	return recursive_lower_bound(array, mid + 1, high,
	            key);
	}
	static int LowerBound(List<Long> a, long x,int start,int end) 
	{ 
		  int l=start-1,r=end+1;
		  while(l+1<r) 
		  {
		    int m=(l+r)>>>1;
		    if(a.get(m)>=x) r=m;
		    else l=m;
		  }
		  return r;
	}
	void shuffleArray(long[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }   
	}
}
