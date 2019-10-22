public class Multiply {
    /**
     * 创建一个矩阵，将计算中间结果存储
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        if (A.length == 0){
            return null;
        }
        if (A.length == 1){
            int[] B = {0};
            return B;
        }
        int[][] matrix = new int[A.length][A.length];
        matrix[1][0] = A[0];
        matrix[A.length-2][A.length-1] = A[A.length-1];
        for (int i=1;i<A.length-1;i++){
            int j = A.length-1-i;
            matrix[i+1][i] = A[i] * matrix[i][i-1];
            matrix[j-1][j] = A[j] * matrix[j][j+1];
        }
        for (int i=0;i<A.length;i++){
            for (int j = 0;j<A.length;j++){
                System.out.print("\t");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        int[] B = new int[A.length];
        B[0] = matrix[0][1];
        B[A.length-1] = matrix[A.length-1][A.length-2];
        for (int i=1;i<A.length-1;i++){
            B[i] = matrix[i][i-1]*matrix[i][i+1];
        }
        return B;
    }
}
