package pattern;

import java.util.Scanner;

public class CheckPassword {
    public static void checkPassword(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String password = sc.next();
            //检查长度
            if (8>password.length()||password.length()>120){
                System.out.println(1);
                continue;
            }
            //检查类型
            boolean num = false;
            boolean small = false;
            boolean big = false;
            boolean type = false;
            for (int i=0;i<password.length();i++){
                int charNum = (int) password.charAt(i);
                if ((int) '0' <= charNum && charNum <= (int) '9'){//数字
//                    System.out.println("num:"+password.charAt(i));
                    num = true;
                }else if ((int) 'a' <= charNum && charNum <= (int) 'z'){//小写字母
//                    System.out.println("small:"+password.charAt(i));
                    small = true;
                }
                else if ((int) 'A' <= charNum && charNum <= (int) 'Z'){//小写字母
//                    System.out.println("big:"+password.charAt(i));
                    big = true;
                }else {
//                    System.out.println("type:"+password.charAt(i));
                    type = true;
                }
            }
            if (num && small && big && type){
                System.out.println(0);
                continue;
            }else {
                System.out.println(2);
                continue;
            }
        }
    }

    public static void main(String[] args) {
        checkPassword();
    }
}
