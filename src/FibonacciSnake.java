public class FibonacciSnake {
    public static int[] fibonacci(int n){
        int [] fibonacciList = new int[n];
        if (n == 1){
            fibonacciList[0] = 1;
        }else if (n == 2){
            fibonacciList[0] = 1;
            fibonacciList[1] = 1;
        }else {
            fibonacciList[0] = 1;
            fibonacciList[1] = 1;
            for (int i = 2;i<n;i++){
                fibonacciList[i] = fibonacciList[i-1]+fibonacciList[i-2];
            }
        }
        return fibonacciList;
    }

    public static void printFibonacciSnake(int n){
        int[] fibonacciList = fibonacci(n*n);
        int[][] matrix = new int[n][n];
        fillInt(matrix,fibonacciList,n*n -1,0);
        for (int i = 0;i < matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * n 为fill数据的长度
     * @param matrix
     * @param n
     */
    public static void fillInt(int[][] matrix,int[] fibonacciList,int index,int n){
        int step = matrix.length - 2*n;//步长
        if (step < 1){
            return;
        }
        //1
        for (int j=n;j<matrix.length - n;j++){
            matrix[n][j] = fibonacciList[index];
            index--;
        }
        //2
        for (int i=n+1;i<matrix.length - n;i++){
            matrix[i][matrix.length - n - 1] = fibonacciList[index];
            index--;
        }
        //3
        for (int j = matrix.length - n - 2;j>=n;j--){
            matrix[matrix.length - n - 1][j] = fibonacciList[index];
            index--;
        }
        //4
        for (int i=matrix.length - n - 2;i>n;i--){
            matrix[i][n] = fibonacciList[index];
            index--;
        }
        n++;
        fillInt(matrix,fibonacciList,index,n);
    }

    public static void main(String[] args) {
        printFibonacciSnake(5);
    }
}
