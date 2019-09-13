import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

public class Binary {
    //设置字符数组
    //可以添加任意不重复字符，提高能转换的进制的上限
    static char chs[] = new char[36];
    static {
        for(int i = 0; i < 10 ; i++) {
            chs[i] = (char)('0' + i);
        }
        for(int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }

    /**
     * 转换方法
     * @param num       元数据字符串
     * @param fromRadix 元数据的进制类型
     * @param toRadix   目标进制类型
     * @return
     */
    static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(chs[number%toRadix]);
            number = number / toRadix;
        }
        return sb.reverse().toString();

    }
//    测试
    public static ArrayList<Integer> getBinary(String input){
        String[] input_list = input.split(":");
        ArrayList<Integer> anser = new ArrayList<>();
        for (int i = 35;i>=2;i--){
            try {
                String hour_result = transRadix(input_list[0], i, 10);
                if (Integer.valueOf(hour_result)<24&&Integer.valueOf(hour_result)>=0){
                    anser.add(i);
                }
            }catch (Exception e){
                break;
            }
        }
        ArrayList<Integer> remove_list = new ArrayList<>();
        for (int i=0;i<anser.size();i++){
            try {
                String hour_result = transRadix(input_list[1], anser.get(i), 10);
                System.out.println(Integer.valueOf(hour_result));
                if (Integer.valueOf(hour_result)>60||Integer.valueOf(hour_result)<0){
//                    remove_list.add(i);
                }else {
                    System.out.println(anser.get(i));
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return anser;
    }

    public static void main(String[] args) {
//        System.out.println(transRadix("00130",34,10));
//        ArrayList<Integer> n = new ArrayList<>();
//        n = getBinary("00002:00130");
//        for (int i:n){
//            System.out.println("anser");
//            System.out.println(i);
//        }
        System.out.println(transRadix("z",3,10));
    }
}
