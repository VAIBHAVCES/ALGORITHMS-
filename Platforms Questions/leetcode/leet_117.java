
class Solution {
    public Node BFS_aproach(Node root){
        if(root==null) return null;
        ArrayDeque<Node>mem = new ArrayDeque<>();
        mem.addLast(root);
        while(mem.size()!=0 ){
            int size=mem.size();
            while(size-- > 0 ){
                Node top=mem.removeFirst();
                if(top.left!=null) mem.addLast(top.left);
                if(top.right!=null ) mem.addLast(top.right);
                if(size==0) top.next=null;
                else top.next=mem.peek();
                
            }
        }
        return root;
    }
   
    Stack<Node>temp= new Stack<Node>();
    //THIS APROACH IS USING RECURSION ADMITTING I HAVE FOUND THIS APROACH 
    // IN DISCUSSION TAB = IT IS JUST IMPLEMETING DFS AND A ONE OF A KIND 
    // OF RIGHT DFS , WHAT IT DO IT INITIALLY IT GOES IN RIGHT MOST LANE 
    //  BECAUSE WE ARE SURE THAT IT WILL HAVE NEXT POINTER ON NULL 
    // AND IN POST AREA WE WILL START PUTTING NODE 
    
    public Node Stack_aproach(Node root){
        if(root==null)
                return null;
        
        root.next=temp.isEmpty() ? null : temp.pop();
        
        Stack_aproach(root.right);
        Stack_aproach(root.left);
        temp.push(root);
        return root;
    }
    public Node connect(Node root) {
        
        // return BFS_aproach(root);
        //**********DFS APROACH  
        return Stack_aproach(root);
        
    }
}