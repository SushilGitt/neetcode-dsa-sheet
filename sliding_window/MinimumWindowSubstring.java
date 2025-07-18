/*

Brute force:

--> Generate all substring and check if this substring conatains all the characters in t.

--> Find substring minimum length of substring that satisfy above condition.

TC: O(n^3) --> three nested loops 
SC: O(1) --? We are only generating substrings not storing.


*/




class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }

        int minS = 0;
        int minE = 0;
        int flg = 0;
        int left = 0;
        int right = 0;
        int minL = Integer.MAX_VALUE;
        int[] charArr = new int[128];

        for(int i = 0; i < t.length(); i++) {
            charArr[t.charAt(i)]++;
        }

        while(right < s.length()) {
            charArr[s.charAt(right++)]--;

            while(isValidStr(charArr)) {
                if(right - left + 1 <= minL) {
                    minS = left;
                    minE = right;
                    minL = right - left;
                    flg = 1;
                }
                charArr[s.charAt(left)]++;
                left++;
            }
        }

        return (flg == 0) ? "" : s.substring(minS, minE);
    }

    private boolean isValidStr(int[] arr) {
        for(int i:arr) {
            if(i > 0) {
                return false;
            }
        } 
        return true;
    }
}
/*

TC: O(m + n)
SC: O(1)

*/