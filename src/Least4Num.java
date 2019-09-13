import java.util.ArrayList;

public class Least4Num {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max_k = k;
        if (input.length<k||k==0){
            return arrayList;
        }
        for (int i=0;i<max_k;i++){
            arrayList.add(input[i]);
        }
        int[] max = FindMax(arrayList);
        for (int i=k;i<input.length;i++){
            if (input[i]<max[1]){
                arrayList.remove(max[0]);
                arrayList.add(input[i]);
                max = FindMax(arrayList);
            }
        }
        return arrayList;
    }

    public static int[] FindMax(ArrayList<Integer> input){
        int index = 0;
        int[] max_list = new int[2];
        max_list[0] = 0;
        max_list[1] = input.get(0);
        for (int i:input){
            if (i>max_list[1]){
                max_list[1] = i;
                max_list[0]=index;
            }
            index++;
        }
        return max_list;
    }

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        int k = 10;
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(a,k);
        for (int i: arrayList){
            System.out.println(i);
        }
    }
}
