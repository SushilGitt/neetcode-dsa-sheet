
// Boyer-Moore Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0, counter = 0;

        for(int i = 0; i < nums.length; i++) {
            if(counter == 0) {
                majority = nums[i];
                counter++;
            }
            else if(majority == nums[i]) {
                counter++;
            }
            else {
                counter--;
            }
        }
        return majority;
    }
}

/*

TC: O(n)
SC: O(1)

*/