class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = getSum(nums);
        if(sum % k != 0) return false;

        Arrays.sort(nums);
        reverse(nums);

        if(nums[0] > sum / k) return false;
        int[] sets = new int[k];

        return isTrue(0, sum / k, nums, sets);
    }

    private boolean isTrue(int index, int sum, int[] nums, int[] sets) {
        if(index == nums.length) {
            return true;
        }

        for(int i = 0; i < sets.length; i++) {
            if(sets[i] + nums[index] <= sum) {
                sets[i] += nums[index];
                if(isTrue(index + 1, sum, nums, sets)) return true;
                sets[i] -= nums[index];
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length-1;
        while(i < j) {
            int copy = nums[i];
            nums[i] = nums[j];
            nums[j] = copy;
            i++; j--;
        }
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
    
}

// TC: O(K^N)
// SC: O(N)



class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = getSum(nums);
        if(sum % k != 0) return false;

        Arrays.sort(nums);
        reverse(nums);

        if(nums[0] > sum / k) return false;
        int[] sets = new int[k];

        return isTrue(0, sum / k, nums, sets);
    }

    private boolean isTrue(int index, int sum, int[] nums, int[] sets) {
        if(index == nums.length) {
            return true;
        }

        for(int i = 0; i < sets.length; i++) {

            boolean skip = false;
            for (int j = 0; j < i; j++) {
                if (sets[j] == sets[i]) {
                    skip = true;
                    break;
                }
            }
            if (skip) continue;

            if(sets[i] + nums[index] <= sum) {
                sets[i] += nums[index];
                if(isTrue(index + 1, sum, nums, sets)) return true;
                sets[i] -= nums[index];
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length-1;
        while(i < j) {
            int copy = nums[i];
            nums[i] = nums[j];
            nums[j] = copy;
            i++; j--;
        }
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
    
}

// TC: O(K^N)
// SC: O(N)