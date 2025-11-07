class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> ans = new ArrayList<>();
        return getParenthesis(ans, "", 0, 0, n);
    }

    private List<String> getParenthesis(List<String> parenthesis,String s, int open, int close, int n) {
        if(open == n && close == n) {
            parenthesis.add(s);
            return parenthesis;
        }
        if(open < n) {
            getParenthesis(parenthesis, s+"(", open+1, close, n);
        }
        if(close < open) {
            getParenthesis(parenthesis, s+")", open, close+1, n);
        }

        return parenthesis;
    }
}