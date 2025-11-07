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
// -----------------------------------------------------------------------------

// Optimal solution:

class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        int lPtr = 0;
        int rPtr = height.length - 1;

        while(lPtr < rPtr) {
            if(height[lPtr] <= height[rPtr]) {
                if(leftMax > height[lPtr]) {
                    water += leftMax - height[lPtr];
                }
                else {
                    leftMax = height[lPtr];
                }
                lPtr++;
            }
            else {
                if(rightMax > height[rPtr]) {
                    water += rightMax - height[rPtr];
                }
                else {
                    rightMax = height[rPtr];
                }
                rPtr--;
            }
        }

        return water;
    }
}
/*

TC: O(n)
SC: O(1)

*/