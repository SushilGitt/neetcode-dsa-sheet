/*

Extreme brute force:

--> Using three nested loops to find all subarrays that's sum >= target
--> Return minimum length of them

TC: O(n^3)
SC: O(1)

*/

/*


Brute force:

--> Using two nested loops to find all subarrays that's sum >= target
--> Return minimum length of them

TC: O(n^2)
SC: O(1)

*/
// -----------------------------------------------------------------------------



/*
Optimal:

--> Using sliding window 

TC: O(n)
SC: O(1)

*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int sum = 0;
        int left = 0;
        int right = 0;
        int found = 0;
        
        while(right < nums.length) {
            sum += nums[right++];

            while(sum >= target) {
                found = 1;
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }

        return (found == 0) ? 0 : length;
    }
}
