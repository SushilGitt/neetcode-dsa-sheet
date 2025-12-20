class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        getSubsets(0, nums.length - 1, nums, arr);

        return ans;
    }

    private void getSubsets(int i, int j, int[] nums, ArrayList<Integer> arr) {
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