class Solution {
    public boolean validPalindrome(String s) {
        if(isPalindrome(s)) {
            return true;
        }

        int i = 0, j = s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                String str1 = removeChar(s, i);
                String str2 = removeChar(s, j);
                if(isPalindrome(str1) || isPalindrome(str2)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            i++; j--;
        }
        
        return true;
    }

    private String removeChar(String s, int idx) {
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(idx);
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
/*

TC: O(n)
SC: O(n)

*/