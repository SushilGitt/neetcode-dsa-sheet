class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (getSum(matchsticks) % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > getSum(matchsticks) / 4)
            return false;

        int[] sides = new int[4];
        return makesquare(0, getSum(matchsticks) / 4, sides, matchsticks);
    }

    private boolean makesquare(int index, long length, int[] sides, int[] matchsticks) {
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < sides.length; i++) {
            boolean skip = false;
            for (int j = 0; j < i; j++) {
                if (sides[j] == sides[i]) {
                    skip = true;
                    break;
                }
            }
            if (skip)
                continue;

            if (sides[i] + matchsticks[index] <= length) {
                sides[i] += matchsticks[index];
                if (makesquare(index + 1, length, sides, matchsticks))
                    return true;
                sides[i] -= matchsticks[index];
            }
        }

        return false;
    }

    private long getSum(int[] nums) {
        long sum = 0l;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}

// TC: O(4^N)
// SC: O(N)


class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (getSum(matchsticks) % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        if (matchsticks[0] > getSum(matchsticks) / 4)
            return false;

        int[] sides = new int[4];
        return makesquare(0, getSum(matchsticks) / 4, sides, matchsticks);
    }

    private boolean makesquare(int index, long length, int[] sides, int[] matchsticks) {
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < sides.length; i++) {
            boolean skip = false;
            for (int j = 0; j < i; j++) {
                if (sides[j] == sides[i]) {
                    skip = true;
                    break;
                }
            }
            if (skip)
                continue;

            if (sides[i] + matchsticks[index] <= length) {
                sides[i] += matchsticks[index];
                if (makesquare(index + 1, length, sides, matchsticks))
                    return true;
                sides[i] -= matchsticks[index];
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

    private long getSum(int[] nums) {
        long sum = 0l;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}

// TC: O(4^N)
// SC: O(N)