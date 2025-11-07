class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        HashMap <Integer, Integer> pair = new HashMap<>();

        for(int i = 0; i < pos.length; i++) {
            pair.put(pos[i], speed[i]);
        }

        Arrays.sort(pos);
        ArrayDeque <Double> s = new ArrayDeque<>();

        for(int i = pos.length - 1; i >= 0; i--) {
            double time = (double)(target - pos[i]) / pair.get(pos[i]);

            if(s.isEmpty()) {
                s.push(time);
            }
            else if(time > s.peek()) {
                s.push(time);
            }
        }

        return s.size();
    }
}

/*

TC: O(n log n)
SC: O(n)

*/