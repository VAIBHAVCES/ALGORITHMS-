class FreqStack {
    
    
    // WE ARE CREATING HEAR 2 MAPS 
    // MAP -1 - IT WILL TRACK FREQUENCY OF A PARTICULAR ELEMENT
    // MAP-2 - IT WILL STORE ELEMENTS OF A PARTICULAR FREQUENCY
    // IF MULTIPLE ELEMENTS WITH SAME FREQUENCY THEY WILL BE STORED
    // ON THE BASES OF THEIR OCCURENCE
    
    
    HashMap<Integer ,Integer>freq;
    HashMap<Integer ,Stack<Integer> >mem;
    int maxFreq;

    public FreqStack() {
        freq= new HashMap<>();
        maxFreq=0;
        mem= new HashMap<>();
    }
    
    public void push(int x) {
        int myFreq=freq.getOrDefault(x,0)+1;
        freq.put(x,myFreq);
        maxFreq=Math.max(maxFreq,myFreq);
        if(mem.containsKey(myFreq)){
            mem.get(myFreq).push(x);
        }else{
            mem.put(myFreq , new Stack<>() );
            mem.get(myFreq).push(x);
        }
        
        
    }
    
    public int pop() {
        int ans = mem.get(maxFreq).pop();
        freq.put(ans,maxFreq-1);
        if(mem.get(maxFreq).size()==0) maxFreq--;
        return ans;
    }
}
