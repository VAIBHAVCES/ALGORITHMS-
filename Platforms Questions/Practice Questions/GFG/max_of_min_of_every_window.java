class MaximumOfWindow {

    static int maxofminOfK(int arr[] , int k ){
        
        int ans = -(int)1e8;
        ArrayDeque<Integer>mem= new ArrayDeque<>();
        int n  =arr.length ,si= 0, ei=0;
        while(ei < n ){
            
            if(ei-si < k){
                while(mem.size() > 0 && arr[mem.peekLast()] > arr[ei] ){
                    mem.removeLast();
                }
                mem.addLast(ei++);
            }
            if(ei-si==k){
                ans = Math.max(ans, arr[mem.peekFirst()] ) ;
                si++;
                while(mem.size() >0 && mem.peekFirst()<si)
                    mem.removeFirst();
            }
            
        }
        return ans;
        
    }
    
    static int[] usingNextGreater(int arr[] , int k ){
        
        int n  = arr.length;
        int ns []= new int[arr.length];
        int ps [] =new int[arr.length];
        int ans[]= new int[n];
        Stack<Integer>st = new Stack<>();
        st.push(n);
        for(int i=n-1;i>=0;i--){
            
            while(st.size() >0 && st.peek()!=n && arr[st.peek()] >= arr[i] ){
                st.pop();
            }
            ns[i]=st.peek();
            st.push(i);
        }
        st = new Stack<>();
        st.push(-1);
        for(int i=0 ;i< n;i++){
            
            while(st.size() >0 && st.peek()!=-1 && arr[st.peek()] >= arr[i] ){
                st.pop();
            }
            ps[i]=st.peek();
            st.push(i);
            // System.out.println(i+ " : " +ps[i]);
                
        }
        
        for(int i=0;i<n;i++){
            int idx= ns[i]-ps[i] -2;
            ans[idx]=Math.max(ans[idx] ,arr[i]  );
        }
        for(int i=n-2;i>=0;i--){
            ans[i]=Math.max(ans[i+1] , ans[i]);
        }
        return ans;
        
        
    }
    static int[] printMaxOfMin(int[] arr, int k) {
        
        // APROACH -1  O(N^2)- USING SLIDING WINDOW TECHNIQUE 
        // int ans[] = new int[arr.length];
        // for(int i=1 ;i <=arr.length;i++){
            
        //  ans[i-1]= maxofminOfK(arr, i );
            
        // }
        // return ans;
        
        // APRAOCH = 2 = using stack aproach of neext greater element
        return usingNextGreater(arr,k );
        
        
    }
}