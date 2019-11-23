
public class MinNumberInRotateArray {
    /**
     * 若首尾相等，直接遍历
     * 若首尾不相等，二分查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        return _minNumberInRotateArray(array,0,array.length-1);
    }
    public int _minNumberInRotateArray(int[] array,int left,int right){
        if (left == right){
            return array[left];
        }
        if (left+1 == right){
            if (array[left]<array[right]){
                return array[left];
            }else {
                return array[right];
            }
        }
        //若首大于尾
        if(array[left]<array[right]){
            return array[left];
        }else if (array[left]>array[right]){
            //若不相等  继续切分
            int mid = (left+right)/2;
            int temp1 = _minNumberInRotateArray(array,left,mid);
            int temp2 = _minNumberInRotateArray(array,mid,right);
            if (temp1<temp2){
                return temp1;
            }else {
                return temp2;
            }
        }else {
            //若相等 开始遍历 返回结果
            for (int i=left;i<right;i++){
                if (array[i]>array[i+1]){
                    return array[i+1];
                }
            }
            return array[left];
        }
    }
    /**
     *     public int minNumberInRotateArray(int [] array) {
     *         if (array.length == 0){
     *             return 0;
     *         }
     *         for (int i=0;i<array.length-1;i++){
     *             if (array[i]>array[i+1]){
     *                 return array[i+1];
     *             }
     *         }
     *         return array[0];
     *     }
     */
}
