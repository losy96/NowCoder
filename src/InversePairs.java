public class InversePairs {
    /**
     * TODO 未通过编译，但是结果与提供答案一致，应该不是逻辑问题  可能是空间 或者效率问题
     * 归并排序进行统计
     * 将数组分割成子数组
     * 7 4 5 3   （1）
     * 7 4    5 3  （2）
     * 7  4       5  3  （3）
     * 从下到上统计子数组内部的逆序个数
     * （3） 7 4 恢复排序  统计处一对  5 3 一对
     * （2） 4 7    3 5 进行统计
     * 以上
     * @param array
     * @return
     */
    int num = 0;
    public int InversePairs(int [] array) {
        if (array.length>1){
            //继续分割
            int [] new_left_array;
            int [] new_right_array;
            if (array.length % 2 == 0){
                int length = array.length/2;
                new_left_array = new int[length];
                new_right_array = new int[length];
                int index = 0;
                for (int i :array){
                    if (index < new_left_array.length){
                        new_left_array[index] = i;
                        index ++;
                    }else {
                        new_right_array[index - new_left_array.length] = i;
                        index ++;
                    }
                }
            }else {
                int length = array.length/2;
                new_left_array = new int[length];
                new_right_array = new int[length + 1];
                int index = 0;
                for (int i :array){
                    if (index < new_left_array.length){
                        new_left_array[index] = i;
                        index ++;
                    }else {
                        new_right_array[index - new_left_array.length] = i;
                        index ++;
                    }
                }
            }
            count(new_left_array,new_right_array);
        }else {
            return 0;
        }
        return num%1000000007;
    }
    public int[] count(int [] left_array, int [] right_array){

        if (left_array.length > 1){
            //继续分割
            int [] new_left_array;
            int [] new_right_array;
            if (left_array.length % 2 == 0){
                int length = left_array.length/2;
                new_left_array = new int[length];
                new_right_array = new int[length];
                int index = 0;
                for (int i :left_array){
                    if (index < new_left_array.length){
                        new_left_array[index] = i;
                        index++;
                    }else {
                        new_right_array[index - new_left_array.length] = i;
                        index++;
                    }
                }

            }else {
                int length = left_array.length/2;
                new_left_array = new int[length];
                new_right_array = new int[length + 1];
                int index = 0;
                for (int i :left_array){
                    if (index < new_left_array.length){
                        new_left_array[index] = i;
                        index++;
                    }else {
                        new_right_array[index - new_left_array.length] = i;
                        index++;
                    }
                }

            }
            left_array = count(new_left_array,new_right_array);
        }
        if (right_array.length > 1){
            //继续分割
            //继续分割
            int [] new_left_array;
            int [] new_right_array;
            if (right_array.length % 2 == 0){
                int length = right_array.length/2;
                new_left_array = new int[length];
                new_right_array = new int[length];
                int index = 0;
                for (int i :right_array){
                    if (index < new_left_array.length){
                        new_left_array[index] = i;
                        index++;
                    }else {
                        new_right_array[index - new_left_array.length] = i;
                        index++;
                    }
                }

            }else {
                int length = right_array.length/2;
                new_left_array = new int[length];
                new_right_array = new int[length + 1];
                int index = 0;
                for (int i :right_array){
                    if (index < new_left_array.length){
                        new_left_array[index] = i;
                        index++;
                    }else {
                        new_right_array[index - new_left_array.length] = i;
                        index++;
                    }
                }

            }
            right_array = count(new_left_array,new_right_array);
        }
        //上面会返回排序好的子数组回来
        //对左右数组进行合并  并且计算数据
        int [] array = new int[left_array.length + right_array.length];
        int j = 0;
        for (int i=0;i<left_array.length;i++){
            if (j >= right_array.length || left_array[i] < right_array[j] ){ //短路  j超出索引 如果放在前面就会出现index out of range
                array[i + j] = left_array[i];
            }else {
                array[i + j] = right_array[j];
                num = num + left_array.length - i;
                i  = i - 1;
                j++;
            }
        }
        if (j<right_array.length){
            for (;j<right_array.length;j++){
                array[left_array.length + j] = right_array[j];
            }
        }
        return array;
    }

}
