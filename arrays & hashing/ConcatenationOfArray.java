class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int length = nums.length;
        int[] ans = new int[2 * length];

        for (int i = 0; i < length; i++) {
            ans[i] = nums[i];            
            ans[i + length] = nums[i];  
        }
 
        return ans;
    }
}
/*

TC: O(n)
SC: O(2n)

--> Where n is the length of array.

*/