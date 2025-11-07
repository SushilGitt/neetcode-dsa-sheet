class Solution {
    public int[] dailyTemperatures(int[] temp) {
        ArrayDeque <Integer> nextDay = new ArrayDeque<>();
        int[] ans = new int[temp.length];

        for(int i = temp.length - 1; i >= 0; i--) {
            if(!nextDay.isEmpty()) {
                if(temp[nextDay.peek()] > temp[i]) {
                    ans[i] = nextDay.peek() - i;
                }
                else {
                    while(!nextDay.isEmpty() && temp[nextDay.peek()] <= temp[i]) {
                        nextDay.poll();
                    }

                    if(!nextDay.isEmpty()) {
                        ans[i] = nextDay.peek() - i;
                    }
                }
            }
            nextDay.push(i);
        }

        return ans;
    }
}

/*

TC: O(n)
SC: O(n)

*/