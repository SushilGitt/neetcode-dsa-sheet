class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int val:stones) {
            maxHeap.add(val);
        }

        while(maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            maxHeap.add(y - x);
        }

        if(maxHeap.size() == 0) {
            return 0;
        }

        return maxHeap.poll();
    }
}

// TC: O(NlogN)
// SC: O(N)