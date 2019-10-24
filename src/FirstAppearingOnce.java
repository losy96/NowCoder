import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class FirstAppearingOnce {
    //Insert one char from stringstream
    HashSet<Character> one = new HashSet<>();
    HashSet<Character> more = new HashSet<>();
    Queue<Character> characters = new LinkedList<>();
    public void Insert(char ch) {
        if (!more.contains(ch)){
            if (!one.contains(ch)){
                characters.add(ch);
                one.add(ch);
            }else {
                one.remove(ch);
                more.add(ch);
            }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (characters.size()!=0){
            if (one.contains(characters.peek())){
                return characters.peek();
            }else {
                characters.remove();
            }
        }
        return '#';
    }
}
