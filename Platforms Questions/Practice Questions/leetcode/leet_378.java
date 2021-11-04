class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // return worstAproach();
        return nextLvlAproach(matrix, k );
        
        
    }
    public int worstAproach(int matrix[][] ,int k ){
        int pow =0 ;
        while( (int)Math.pow(2,pow) < k){
            pow++;
        }
        
        PriorityQueue<Integer>mem = new PriorityQueue<>();
        int start = (int)Math.pow(2,pow);
        for(int i=0 ; i<=pow; i++){
            mem.add(matrix[pow][i]);
        }
        
        for(int i=0 ; i< pow; i++){
            mem.add(matrix[i][pow]);
        }
        while(start < k ){
            mem.remove();
            start++;
        }
        return mem.remove();
    }
    
    // APROACH -2 -ITS NOTHING BUT A BINARY SEARCH IN A ROW WISE AND COLUMN WISE SORTED ARRAY 
    // SO IF YOU DONT KNOW HOW TO DO THAT FIRST OF ALL REFER THAT NOW IN CASE HERE AT EVERY STEP
    // WHAT WE DO IS WE SEE THAT HOW MANY ELEMENTS ARE AS SUCH WHICH HAVE VALUES LESS THAN K 
    // AS SOON AS K REACHES 
    public int nextLvlAproach(int arr[][] ,int k ){
        
        int n =arr.length;
        int low = arr[0][0];
        int hi = arr[n-1][n-1];
        
        while(low < hi ){
            int mid = ( low + hi ) /2  ;    
            int ftc = getElementsSmaller(arr,mid);
            if(ftc >= k ){
                hi = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }
    
    public int getElementsSmaller(int arr[][] , int tar ){
        int i = 0 , j =  arr.length-1 , count = 0 ;
        
        while(j >=0  && i< arr.length ){
            
            if(arr[i][j] <= tar ){
                count+= (j+1);
                i++;
            }else{
                j--;
            }
        }
        return count ; 
    }
}