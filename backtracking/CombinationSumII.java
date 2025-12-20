class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        Set<List<Integer>> combo = new HashSet<>();

        Arrays.sort(candidates);
        combinationSum(0, 0, target, candidates, arr, combo);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> list : combo) {
            ans.add(list);
        }
        
        return ans;
    }

    private void combinationSum(int start, int sum, int target, int[] nums, List<Integer> arr, Set<List<Integer>> combo) {
        if(sum == target) {
            List<Integer> copy = new ArrayList<>(arr);
            combo.add(copy);
            return;
        }
        else if(start >= nums.length || sum > target) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;

            arr.add(nums[i]);
            combinationSum(i + 1, sum + nums[i], target, nums, arr, combo);
            arr.remove(arr.size()-1);
            
        }

        return;
    }
}