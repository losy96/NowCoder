public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        /**
         * 将数字分割成高位与低位
         * 1234  计算百位1出现次数，分成12高位  34低位，按情况讨论计算如下算法，当百位=0，=1，>=2的不同情况进行计算
         */
        for (int i=1;i<=n;i=i*10){
            int highPlace = n/i;
            int lowPlace = n - highPlace*i;
            if (highPlace%10 == 1){
                count = count + (highPlace/10) * i + lowPlace+1;
            }else if (highPlace%10 == 0){
                count = count + (highPlace/10) * i;
            }else {
                count = count + ((highPlace/10)+1) * i;
            }
        }
        return count;
    }
}
