import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

public class TestIterator {
    public static void  main(String [] args){
        Map<String ,String> testHashMap = new HashMap<>();
        testHashMap.put("lihao1","lihapo");
        testHashMap.put("lihao2","lihao");
        Iterator iterator = testHashMap.entrySet().iterator();
        System.out.println("aaaa");
//        while (iterator.hasNext()){
//            iterator.remove();
//        }
//        Collections.synchronizedList();
//        ConcurrentHashMap
        String a = "lihao";
        String b = new String("lihao");
        System.out.println(a == b);
//        AbstractQueuedLongSynchronizer
    }
}
