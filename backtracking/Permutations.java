class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int num : nums) {
            arr.add(num);
        }

        permute(0, arr, ans);
        return ans;
    }

    private void permute(int start, List<Integer> nums, List<List<Integer>> ans) {
        if(start >= nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        for(int i = start; i < nums.size(); i++) {
            swap(start, i, nums);
            permute(start + 1, nums, ans);
            swap(start, i, nums);
        }

        return;
    }

    private void swap(int i, int j, List<Integer> nums) {
        int copy = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, copy);

        return;
    }
}

// TC: O(N * N!)
// SC: O(N * N!)