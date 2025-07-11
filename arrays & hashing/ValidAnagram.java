/*

Brute force: Sorting

--> Sort strings by chars
--> Compare them

--> TC: O(n log n)
--> SC: O(n)

*/
public boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        if(str1.length != str2.length) {
            return false;
        }

        for(int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }

        return true;
    }
// -----------------------------------------------------------------------------

/*
Optimal:

--> Use HashMap for counting chars in strings
--> Since here a-z chars use constant size array.

--> TC: O(n) -- length of string
--> SC: O(1) -- constant size of array 26.

*/

public boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        int[] charStr1 = new int[26];
        int[] charStr2 = new int[26];

        for(int i = 0; i < str1.length; i++) {
            charStr1['z'-str1[i]]++;
        }

        for(int i = 0; i < str2.length; i++) {
            charStr2['z'-str2[i]]++;
        }
        
        for (int i = 0; i < charStr1.length; i++) {
            if(charStr1[i] != charStr2[i]) {
                return false;
            }
        }
        
        return true;
    }