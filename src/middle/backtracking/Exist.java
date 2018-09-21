package middle.backtracking;
//单词搜索
public class Exist {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Exist a = new Exist();
        System.out.println(a.exist(board, "ABCCED"));
        System.out.println(a.exist(board, "SEE"));
        System.out.println(a.exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        //找首字母，然后向周围进发，不行就回溯到之前最后一个正确的字母。
        for(int i = 0; i<board.length;i++) {
            for(int j = 0;j< board[0].length;j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (y<0 || x<0 || x == board.length || y == board[0].length) return false;
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        //表示用过这个
        board[x][y] ^= 10;
        boolean res = backtrack(board, x + 1, y, word, index + 1)
        || backtrack(board, x - 1, y, word, index + 1)
        || backtrack(board, x, y+1, word, index + 1)
        ||backtrack(board, x, y-1, word, index + 1);
        board[x][y] ^= 10;
        return res;
    }
}
