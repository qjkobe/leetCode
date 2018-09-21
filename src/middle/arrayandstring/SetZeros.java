package middle.arrayandstring;

//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
public class SetZeros {

    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        //如果有0，就把那一行或那一列列的第0位置为0。因为第一个元素重叠了，所以多设置一个变量。
        int col0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0) col0 = 0;
            for(int j = 1; j<cols;j++) {
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //遍历再处理，根据第一个元素的结果。
        //注意要倒序，不然会先把周边置为0，就全成0了
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j]=0;
                }
            }
            if(col0==0)
                matrix[i][0]=0;

        }
    }

}
