class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        char[] str = s.toCharArray();
        int left = 0, maxLength = 0;

        for(int right = 0; right < str.length; right++) {
            while(charSet.contains(str[right])) {
                charSet.remove(str[left]);
                left++;
            }
            charSet.add(str[right]);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
/*

TC: O(n)
SC: O(n)

*/