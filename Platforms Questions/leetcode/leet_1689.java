class Solution {
    public int minPartitions(String n) {
        // VERY EASY JUST OBSERVE NUMBER PATTERN
        int max = -(int)1e8; 
        for(int i=0;i<n.length();i++)
        {
            int num =n.charAt(i)-'0';
            max = Math.max(max, num );
        }
        return max ;
    }
}