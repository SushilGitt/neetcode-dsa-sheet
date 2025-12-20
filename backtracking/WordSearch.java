class Solution {
    boolean ans = false;
    int[][] moves = { {0, -1},{0, 1},{-1, 0},{1, 0} };

    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == str[0]) {
                    searchWord(board, i, j, str, 0);
                }
            }
        }

        return ans;
    }

    private boolean isValid(int i, int j, char[][] board) {
        return (i >= 0 && i < board.length && j >= 0 && j < board[0].length);
    }

    private void searchWord(char[][] board, int i, int j, char[] word, int start) {
        if(start == word.length) {
            ans = true;
            return;
        }

        if(!isValid(i, j, board) || board[i][j] != word[start]) {
            return;
        }


        for(int dir = 0; dir < moves.length; dir++) {
            char c = board[i][j];
            board[i][j] = '#';
            searchWord(board, i + moves[dir][0], j + moves[dir][1], word, start + 1);
            board[i][j] = c;
        }

    }
}

// TC: O(N * M * 3^L)
// SC: O(L)