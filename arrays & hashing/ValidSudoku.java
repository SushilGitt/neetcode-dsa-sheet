class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBox(board, i, i+2, j, j+2)) return false;
            }
        }

        return isValidRows(board) && isValidCols(board);
        
    }

    private boolean isValidCols(char[][] board) {

        for(int i = 0; i < 9; i++) {
            int[] nums = new int[10];

            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') { continue; }
                int num = board[j][i] - '0';
                if(nums[num] != 0) {
                    return false;
                }
                nums[num]++;
            }
        }

        return true;
    }

    private boolean isValidRows(char[][] board) {

        for(int i = 0; i < 9; i++) {
            int[] nums = new int[10];

            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') { continue; }
                int num = board[i][j] - '0';
                if(nums[num] != 0) {
                    return false;
                }
                nums[num]++;
            }
        }

        return true;
    }

    private boolean isValidBox(char[][] board, int r1, int r2, int c1, int c2) {

        int[] nums = new int[10];

        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
                if(board[i][j] == '.') { continue; }
                int num = board[i][j] - '0';
                if(nums[num] != 0) {
                    return false;
                }
                nums[num]++;
            }
        }

        return true;
    }
}

/*

TC: O(1)
SC: O(1)

*/