class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public int subsetXORSum(int[] nums) {
        int xorSum = 0;
        List<Integer> arr = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();

        // Get all subsets
        getSubsets(0, nums.length-1, nums, arr);

        for(int i = 0; i < ans.size(); i++) {
            vals = ans.get(i);

            if(vals.size() == 0) { continue; }
            else if(vals.size() == 1) {
                xorSum += vals.get(0);
                continue;
            }

            int xor = 0;
            for(int val: vals) {
                xor ^= val;
            }

            xorSum += xor;
        }

        return xorSum;

    }

    private void getSubsets(int i, int j, int[] nums, List<Integer> arr) {
        if(i > j) {
            ans.add(arr);
            return;
        }

        ArrayList<Integer> arr1 = new ArrayList<>(arr);
        ArrayList<Integer> arr2 = new ArrayList<>(arr);

        arr2.add(nums[i]);

        getSubsets(i+1, j, nums, arr1);
        getSubsets(i+1, j, nums, arr2);

        return;
    }
}

// TC: O(N.2^n)
// SC: O(N.2^n)