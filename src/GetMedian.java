import java.util.ArrayList;

public class GetMedian {
    /**
     * 每次进行有序插入
     * @param num
     */
    ArrayList<Integer> nums = new ArrayList<>();
    public void Insert(Integer num) {
        if (nums.size() == 0){
            nums.add(num);
        }else {
            nums.add(num);
            for (int i=nums.size()-2;i>=0;i--){
                if (nums.get(i+1) < nums.get(i)){
                    //交换
                    Integer temp = nums.get(i);
                    nums.set(i,nums.get(i+1));
                    nums.set(i+1,temp);
                }else {
                    break;
                }
            }
        }
    }

    public Double GetMedian() {
        if (nums.size() == 0){
            return 0.0;
        }
        if (nums.size()%2 == 1){
            return (double)nums.get((nums.size()-1)/2);
        }else {
            return (nums.get(nums.size()/2-1)+nums.get(nums.size()/2))*1.0/2;
        }
    }
}
