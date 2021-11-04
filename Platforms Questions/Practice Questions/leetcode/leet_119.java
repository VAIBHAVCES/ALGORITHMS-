//**************POPULATING NEXT RIGHT POINTERS IN EACH NODE 
//*************QUESTION CATEGORY - TREE , RECUSRION , BFS 
    public  Node BFS_aproach(Node root){
        if(root==null)
                return root;
        ArrayDeque<Node>mem= new ArrayDeque<>();
        mem.addLast(root);
        while(mem.size()!=0){
            
           int size=mem.size();
            while(size-- > 0 ) {
                Node top = mem.removeFirst();
                if(top.left!=null) mem.addLast(top.left);
                if(top.right!=null) mem.addLast(top.right);
                
                if(size==0) top.next=null;
                else top.next=mem.peekFirst();
                
                
            }
        }
        return root;
        
    } 
    
    public Node WithoutSpaceAproach(Node root){
        if(root==null)  return null;
        if(root.left!=null )root.left.next=root.right;
        if(root.right!=null  && root.next!=null) root.right.next=root.next.left;
        WithoutSpaceAproach(root.left);
        WithoutSpaceAproach(root.right);
        
        return root;
    }
    public Node connect(Node root) {
      
        // RECURSIVE APROACH -:
        // FAITH - I KEEP FAITH THAT MY PARENT NODES WILL BE MANAGED WHAT
        // I HAVE TO MANAGE IS THAT I HAVE TO SET NEXT POINTER OF MY LEFT
        //CHILD TO MY RIGHT CHILD POINTER AND MY RIGHT CHILD'S NEXT POINTER TO MY 
        //PARENT'S  LEFT CHILD POINTER
        
        // return WithoutSpaceAproach(root);
        
        return BFS_aproach(root);
    }
    
}