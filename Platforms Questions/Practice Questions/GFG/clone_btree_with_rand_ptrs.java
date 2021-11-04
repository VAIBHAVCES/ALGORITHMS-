
class GfG{
    //  https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/

    private static HashMap<Tree , Tree >map  = new HashMap<>();
    
    public static Tree cloneTree(Tree tree){
    
    // APROACH -1 - IN THIS TECHNIQUE WE HAVE USED HASHMAP TO REMEMBER 
    // WHICH NODE IS MAPPED CORRESPONDING TO NEW NODE CREATED SO THAT 
    // WHENEVER WE COME TO SET RANDOM POINTERS WE CAN SIMPLY USE HASHMAP TO 
    // CHECH WHICH NODE IS MAPPED
    // FUNCTION CALL FLOW OF CONTROL : -  hashmap_aproach() -> cloneTreeWithoutRandPointer()
      //                                                  | ->  setRandomPointerUsingMap()  
    
    // APROACH -2 - THIS IS A LITTLE SMART APROACH WHERE WE HAVE CREATE A CLONE NODE 
    // IN SAME TREE IN LEFT SIDE OF EACH NODE SO NOW FOR SETTING RANDOM POINTER OF NEW NODE 
    // WHAT I CAN SAY IS THAT RANDOOM POINTER OF NEW NODE WILL BE THE NODE WHICH IS IN LEFT
    // DIRECTION OF MY PARENT NODE .
     // FUNCTION CALL FLOW OF CONTROL : -  withouthashing() -> cloneTreeWithoutRandPointer()
      //                                                  | -> replicateNodesLeft()
      //                                                  | -> setRandomPointerOfDuplicateNodes()
      //                                                  | -> extractNewTree()
      
      Tree hashed_ans= hashmap_aproach(tree);
       Tree aproach2 =withouthashing(tree); 
       return aproach2;
     }
    
    //*****************FUNCTIONS USED IN HASHMAP APROACH  8
    public static Tree hashmap_aproach(Tree node){
         Tree clone= cloneTreeWithoutRandPointer(node);
         setRandomPointerUsingMap ( node , clone );
         return clone;
     }
    public static Tree cloneTreeWithoutRandPointer (Tree node ){
         if(node== null)    return null;
         Tree mynode=new Tree(node.data);
         map.put(node ,mynode);
         mynode.left= cloneTreeWithoutRandPointer(node.left);
         mynode.right=cloneTreeWithoutRandPointer(node.right);
         return mynode;
         
     }
    public static void setRandomPointerUsingMap(Tree node  ,  Tree clone){
            if(node==null) return ;
            clone.random=map.get(node.random);
            setRandomPointerUsingMap(node.left , clone.left);
            setRandomPointerUsingMap(node.right , clone.right);
         
     }
    
    // ****************FUNCTIONS USED IN APROAHC -2 WIITHOUT HASHMAP 
    public static Tree withouthashing(Tree node) {
            
        replicateNodesLeft(node);
        setRandomPointerOfDuplicateNodes(node);
        Tree ans =extractNewTree(node);
        return ans;
        
    }
    public static Tree replicateNodesLeft(Tree node) {
    
        if(node==null)
            return null;
        Tree newnode = new Tree(node.data);
        Tree left= replicateNodesLeft(node.left);
        Tree right =replicateNodesLeft(node.right);
        newnode.left=left;
        node.right=right;
        node.left=newnode;
        return node;
    
    }
    public static void setRandomPointerOfDuplicateNodes(Tree node ){
        
        if(node==null)
            return ;
        Tree real = node.random;
        node.left.random= real==null ? null : real.left ;
        if(node.left!=null)
            setRandomPointerOfDuplicateNodes(node.left.left);
        setRandomPointerOfDuplicateNodes(node.right);
        
    }
    public static Tree extractNewTree(Tree node ){
        if(node==null)  return null;
        Tree clonenode=node.left;
        Tree left= extractNewTree(node.left.left);
        Tree right= extractNewTree(node.right);
        node.left=node.left.left;
        clonenode.left=left;
        clonenode.right=right;
        return clonenode;
        
    }
    
}