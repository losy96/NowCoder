import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] a = {1};
        int[] B = Multiply.multiply(a);
        for (int i=0;i<a.length;i++){
            System.out.print(B[i]);
            System.out.print(" ");
        }
    }
}
