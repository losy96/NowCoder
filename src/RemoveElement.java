import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class RemoveElement {
    static public int removeElement(int[] nums,int val){
        int num = 0;
        for (int i = 0;i<nums.length-num;i++){
            System.out.print(i);
            if (nums[i] == val){
                for (int j = i;j<nums.length-num-1;j++){
                    nums[j] = nums[j+1];
                }
                i--;
                num++;
            }
        }
//        for (int i = 0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }

        return 0;
    }
}
