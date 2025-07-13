class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int a = 0; a < n; a++) {
            if(a > 0 && nums[a] == nums[a-1]) {
                continue;
            }

            for(int b = a + 1; b < n;) {
                int c = b + 1;
                int d = n - 1;

                while(c < d) {
                    long total = (long)nums[a] + nums[b] + nums[c] + nums[d];
                    if(total < target) {
                        c++;
                    }
                    else if(total > target) {
                        d--;
                    }
                    else {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        while(c < n && nums[c] == nums[c-1]) {
                            c++;
                        }
                        while(d > 0 && nums[d] == nums[d+1]) {
                            d--;
                        }
                    }
                }

                b++;
                while(b < n && nums[b] == nums[b-1]) {
                    b++;
                }

            }
        }
        return ans;
    }
}
/*

TC: O(n³)
SC: O(n³) (output), O(1) (auxiliary)

*/