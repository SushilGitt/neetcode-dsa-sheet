class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length == 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] leftHalf = Arrays.copyOfRange(nums, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(nums, mid, nums.length);
        
        leftHalf = sortArray(leftHalf);
        rightHalf = sortArray(rightHalf);
        
        return merge(leftHalf, rightHalf);
    }

    public int[] merge(int[] left, int[] right) {
        int[] mergedArr = new int[left.length + right.length];
        
        int leftPtr = 0, rightPtr = 0, mergedPtr = 0;
        
        while(leftPtr < left.length && rightPtr < right.length) {
            if(left[leftPtr] <= right[rightPtr]) {
                mergedArr[mergedPtr] = left[leftPtr];
                leftPtr++;
            }
            else {
                mergedArr[mergedPtr] = right[rightPtr];
                rightPtr++;
            }
            mergedPtr++;
        }
        
        while(leftPtr < left.length) {
            mergedArr[mergedPtr] = left[leftPtr];
            leftPtr++;
            mergedPtr++;
        }
        
        while(rightPtr < right.length) {
            mergedArr[mergedPtr] = right[rightPtr];
            rightPtr++;
            mergedPtr++;
        }
        
        return mergedArr;
        
    }
}

/*

TC: O(n.log.n)
SC: O(n)

*/