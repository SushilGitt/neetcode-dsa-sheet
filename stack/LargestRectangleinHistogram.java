class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayDeque <Integer> s = new ArrayDeque<>();

        Arrays.fill(left, -1);
        for(int i = 0; i < n; i++) {

            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(!s.isEmpty()) {
                left[i] = s.peek();
            }

            s.push(i);
        }

        s.clear();

        Arrays.fill(right, n);
        for(int i = n - 1; i >= 0; i--) {

            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(!s.isEmpty()) {
                right[i] = s.peek();
            }

            s.push(i);
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = width * heights[i];
            max = Math.max(max, area);
        }

        return max;
    }
}

/*

TC: O(n)
SC: O(n)

*/