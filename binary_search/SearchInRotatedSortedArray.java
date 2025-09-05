class Solution {
    public int search(int[] nums, int target) {
        int min = 0,
            max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[min] <= nums[mid]) {
                if(target >= nums[min] && target <= nums[mid]) {
                    max = mid - 1;
                }
                else {
                    min = mid + 1;
                }
            }
            else {
                if(target >= nums[mid] && target <= nums[max]) {
                    min = mid + 1;
                }
                else {
                    max = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

// TC: O(log(n))
// SC: O(1)