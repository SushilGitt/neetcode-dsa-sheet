class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();

        for(int num : nums) {
            arr.add(num);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> permutes = new HashSet<>();

        permute(0, arr, permutes);

        for(List<Integer> list : permutes) {
            ans.add(list);
        }

        return ans;
    }

    private void permute(int start, List<Integer> nums, Set<List<Integer>> ans) {
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


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> numsSet = new HashSet<>();

        for(int i = start; i < nums.size(); i++) {
            if(!numsSet.contains(nums.get(i))) {
                numsSet.add(nums.get(i));
                swap(start, i, nums);
                permute(start + 1, nums, ans);
                swap(start, i, nums);
            }
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
// SC: O(N * N!) + O(N * N) for hashset.