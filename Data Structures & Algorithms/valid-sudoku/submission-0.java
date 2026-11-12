class Solution {
    public boolean isValidSudoku(char[][] board) {
        // create a map of integer key and Hashset for rows, cols and squareKey
        // sqky is 3x3 box in sudoku where no duplicates allowed
        int len = board[0].length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        // matrix iterations for loop through rows and cols
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // nothing to do if the char is not filled / '.' in the matrix
                if (board[r][c] == '.') {
                    continue;
                }

                // calc sq key
                String squareKey = r / 3 + "," + c / 3; // [1,1]
                // computeIfAbsent if absent create entry with new set, else if present - check if
                // key present
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<>())
                        .contains(board[r][c])) {
                    return false;
                }
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}
