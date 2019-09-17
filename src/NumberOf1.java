public class NumberOf1 {
    public static int NumberOf1(int n) {
        int flag = 1;
        int count=0;
        while (flag!=0){
            if ((n&flag) != 0){
                count++;
            }
            flag = flag<<1;
        }
        System.out.println(count);
        return count;
    }
    /**
     * 最优
     * 链接：https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8?f=discussion
     * 来源：牛客网
     *
     * public static int NumberOf1(int n) {
     *         int count = 0;
     *         while (n != 0) {
     *             ++count;
     *             n = (n - 1) & n;//将最右边的1变成0;
     *         }
     *         return count;
     *     }
     */
}
