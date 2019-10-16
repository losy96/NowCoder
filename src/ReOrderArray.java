public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        int end = 0;//未排序对奇数进行探寻
        for (int start=-1;start<array.length-1;start++){
            //探寻一开始连续奇数段
            if (array[start+1] % 2 == 0){
                for (end = start+1;end<array.length;end++){
                    if (array[end] %2 == 1){
                        int temp = array[end];
                        for (;end>start+1;end--){
                            //交换
                            array[end] = array[end-1];
                        }
                        array[end] = temp;
                        break;
                    }
                }
            }
        }
    }
}
