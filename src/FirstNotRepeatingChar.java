import java.util.HashMap;

public class FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> charIndex = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (charIndex.get(str.charAt(i)) == null){
                charIndex.put(str.charAt(i),1);
            }else {
                charIndex.put(str.charAt(i),charIndex.get(str.charAt(i))+1);
            }
        }

        for (int i=0;i<str.length();i++){
            if (charIndex.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
