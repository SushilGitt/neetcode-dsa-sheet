class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        combinationSum(0, 0, target, candidates, arr, ans);
        return ans;
    }

    private void combinationSum(int start, int sum, int target, int[] nums, List<Integer> arr, List<List<Integer>> ans) {
        if(sum == target) {
            List<Integer> copy = new ArrayList<>(arr);
            ans.add(copy);
            return;
        }
        else if(start >= nums.length || sum > target) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(sum + nums[i] <= target) {
                arr.add(nums[i]);
                combinationSum(i, sum + nums[i], target, nums, arr, ans);
                arr.remove(arr.size()-1);
            }
        }

        return;
    }
}