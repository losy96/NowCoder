import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Year {
    public static String getTime(String str){
        if (str.endsWith("%")){
            return "";
        }
        String pattern = "([0-9]*[0-9])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        int i=0;
        String answer = "";
        while (m.find()){
            String year = m.group(i);
            Integer yearInt = Integer.valueOf(year);
            if (1000<=yearInt && yearInt <= 3999){
                answer = answer + year + " ";
            }
            i++;
        }
        if (answer.endsWith(" ")){
            return answer.substring(0,answer.length()-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        boolean f = true;
        System.out.println(sc.next());
        System.out.println(sc.next());
        System.out.println(sc.hasNext());
        while (sc.hasNext()){
            String answer = getTime(sc.next());
            if (!"".equals(answer)){
                if (f != true){
                    System.out.print(" ");
                }
                f = false;
                System.out.print(answer);
            }
        }
    }
}
