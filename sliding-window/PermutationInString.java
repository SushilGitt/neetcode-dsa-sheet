class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        if(length1 > length2) {
            return false;
        }

        for(int i = 0; i < length1; i++) {
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freqS1, freqS2)) {
            return true;
        }

        int left = 0;
        int right = length1 - 1;
        while(right < length2 - 1) {
            right++;
            freqS2[s2.charAt(right) - 'a']++;

            freqS2[s2.charAt(left) - 'a']--;
            left++;

            if(Arrays.equals(freqS1, freqS2)) {
                return true;
            }
        }

        return false;
    }
}
/*

TC: O(n)
SC: O(1)

*/