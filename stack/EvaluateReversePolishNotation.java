class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque <Integer> ans = new ArrayDeque<>();
        int v1 = 0, v2 = 0;

        for(String str : tokens) {
            if(str.equals("+")) {
                v2 = ans.poll();
                v1 = ans.poll();
                ans.push(v1 + v2);
            }
            else if(str.equals("-")) {
                v2 = ans.poll();
                v1 = ans.poll();
                ans.push(v1 - v2);
            }
            else if(str.equals("*")) {
                v2 = ans.poll();
                v1 = ans.poll();
                ans.push(v1 * v2);
            }
            else if(str.equals("/")) {
                v2 = ans.poll();
                v1 = ans.poll();
                ans.push(v1 / v2);
            }
            else {
                int v = Integer.valueOf(str);
                ans.push(v);
            }
        }

        return ans.poll();
    }
}
/*

TC: O(n)
SC: O(n)

*/