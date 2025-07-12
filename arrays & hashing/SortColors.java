class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++; mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int copy = nums[x];
        nums[x] = nums[y];
        nums[y] = copy;
    }
}

/*

TC: O(n)
SC: O(1)

*/