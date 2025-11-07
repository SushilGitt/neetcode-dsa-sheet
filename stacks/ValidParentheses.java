class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }

                char ch = stack.pop();

                if(ch == '(' && s.charAt(i) == ')') continue;
                else if(ch == '[' && s.charAt(i) == ']') continue;
                else if(ch == '{' && s.charAt(i) == '}') continue;
                else return false;
            }
        }

        return stack.isEmpty();
    }
}
/*

TC: O(n)
SC: O(n)

*/