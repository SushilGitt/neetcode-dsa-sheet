class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int L = 0;
        for(int i = 0; i < n; i++) {
            left[i] = L;
            L = Math.max(L, height[i]);
        }

        int R = 0;
        for(int i = n - 1; i >= 0; i--) {
            right[i] = R;
            R = Math.max(R, height[i]);
        }

        int water = 0;
        for(int i = 0; i < n; i++) {
            int currtrap = Math.min(left[i], right[i]) - height[i];
            if(currtrap > 0) {
                water += currtrap;
            }
        }

        return water;
    }
}
/*

TC: O(n)
SC: O(n)

*/