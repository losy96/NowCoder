import java.util.ArrayList;
public class ClockwisePrintArray {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int horizontal_steps = matrix[0].length;
        int vertical_steps = matrix.length-1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = -1;
        int flag = 0;//0 1 2 3
        while (arrayList.size() != matrix[0].length*matrix.length){
            if(flag == 0){
                //向右
                for (int step = 0;step<horizontal_steps;step++){
                    j = j + 1;
                    arrayList.add(matrix[i][j]);
                }
                flag = 1;
                horizontal_steps --;
            }else if (flag == 1){
                //向下
                for (int step = 0;step<vertical_steps;step++){
                    i = i + 1;
                    arrayList.add(matrix[i][j]);
                }
                flag = 2;
                vertical_steps --;
            }else if(flag == 2){
                //向左
                for (int step = 0;step<horizontal_steps;step++){
                    j = j - 1;
                    arrayList.add(matrix[i][j]);
                }
                flag = 3;
                horizontal_steps --;
            }else if(flag == 3){
                //向上
                for (int step = 0;step<vertical_steps;step++){
                    i = i - 1;
                    arrayList.add(matrix[i][j]);
                }
                flag = 0;
                vertical_steps -- ;
            }
        }
        return arrayList;
    }
}
