import java.util.*;
import java.lang.*;
import java.io.*;
class tester{
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0){
		    int n=sc.nextInt(),k=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=sc.nextInt();
		    int ugly[]=new int[k+1],num[]=new int[k+1],consec_diff=0,i=0;
		    while(i<n){
		        int end=i;
		        while(end<n-1 && a[i]==a[end+1]) end++;
		        if(i>0 && end<n-1 && a[i-1]!=a[end+1]) ugly[a[i]]++;
		        i=end+1;
		    }
		    for(int j=0;j<n-1;j++){
		        if(a[j]!=a[j+1]){
		            consec_diff++;
		            num[a[j]]++;
		            num[a[j+1]]++;
		        }
		    }
		    for(int j=1;j<=k;j++){
		        ugly[j]+=consec_diff-num[j];
		        System.out.print(ugly[j]+" ");
		    }
		    System.out.println();
		}
	}
}
