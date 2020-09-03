import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CowNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dataNum = sc.nextInt();
        //取数据
        for (int i=0;i<dataNum;i++){
            //奶牛数量
            int[] cowNum = new int[sc.nextInt()];
            System.out.println(cowNum.length);
            int c = sc.nextInt();//满足条件数量
            for (int n=0;n<c;n++){
                int cLine = sc.nextInt();//区间数量
                for (int j=0;j<cLine;j++){
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    for (int k = start-1;k<=end-1;k++){
                        cowNum[k] = cowNum[k]+1;
                    }
                }
            }
            String cowId = "";
            List<String> a = new ArrayList<>();
            int goodCow = 0;
            for (int n=0;n<cowNum.length;n++){
                if (cowNum[n] >= c){
                    //满足条件
                    goodCow++;
                    a.add(String.valueOf(n+1));
                }
            }
            System.out.println(goodCow);
            System.out.print(cowId);
        }
    }
}
