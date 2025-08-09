class Solution {
    public int[] asteroidCollision(int[] ast) {
        ArrayDeque <Integer> right = new ArrayDeque<>();

        for(int i = 0; i < ast.length; i++) {
            if(ast[i] > 0) {
                right.push(i);
            }
            else {
                while(!right.isEmpty()) {
                    int idx = right.peek();
                    int sideR = Math.abs(ast[idx]);
                    int sideL = Math.abs(ast[i]);

                    if(sideR < sideL) {
                        ast[idx] = 0;
                        right.poll();
                    }
                    else if(sideR > sideL) {
                        ast[i] = 0;
                        break;
                    }
                    else {
                        ast[i] = 0;
                        ast[idx] = 0;
                        right.poll();
                        break;
                    }
                }
            }
        }

        List <Integer> list = new ArrayList<>();

        for(int i = 0; i < ast.length; i++) {
            if(ast[i] != 0) {
                list.add(ast[i]);
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

/*

TC: O(n)
SC: O(n)

*/