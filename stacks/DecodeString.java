class Solution {
    public String decodeString(String s) {
        ArrayDeque <Character> ss = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c != ']') {
                ss.push(c);
            }
            else {
                String str = "";
                while(ss.peek() != '[') {
                    str = ss.poll() + str;
                }
                ss.poll();

                String k = "";
                while(!ss.isEmpty() && Character.isDigit(ss.peek())) {
                    k = ss.poll() + k;
                }

                int val = Integer.valueOf(k);
                String ans = str.repeat(val);

                for(char ch : ans.toCharArray()) {
                    ss.push(ch);
                }
            }
        }

        String res = "";
        while(!ss.isEmpty()) {
            res = ss.poll() + res;
        }

        return res;
    }
}

/*

TC: O(n + m²) (due to repeated concatenation).
SC: O(n + m)

*/