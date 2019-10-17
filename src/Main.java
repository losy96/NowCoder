import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> a = Permutation.Permutation("aab");
        System.out.println(a.size());
        HashSet<String> hashSet = new HashSet<>();
        for (String i:a){
            System.out.println(i);
        }
    }
}
