class KthLargest {
    int size;
    PriorityQueue <Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();

        for(int num:nums) {
            minHeap.add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);

        while(minHeap.size() > size) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

// TC: O(logK)
// SC: O(K)