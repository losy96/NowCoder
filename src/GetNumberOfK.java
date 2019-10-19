public class GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        if (array.length == 0){
            return 0;
        }
        return search(array,0,array.length-1,k);
    }
    public static int search(int [] array,int start,int end,int k){
        if (start == end){
            if (array[start] == k){
                return 1;
            }else {
                return 0;
            }
        }
        int mid = (start+end)/2;
        if (array[mid] == k){
            //前后开始探寻
            int i = 1;
            start = mid - 1;
            end = mid + 1;
            if (start>=0){
                while (array[start]==k){
                    i++;
                    start--;
                    if (start<0){
                        break;
                    }
                }
            }
            if (end <= array.length-1){
                while (array[end] == k){
                    i++;
                    end++;
                    if (end>=array.length){
                        break;
                    }
                }
            }
            return i;
        }else if (array[mid]<k){
            return search(array,mid+1,end,k);
        }else {
            return search(array,start,mid-1,k);
        }
    }
}
