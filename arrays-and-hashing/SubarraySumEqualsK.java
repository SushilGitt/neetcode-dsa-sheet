class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int counter = 0;
        int n = nums.length;
        for(int a = 0; a < n; a++) {
            for(int b = a; b < n; b++) {
                int sum = 0;
                for(int c = a; c <= b; c++) {
                    sum += nums[c];
                }
                
                if(sum == k) {
                    counter++;
                }
            }
        }

        return counter;
    }
}

/*

TC: O(n^3)
SC: O(1)

*/


class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int counter = 0;
        int n = nums.length;
        for(int a = 0; a < n; a++) {
            int sum = 0;
            for(int b = a; b < n; b++) {
                sum += nums[b];
                if(sum == k) {
                    counter++;
                }
            }
        }

        return counter;
    }
}

/*

TC: O(n^2)
SC: O(1)

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0, sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(preSum.containsKey(sum - k)) {
                count += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

/*

TC: O(n)
SC: O(n)

*/