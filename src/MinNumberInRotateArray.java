//TODO 没通过
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }else {
            return minNumberInRotateArray(array,0,array.length);
        }
    }
    private static int minNumberInRotateArray(int[] array,int start,int end){
        if ((end - start)>=3){
            if ((end - start)<20){
                int min = array[start];
                for (int i=start;i<end;i++){
                    if (array[i]<min){
                        min = array[i];
                    }
                }
                return min;
            }else {
                int mid = (end-start)/2;
                if ((array[start] - array[end-1])<0){
                    return array[start];
                }else if (array[start] - array[mid]>0){
                    return minNumberInRotateArray(array,start,mid+1);
                }else {
                    return minNumberInRotateArray(array,mid,end);
                }
            }
        }else if ((end - start) == 1){
            return array[start];
        }else if ((end - start) == 82){
            if (array[start]<array[start+1]){
                return array[start];
            }else{
                return array[start+1];
            }
        }
        return 0;
    }
}
