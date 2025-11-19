class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator <int[]> maxHeapComparator = (p1, p2) -> {
            return getDistance(p2[0], p2[1]) - getDistance(p1[0], p1[1]);
        };

        PriorityQueue <int[]> maxHeap = new PriorityQueue<>(maxHeapComparator);

        for(int[] point:points) {
            maxHeap.add(point);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[maxHeap.size()][2];
        
        for(int i = 0; i < ans.length; i++) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }

    private int getDistance(int x, int y) {
        return (x * x) + (y * y);
    }
}

// TC: O(NlogK)
// SC: O(K)