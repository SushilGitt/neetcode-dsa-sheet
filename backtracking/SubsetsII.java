class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ansSet = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        subsets(0, nums, new ArrayList<>(), ansSet);

        for(List<Integer> list : ansSet) {
            ans.add(list);
        }

        return ans;
    }

    private void subsets(int start, int[] nums,List<Integer> arr, Set<List<Integer>> ans) {
        if(start >= nums.length) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        List<Integer> arr1 = new ArrayList<>(arr);
        List<Integer> arr2 = new ArrayList<>(arr);
        arr2.add(nums[start]);

        subsets(start + 1, nums, arr1, ans);
        subsets(start + 1, nums, arr2, ans);

    }
}

// TC: O(N * 2^n)
// SC: O(N * 2^n)