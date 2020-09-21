package duxiaoman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class DrawPic {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String colorStr = sc.next();
            String needDrawStr = sc.next();
            Map<Character,Integer> needDraw = new HashMap<>();
            Map<Character,Integer> color = new HashMap<>();
            for (int i=0;i<needDrawStr.length();i++){
                Integer num = needDraw.get(needDrawStr.charAt(i));
                if (null == num){
                    needDraw.put(needDrawStr.charAt(i),1);
                }else {
                    needDraw.put(needDrawStr.charAt(i),num+1);
                }
            }
            for (int i=0;i<colorStr.length();i++){
                Integer num = color.get(colorStr.charAt(i));
                if (null == num){
                    color.put(colorStr.charAt(i),1);
                }else {
                    color.put(colorStr.charAt(i),num+1);
                }
            }

            //比较
            Integer all = 0;
            Set<Character> keys =  needDraw.keySet();
            for (Character ch : keys){
                Integer colorNum = color.get(ch);
                Integer needDrawNum = needDraw.get(ch);
                if (null != colorNum){
                    Integer min = colorNum > needDrawNum?needDrawNum:colorNum;
                    all = all + min;
                }
            }
            System.out.println(all);
        }
    }
}
