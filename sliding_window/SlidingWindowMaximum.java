/*

Brute force:
--> Find maximum of each window of size k.
--> Repeat this for n - k + 1 windows.

TC: O(k.(n-k))
SC: O(k)

*/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        int left = 0; 
        int right = k - 1;
        for(int i = 0; i < ans.length; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = left; j <= right; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
            left++; right++;
        }

        return ans;
    }
}

// -------------------------------------------------------------------------------

/*

--> Using Deque we can reduce TC to O(n)

TC: O(n)
SC: O(k)

*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        
        for(int j = 0; j < n; j++) {
            if(!deque.isEmpty() && deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[j]) {
                deque.pollLast();
            }
            
            deque.addLast(j);
            if(j < k - 1) continue;

            ans[i++] = nums[deque.peekFirst()];
            
        }

        return ans;
    }
}