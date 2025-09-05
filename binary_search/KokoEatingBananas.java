class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int speed = 1;
        int max = Integer.MAX_VALUE;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            int time = getTime(piles, mid);

            if(time > h) {
                min = mid + 1;
            }
            else {
                speed = mid;
                max = mid - 1;
            }
        }

        return speed;
    }

    private int getTime(int[] arr, int speed) {
        int time = 0;
        for(int i : arr) {
            time += i / speed;
            if(i % speed != 0) time++;
        }
        return time;
    }
}

// TC: O(log(m) * n)
// SC: O(1)