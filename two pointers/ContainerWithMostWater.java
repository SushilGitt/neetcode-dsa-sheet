class Solution {
    public int maxArea(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        
        while(i < j) {
            int dis = j - i;
            int currWater = Math.min(height[i], height[j]) * dis;
            water = Math.max(currWater, water);

            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }

        return water;
    }
}
/*

TC: O(n)
SC: O(1)

*/