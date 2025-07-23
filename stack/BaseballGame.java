class Solution {
    public int calPoints(String[] ops) {
        Stack <Integer> stack = new Stack<>();

        for(String s : ops) {
            if(!s.equals("C") && !s.equals("D") && !s.equals("+")) {
                int v = Integer.valueOf(s);
                stack.push(v);
            }
            else if(s.equals("C")) {
                stack.pop();
            }
            else if(s.equals("D")) {
                int v = stack.peek() * 2;
                stack.push(v);
            }
            else {
                int v2 = stack.pop();
                int v1 = stack.pop();
                int v3 = v1 + v2;
                stack.push(v1);
                stack.push(v2);
                stack.push(v3); 
            }
        }
            

        int sum = 0;
        for(int i : stack) {
            sum += i;
        }

        return sum;
    }
}
/*

TC: O(n)
SC: O(n)

*/