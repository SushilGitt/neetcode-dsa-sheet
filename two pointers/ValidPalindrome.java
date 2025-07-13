class Solution {
    public boolean isPalindrome(String s) {
        char[] str = cleanStr(s).toCharArray();
        int i = 0, j = str.length-1;

        while(i < j) {
            if(str[i] != str[j]) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    private String cleanStr(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]","");
        return cleaned.toLowerCase();
    }
}
/*

TC: O(n)
SC: O(n)

*/