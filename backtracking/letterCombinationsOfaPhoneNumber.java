class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterCombinations(0, digits, str, ans, map);
        return ans;
    }

    private void letterCombinations(int index, String digits, StringBuilder str, List<String> ans, Map<Character, String> map) {
        if(index == digits.length()) {
            ans.add(str.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = map.get(c);

        for(int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            letterCombinations(index + 1, digits, str, ans, map);
            str.deleteCharAt(str.length()-1);
        }
    }
}

// TC: O(N * 4^N)
// SC: O(N * 4^N)