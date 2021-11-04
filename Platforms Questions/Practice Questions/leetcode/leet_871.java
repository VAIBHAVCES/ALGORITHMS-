class Solution {
    public int dpsolution(int target, int  startFuel , int [][] stations ){
         int n = stations.length;
        int dp[][]= new int[n+1][n+1];
        for(int i=0; i <=n;i++){
            dp[i][0]=startFuel;
        }
        
        for(int i=1 ;i <=n;i++){
            for(int j=1; j<=i ;j++){
                // no refuelling
                dp[i][j]=dp[i-1][j];
                if( dp[i-1][j-1] >=stations[i-1][0]) 
                    dp[i][j]=Math.max( dp[i][j] , dp[i-1][j-1]  + stations[i-1][1] );
            }
        }
        if (startFuel>=target ) return  0 ;
        for(int i=1;i<=n;i++){
            if(dp[n][i] >=target)
                    return i;
        }
        return  -1;
    }
    public int heap_solution(int target, int startFuel, int[][] stations){
        
        
        int ans =0 , cur = startFuel , n= stations.length ,idx =0;
        PriorityQueue<Integer>pq= new PriorityQueue<Integer>((a,b)->{
            return stations[b][1] -stations[a][1];   
        });
        
        while(cur < target ){
            
            while(idx<stations.length && stations[idx][0]<=cur){
                pq.add(idx++);
            }
            if(pq.size()==0)
                return -1;
            cur+= stations[pq.poll()][1];
            ans++;
            
        }
        return ans;
        
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
           
        
            // APROACH -1 - DP - IN CASE DP[I][J] REPRSENETS THAT UPTO ITH INDEXED  POINT( THAT IS SI[I][0])
            // HOW MUCH PATH COULD I HAVE COVERED IN EXACTLY J TIMES REFUELLING ! CONFUSED ? OBSERVE I HAVE PUTTED 
            // 0TH COLUMN AS STARTFUEL BECAUSE THAT SIGNIFIES IN 0 REFUELLING I CAN MOVE ONLY WITH THE FUEL I HAVE IN TANK
            // NOW AT ANY POINT (I,J) I CAN SAY THAT EITHER I GET REFUELLED AT THIS STOP OR EITHER NOT IF I NOT  GET REFUELLED
            // THAN I CAN SIMPLY COPY VALUE ABOVE ME BUT MY MOTIVE IS TO COLLECT AS MUCH AS MAX FUEL POSSIBLE BECAUSE IF WE THINK
            // A BIT CLOSELY THAN I CAN SAY I NEED TO FIND THAT HOW IN LEAST NO OF REFUELLING I CAN GET MAX FUEL SO WE NEED TO 
            //  MAXIMIZE FUEL HERE IN LEAST NO OF REFUELLING NOW SIMILARLY CONTINUING THIS ALGO OUR LAS ROW SIGNIFIES US THAT IN
            // IN HOW MANY JUMPS WE CAN COLLECT MAX FUEL AND FIRST VALUE OF FUEL WHICH IS GREATER THAN EQUAL TO TARGET IS ANSWER
        
            // return dpsolution(target , startFuel , stations);
        // APROACH -2 - HERE WHAT MY METHODOLOGY IS THAT I HAVE MAINTAINED A PRIORITY QUEUE OF INDICES OF STATIONS
        // AND HAVE WRITTEN A COMPAROTOR WHOSE JOB IS TO KEEP THE VALUE WITH MAX REFUELLING CAPACITY (STATION[I][1]) ON TOP
        // AND START THIS TIME ALSO NOW WHAT I WILL SAY IS THAT START WHILE WE DONT ACHIEVE FUEL FOR OUR TARGET (1ST WHILE LOOP)
        // NOW IN SECOND STEP I WILL ADD ALL THOSE VALUES IN PQ WHICH ARE SMALLER THN STARTFUEL AND KEEP MOVING IDX FORWARD
        
        return heap_solution(target , startFuel , stations);
            
    
    
    }
}