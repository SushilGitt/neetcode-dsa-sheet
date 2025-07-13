class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int i = 0, j = nums.length-1;
        
        while(i < j) {
            if(nums[i] + nums[j] > target) j--;
            else if(nums[i] + nums[j] < target) i++;
            else return new int[] {i+1, j+1};
        }

        return new int[] {};
    }
}
/*

TC: O(n)
SC: O(1)

*/