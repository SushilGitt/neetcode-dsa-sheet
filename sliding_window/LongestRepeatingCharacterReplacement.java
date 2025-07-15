class Solution {
    public int characterReplacement(String s, int k) {
        int lPtr = 0;
        int rPtr = 0;
        int longest = 0;
        int n = s.length();
        int[] freq = new int[26];

        while(rPtr < n) { 
            freq[s.charAt(rPtr) - 'A']++;

            if((rPtr - lPtr + 1) - maxFreq(freq) <= k) {
                longest = Math.max(longest, rPtr - lPtr + 1);
                rPtr++;
            }
            else {
                freq[s.charAt(lPtr) - 'A']--;
                freq[s.charAt(rPtr) - 'A']--;
                lPtr++;
            }
        }

        return longest;
    }

    private int maxFreq(int[] freq) {
        int mx = 0;
        for(int i : freq) {
            mx = Math.max(mx, i);
        }
        return mx;
    }
}
/*

TC: O(n)
SC: O(1)

*/