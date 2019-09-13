public class Fibonacci {
    public static int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        int[] pre_2_num = {1,1};
        if (n == 1||n == 2){
            return 1;
        }else {
            for (int i = 3;i<=n;i++){
                int temp = pre_2_num[0]+pre_2_num[1];
                pre_2_num[0] = pre_2_num[1];
                pre_2_num[1] = temp;
            }
            return pre_2_num[1];
        }
    }
}
