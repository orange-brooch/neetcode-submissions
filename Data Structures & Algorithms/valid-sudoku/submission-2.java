class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows 0-9 no repeate; same cols
        //  3x3 - row or col moob 3 gives the  square address  - 0x0, 1x1,2x2 etc
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> sqboard = new HashMap<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                String sqKey = (r / 3) + "," + (c / 3);

                if (
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])||
                    sqboard.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[r][c])
                ) { 
                    return false;
                }
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                sqboard.get(sqKey).add(board[r][c]);
            }
        }
        return true;
    }
}
