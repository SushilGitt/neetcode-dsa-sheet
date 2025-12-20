class Solution {
    int ans = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeNQueens(0, board);
        return ans;
    }

    private void placeNQueens(int col, char[][] board) {
        if(col == board.length) {
            ans++;
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(isValid(row, col, board)) {
                board[row][col] = 'Q';
                placeNQueens(col + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        int rowCopy = row - 1, colCopy = col - 1;

        while(rowCopy >= 0 && colCopy >= 0) {
            if(board[rowCopy][colCopy] == 'Q') {
                return false;
            }
            rowCopy--; colCopy--;
        }

        colCopy = col - 1;
        rowCopy = row + 1; 
        while(rowCopy < board.length && colCopy >= 0) {
            if(board[rowCopy][colCopy] == 'Q') {
                return false;
            }
            rowCopy++; colCopy--;
        }

        colCopy = col - 1;
        while(colCopy >= 0) {
            if(board[row][colCopy] == 'Q') {
                return false;
            }
            colCopy--;
        }

        return true;

    }

}

// TC: O(N!)
// SC: O(N * N)