class FreqStack {

    HashMap <Integer, Integer> freqMap;
    HashMap <Integer, ArrayDeque<Integer>> freqStacks;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStacks = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freqMap.putIfAbsent(val, 0);
        int freq = freqMap.get(val) + 1;
        freqMap.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);

        freqStacks.putIfAbsent(freq, new ArrayDeque<>());
        freqStacks.get(freq).push(val);
    }
    
    public int pop() {

        if(freqStacks.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        int v = freqStacks.get(maxFreq).poll();
        freqMap.put(v, freqMap.get(v) - 1);

        return v;
    }
}
/*

TC: O(n)
SC: O(n)

*/