
public String longestCommonPrefix(String[] strs) {
    String prefix = strs[0];
    int len = strs[0].length();
        
    for(int i = 1; i < strs.length; i++) {
        len = Math.min(len, strs[i].length());
        while(!prefix.substring(0,len).equals(strs[i].substring(0,len))) {
            len--;
            if(len == 0) return "";
        }
        prefix = prefix.substring(0,len);
    }
    return prefix;
}

/*

--> Starts with the first string as the prefix.

--> For each string in the array, it compares prefixes character by character   (via substring and equals()), reducing the prefix length until it matches.

--> At the end, returns the common prefix among all strings.

n--> number of strings in strs
m--> length of shortest string

TC: O(n.m^2)
SC: O(m)

*/