import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        char [] a = {'a','a','a'};
        char[] pattern = {'a','b','*','a','c','*','a'};
        System.out.println(a);
        System.out.println(Match.match(a,pattern));
    }
}
