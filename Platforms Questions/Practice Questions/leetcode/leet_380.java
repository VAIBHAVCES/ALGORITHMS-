class RandomizedSet {

    /** Initialize your data structure here. */
    
    HashMap<Integer,Integer>vis;
    List<Integer>arr;
    
    public RandomizedSet() {
        vis = new HashMap<>();
        arr= new ArrayList<>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(vis.containsKey(val)) return false;
        vis.put(val ,arr.size() );
        arr.add(val) ;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(vis.size()==0 || !vis.containsKey(val))   return false;
        int idx = vis.get(val);
        int n  = arr.size()-1;
        int value =arr.get(n);
        arr.set(idx, value);
        arr.remove(n);
        //**********POINT OF ERROR NEXT 2 LINES SHOULD HAVE SAME ORDER FIRST UPDATE THEN DELETE
        vis.put(value , idx);
        vis.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(arr.size());
        return arr.get(idx);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */