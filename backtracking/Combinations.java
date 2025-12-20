
// Recursive approach
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }

        combine(0, k, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void combine(int i, int len, int[] nums, List<Integer> arr, List<List<Integer>> ans) {
        if(len == arr.size()) {
            ans.add(arr);
            return;
        }
        else if(i >= nums.length) {
            return;
        }

        List<Integer> arr1 = new ArrayList<>(arr);
        List<Integer> arr2 = new ArrayList<>(arr);
        arr2.add(nums[i]);

        combine(i + 1, len, nums, arr1, ans);
        combine(i + 1, len, nums, arr2, ans);

        return;
    }
}


// Backtracking approach

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }

        combine(0, k, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void combine(int start, int len, int[] nums, List<Integer> arr, List<List<Integer>> ans) {
        if(arr.size() == len) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        else if(start >= nums.length) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            arr.add(nums[i]);
            combine(i + 1, len, nums, arr, ans);
            arr.remove(arr.size()-1);
        }

        return;
    }
}