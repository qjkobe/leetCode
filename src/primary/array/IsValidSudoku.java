package primary.array;

public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        //根据规则
        for(int i = 0; i < board.length; i++) {
            //行列判定
            int[] rows = new int[10];
            int[] cols = new int[10];
            int[] cube = new int[10];
            for(int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && rows[board[i][j]-'0']==0) {
                    rows[board[i][j]-'0']++;
                }else if(board[i][j] != '.' && rows[board[i][j]-'0']!=0){
                    return false;
                }
                if (board[j][i] != '.' && cols[board[j][i]-'0']==0) {
                    cols[board[j][i]-'0']++;
                }else if(board[j][i] != '.' && cols[board[j][i]-'0']!=0){
                    return false;
                }

                //33 方块判定。
                //每个内循环要完成九个方块的判定。用j控制移动，i控制基准点
                int RowIndex = 3 * (i / 3);//0 1 2 * 3
                int ColIndex = 3 * (i % 3);//
                if (board[j / 3 + RowIndex][ColIndex + j % 3] != '.') {
                    cube[board[j / 3 + RowIndex][ColIndex + j % 3]-'0']++;
                    if (cube[board[j / 3 + RowIndex][ColIndex + j % 3]-'0'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
