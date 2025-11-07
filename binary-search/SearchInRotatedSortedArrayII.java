class Solution {
    public boolean search(int[] nums, int target) {
        int min = 0,
            max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[min] == nums[mid] && nums[mid] == nums[max]) {
                min++; max--;
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

        return false;
    }
}

// TC: O(log(n)) for average and worst case O(n)
// SC: O(1)