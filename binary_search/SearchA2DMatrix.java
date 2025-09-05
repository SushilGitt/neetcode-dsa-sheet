class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int sPtr = 0, ePtr = m, r = 0;

        while(sPtr <= ePtr) {
            int mPtr = sPtr + (ePtr - sPtr) / 2;

            if(matrix[mPtr][0] < target) { 
                r = mPtr;
                sPtr = mPtr + 1; 
            }
            else if(matrix[mPtr][0] > target) {
                ePtr = mPtr - 1;
            }
            else {
                return true;
            }
        }

        sPtr = 0; ePtr = n;

        while(sPtr <= ePtr) {
            int mPtr = sPtr + (ePtr - sPtr) / 2;

            if(matrix[r][mPtr] < target) {
                sPtr = mPtr + 1;
            }
            else if(matrix[r][mPtr] > target) {
                ePtr = mPtr - 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}

// TC: O(log(m * n))
// SC: O(1)