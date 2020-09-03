import java.util.Scanner;

public class Jum {
    public static int jump(int n,int m){
        if (n == 0){
            return 0;
        }
        int a[] = new int[n];
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=n-m+1;j<i;j++){
                sum += a[j];
            }
            a[i] = sum + 1;
        }
        return a[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(jump(n,m)%((1000000000)+7));
    }
}
