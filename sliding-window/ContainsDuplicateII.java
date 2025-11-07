class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();

        for(int i = 0; i <= k && i < nums.length; i++) {
            if(numSet.contains(nums[i])) {
                return true;
            }
            numSet.add(nums[i]);
        }

        int idx = 0;
        for(int i = k + 1; i < nums.length; i++) {
            numSet.remove(nums[idx]);
            idx++; 
            if(numSet.contains(nums[i])) {
                return true;
            }
            numSet.add(nums[i]);
        }

        return false;
    }
}
/*

TC: O(n)
SC: O(k)

*/