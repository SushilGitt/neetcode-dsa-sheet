/*

Brute force:

--> Put all numbers into a set
--> Check from 1 to n+1 which number is not in set 
--> Then return it.

--> TC: O(n)
--> SC: O(n)
*/




class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for(int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
/*

TC: O(n)
SC: O(1)

*/