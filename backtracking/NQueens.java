class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeNQueens(0, board, ans);
        return ans;
        
    }

    private void placeNQueens(int col, char[][] board, List<List<String>> ans) {
        if(col == board.length) {
            storeAns(board, ans);
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(isValid(row, col, board)) {
                board[row][col] = 'Q';
                placeNQueens(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        int rowCopy = row - 1, colCopy = col - 1;

        // top-left side
        while(rowCopy >= 0 && colCopy >= 0) {
            if(board[rowCopy][colCopy] == 'Q') {
                return false;
            }
            rowCopy--; colCopy--;
        }

        // bottom-left side
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

    private void storeAns(char[][] board, List<List<String>> ans) {
        List<String> str = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < board.length; j++) {
                s.append(board[i][j]);
            }
            str.add(s.toString());
        }

        ans.add(str);
    }
}

// TC: O(N!)
// SC: O(N * N)