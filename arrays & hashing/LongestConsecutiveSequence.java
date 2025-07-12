class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        // Add all numbers to the set
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        // Check only for sequence starts
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int len = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    len++;
                }

                longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}

/*

TC: O(n)
SC: O(n)

*/