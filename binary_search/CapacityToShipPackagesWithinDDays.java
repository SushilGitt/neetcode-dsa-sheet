class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] arr = getMinMax(weights);
        int min = arr[0],
            max = arr[1],
            ship = max;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            int takenDays = getDays(weights, mid);

            if(takenDays > days) {
                min = mid + 1;
            }
            else {
                ship = mid;
                max = mid - 1;
            }
        }

        return ship;
    }

    private int getDays(int[] weights, int cap) {
        int weight = 0,
            days = 1;
        
        for(int i : weights) {
            weight += i;
            if(weight > cap) {
                days++;
                weight = i;
            }
        }

        return days;
    }

    private int[] getMinMax(int[] weights) {
        int min = 0,
            max = 0;
        for(int i : weights) {
            if(i > min) { min = i; }
            max += i;
        }
        return new int[] {min, max};
    }
}

// TC: O(n * log(s-m))
// SC: O(1)