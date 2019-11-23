import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GetMedian a = new GetMedian();
        a.Insert(3);
        a.Insert(6);

        System.out.println(a.GetMedian());
    }
}
