import java.util.HashSet;
import java.util.Set;
public class ArithmeticProgression {
    public static int longestConsecutive(int[] nums,int step) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;

        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - step)){
                    current = current - step;
                    currentLongest++;
                }
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while(numsSet.remove(current + step)){
                    current = current + step;
                    currentLongest++;
                }
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
    public static int start(int[] nums){
        int longest = 0;
        int min = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]>max){
                max = nums[i];
            }else if(nums[i]<min){
                min = nums[i];
            }
        }
        for (int i=0;i<=max-min;i++){
            int currentLongest = longestConsecutive(nums,i);
            // 搜索完后更新longest.
            longest = Math.max(longest, currentLongest);
        }
        return longest;
    }
    //判断重复元素
    public static  int repeat(int[] nums){
        return 0;
    }

}
