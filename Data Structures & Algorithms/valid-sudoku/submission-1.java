class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> columnSet = new HashSet<>();
        HashSet<Character> squareSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            columnSet.clear();
            squareSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columnSet.add(board[j][i])) {
                    return false;
                }
                int rowStart = 3 * (i/3);
                int colStart = 3 * (i%3);
                char cell = board[rowStart + j/3][colStart + j%3];
                if (cell != '.' && !squareSet.add(cell)) {
                    return false;
                }
            }
        }

        return true;
    }
}
