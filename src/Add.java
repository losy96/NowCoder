public class Add {
    /**
     * 两数相加
     * 与操作可以看到哪些位出现了进位
     * 或操作是每一位都不进位的加法结果
     * 上面两行相加的结果相加就是要的结果，重复上面两行方法，如果有进位，继续循环，如果没有就跳出循环，这就是要的解法。
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1,int num2) {
        int carry = 1;
        int add = 0;
        while (carry != 0){
            add = num1^num2;
            carry = (num1&num2)<<1;
            num1 = add;
            num2 = carry;
        }
        return num1;
    }
}
