import java.util.Scanner;

public class Aera {
    public static void compute(){
        Scanner sc = new Scanner(System.in);
        //获取数据
        String data = sc.next();
        String[] dataStrArray = data.split(",");
        Integer[] daraArray = new Integer[dataStrArray.length];
        for (int i=0;i<daraArray.length;i++){
            daraArray[i] = Integer.valueOf(dataStrArray[i]);
        }
        int sum = 0;
        for (int i=1;i<daraArray.length-1;i++){
            if (daraArray[i] <= daraArray[0]){
                daraArray[i] = -1;
            }
            if (daraArray[i] <= daraArray[daraArray.length-1]){
                daraArray[i] = -1;
            }
        }
        int step = 1;
        for (int i=1;i<daraArray.length;i++){
            if (daraArray[i] == -1){
                step++;
                continue;
            }else {
                if (daraArray[i] < daraArray[i -step]){
                    sum = sum + daraArray[i] * step;
                    step = 1;
                }else {
                    sum = sum + daraArray[i-step] *step;
                    step = 1;
                }
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        compute();
    }
}
