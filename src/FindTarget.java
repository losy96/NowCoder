public class FindTarget {
    public boolean Find(int target, int [][] array) {
        if (array.length==0||array[0].length==0){
            return false;
        }
        int i = array.length/2;
        int j = array[0].length/2;
        boolean find_flag;
        if (array[i][j]<target){
            find_flag = fromBig(target,array);
            if (find_flag){
                return true;
            }else {
                find_flag = fromLittle(target,array);
                if (find_flag){
                    return true;
                }
            }
        }else {
            find_flag = fromLittle(target,array);
            if (find_flag){
                return true;
            }else {
                find_flag = fromBig(target,array);
                if (find_flag){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean fromLittle(int target, int [][] array){
        if (array[0].length>array.length){
            for (int j=0;j<array[0].length;j++){
                int i=0;
                int temp_j = j;
                while (i<array.length&&temp_j>=0){
                    if (array[i][temp_j] == target){
                        return true;
                    }
                    i++;
                    temp_j--;
                }
            }
        }else {
            for (int i=0;i<array.length;i++){
                int j=0;
                int temp_i = i;
                while (temp_i>=0&&j<array[0].length){
                    if (array[temp_i][j] == target){
                        return true;
                    }
                    temp_i--;
                    j++;
                }
            }
        }

        return false;
    }
    public boolean fromBig(int target, int [][] array){
        if (array.length<array[0].length){
            for (int j=array[0].length-1;j>=0;j--){
                int i = array.length-1;
                int temp_j = j;
                while (i>=0&&temp_j<array.length){
                    if (array[i][temp_j] == target){
                        return true;
                    }
                    i--;
                    temp_j++;
                }
            }
        }else {
            for (int i=array.length-1;i>=0;i--){
                int j = array[0].length-1;
                int temp_i = i;
                while (j>=0&&temp_i<array.length){
                    if (array[temp_i][j] == target){
                        return true;
                    }
                    j--;
                    temp_i++;
                }
            }
        }
        return false;
    }
}
