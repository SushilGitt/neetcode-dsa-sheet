class Solution {
    public String mergeAlternately(String s1, String s2) {
        String str = "";
        int i = 0, j = 0;

        while(i < s1.length() && j < s2.length()) {
            str = str + s1.charAt(i) + s2.charAt(j);
            i++; j++;
        }

        while(i < s1.length()) {
            str += s1.charAt(i);
            i++;
        }

        while(j < s2.length()) {
            str += s2.charAt(j);
            j++;
        }

        return str;
    }
}
/*

TC: O((m+n)^2)
SC: O(m+n)

*/