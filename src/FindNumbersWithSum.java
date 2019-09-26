import java.util.ArrayList;

public class FindNumbersWithSum {
    public static ArrayList<Integer> _FindNumbersWithSum(int [] array,int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i=0;i<array.length;i++){
            for (int j=array.length-1;j>=0;j--){
                if (i == j) break;
                if (array[i]+array[j]<sum){
                    break;
                }else if (array[i]+array[j] == sum){
                    ArrayList<Integer> anser = new ArrayList<>();
                    anser.clear();
                    anser.add(array[i]);
                    anser.add(array[j]);
                    arrayLists.add(anser);
                }
            }
        }
        if (arrayLists.size() != 0){
            ArrayList<Integer> an = arrayLists.get(0);
            int min = arrayLists.get(0).get(0)*arrayLists.get(0).get(1);
            for (ArrayList<Integer> temp : arrayLists){
                if (min > temp.get(0)*temp.get(1)){
                    an = temp;
                    min = temp.get(0)*temp.get(1);
                }
            }
            return an;
        }else {
            ArrayList<Integer> an = new ArrayList<>();
            return an;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(_FindNumbersWithSum(a,21).get(0));
    }
}
