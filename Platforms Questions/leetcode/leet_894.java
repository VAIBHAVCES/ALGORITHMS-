
class Solution {
    // APROACH = SO WHEN I READ THIS QUESTION FIRST TIME MY FIRST IDEOLOGY WAS
    // I NEED TO MAKE CUTS TO IDENTIFY ALL COMBINATION OF NODES IN PROVIDED CONDITIONS 
    // SO IN FIRST TRY I CHANGES MY QUESTION LANGUAGE AND STARTED TO THINK THAT HOW CAN 
   // I WRITE CODE FOR A PROBLEM WHICH SAYS FIND NO OF TREES POSSIBLE IN SAME CONDITIONS.
   // THEN AFTER SOLVING THAT I IMAGINED THAT HOW CAN I MAKE IT IN TREE FORM BECAUSE PATTERN
   // OF NODES WILL BE SAME AS OF TOTTAL NO OF NODES ;

    //  TIP FOR THINKING - JUST TRY TO SOLVE PROBLEM WHICH SAYS FIND NO OF TREES POSSIBLE
    // IN SAME CONDITIONS. IF YOU CAN SOLVE THAT 90% WORK IS DONE NOW TO THINK OF THIS 
    // PROBLEM TRY TO FIGURE OUT A PATTERN THAT EACH TREE LEVEL HOW MANY NODES ARE THEIR 
    // IN EACH TREE SOON YOU WILL START TO OBSERVE A PATTERN 

    public List<TreeNode> allSols(int n  ){
        List<TreeNode>temp = new ArrayList<>();
        if(n==1){
            temp.add(new TreeNode(0));
            return temp;
        }
        
        TreeNode node ;
        for(int cut =1; cut < n-1 ; cut+=2){
            
            List<TreeNode>left = allSols(cut);
            List<TreeNode>right = allSols(n-cut-1);
            
            for(TreeNode lefti : left){
                
                for(TreeNode righti :right ){
                    
                     node =new  TreeNode(0);
                     node.left= lefti;
                     node.right=righti;
                     temp.add(node);        
                }
            }
            
            
        }
        return temp;
        
    }
    public List<TreeNode> allPossibleFBT(int N) {
        return allSols(N);
    }
}