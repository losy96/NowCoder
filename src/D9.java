import java.util.Scanner;

public class D9 {
    public static void d9(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intNum = new int[n];
        int zeroNum = 0;
        int fiveNum = 0;
        int sum = 0;
        for (int i=0;i<n;i++){
            intNum[i] = sc.nextInt();
            if (intNum[i] == 0){
                zeroNum ++;
            }
            if (intNum[i] == 5){
                fiveNum++;
            }
            sum = sum + intNum[i];
        }
        if (zeroNum == 0 || sum % 9 != 0){
            System.out.println(-1);
            return;
        }else {
            //随意组合，保证最后一个数字是0即可
            String num = "";
            for (int i=0;i<fiveNum;i++){
                num = num + 5;
            }
            for (int i=0;i<zeroNum;i++){
                num = num + 0;
            }
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        d9();
    }
}
