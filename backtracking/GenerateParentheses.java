class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getParenthesis(n, n, "", ans);

        return ans;
    }

    private void getParenthesis(int open, int close, String str, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(str);
            return;
        }

        if(open > 0) {
            getParenthesis(open - 1, close, str + "(", ans);
        }
        if(open < close) {
            getParenthesis(open, close - 1, str + ")", ans);
        }

    }
}




class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        getParenthesis(n, n, str, ans);

        return ans;
    }

    private void getParenthesis(int open, int close, StringBuilder str, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(str.toString());
            return;
        }

        if(open > 0) {
            str.append("(");
            getParenthesis(open - 1, close, str, ans);
            str.deleteCharAt(str.length()-1);
        }
        if(open < close) {
            str.append(")");
            getParenthesis(open, close - 1, str, ans);
            str.deleteCharAt(str.length()-1);
        }

    }
}