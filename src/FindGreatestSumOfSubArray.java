public class FindGreatestSumOfSubArray {
    /**
     * 动态规划
     * 若前面加起来>0  表示前面对后面有贡献继续加，若<0则表示没有贡献，此处断开，从断开处开始累加。
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0){
            return 0;
        }else {
            int max = array[0];
            int total = array[0];
            for (int i = 1;i < array.length;i++){
                total = total + array[i];
                if (total > 0){
                    if (total > max){
                        max = total;
                    }
                }else {
                    if (total > max){
                        max = total;
                    }
                    total = 0;
                }
            }
            return max;
        }
    }
}
