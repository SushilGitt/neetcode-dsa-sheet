class Solution {
    public int findMin(int[] nums) {
        int minValue = 5000,
            min = 0,
            max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[min] <= nums[mid]) {
                minValue = Math.min(minValue, nums[min]);
                min = mid + 1;
            }
            else {
                minValue = Math.min(minValue, nums[mid]);
                max = mid - 1;
            }
        }

        return minValue;
    }
}

// TC: O(log(n))
// SC: O(1)