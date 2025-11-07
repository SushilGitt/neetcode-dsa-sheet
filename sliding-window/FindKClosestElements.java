class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        List<Integer> ans = new ArrayList<>();

        while(right - left >= k) {
            if(getAbs(arr[left], x) < getAbs(arr[right], x)) {
                right--;
            }
            else if(getAbs(arr[left], x) > getAbs(arr[right], x)) {
                left++;
            }
            else {
                if(arr[left] < arr[right]) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        for(int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    private int getAbs(int a, int b) {
        return Math.abs(a - b);
    }
}
/*

TC: O(n)
SC: O(k) -- Inorder to return list.

*/