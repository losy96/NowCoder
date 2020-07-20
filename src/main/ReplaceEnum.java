package main;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceEnum {
    private final static String POSTFIX = "11111ChangeEnum11111";
    private final static String NEW_FILE_PREFIX = "new_file_";

    /**
     * 去除代码中的注解
     * @param code
     * @return
     */
    private static String removeAnnotation(String code){
        //分解成一行一行
        String[] codeList = code.split("\n");
        String newCode = codeList[0];//一般文件开始都是package
        for (int i=1;i<codeList.length;i++){
            if (!codeList[i].startsWith("@")){
                newCode = newCode + "\n" + codeList[i];
            }
        }
        return newCode;
    }

    /**
     * 将code读取成Str
     * @param file
     * @return
     */
    public static String getCodeString(File file){
        String content = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] buffer=new byte[10240];
            int flag=0;
            while((flag=bufferedInputStream.read(buffer))!=-1){
                content += new String(buffer, 0, flag);
            }
            //关闭的时候只需要关闭最外层的流就行了
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 将文件中旧内容完全替换掉
     * @param file
     * @param code
     */
    private static void writeInNewFile(File file,String code){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(code);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String replaceAngleBrackets(String code){
        String[] codeList = code.split("\n");
        //一般开始都是package
        String newCode = codeList[0];
        for (int i=1;i<codeList.length;i++){
            String lineCodeStr = codeList[i];
            //进行正则匹配尖括号，如果存在，在进行判断=，如果存在判断是否存在<>，存在则进行替换
            String pattern = " [A-Z][A-Za-z0-9_]*<[A-Z].*>";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(lineCodeStr);
            if (m.find()){//判断是否有=
                pattern = "[=]";
                r = Pattern.compile(pattern);
                m = r.matcher(lineCodeStr);
                if (m.find()){//判断双侧是否都存在<>
                    String[] equalsSide = lineCodeStr.split("=");
                    if (equalsSide.length == 2){
                        //将后面<>内容替换为前面部分<>
                        //判断两边是否都存在
                        pattern = "(?= [A-Z].*)?<.*>";
                        r = Pattern.compile(pattern);
                        Matcher mLeft = r.matcher(equalsSide[0]);
                        Matcher mRight = r.matcher(equalsSide[1]);
                        if (mLeft.find() && mRight.find()){
                            //判断右侧尖括号中间是否为空
                            pattern = "[ <>(]";
                            r = Pattern.compile(pattern);
                            m = r.matcher(equalsSide[1]);
                            if (m.find()){
                                equalsSide[1] = equalsSide[1].replace("<>(",mLeft.group(0)+"(");
                            }
                        }
                        lineCodeStr = equalsSide[0]+"="+equalsSide[1];
                    }
                }
            }
            newCode = newCode + '\n' + lineCodeStr;
        }
        return newCode;
    }

    /**
     * 替换主要逻辑
     * @param code
     * @return
     */
    private static String replaceEnumInString(String code){
        String newCode = null;
        newCode = code.replace(" enum."," enum"+POSTFIX+".");
        newCode = newCode.replace("(enum.","(enum"+POSTFIX+".");
        newCode = newCode.replace("\tenum.","\tenum"+POSTFIX+".");
        newCode = removeAnnotation(newCode);
        return newCode;
    }

    /**
     * 主程序
     * @param sourcePath
     */
    public static void replaceEnum(String sourcePath){
        File file = new File(sourcePath);
        File[] files = file.listFiles();
        for (File f:files){
            if (f.isDirectory()){
                //TODO 只匹配.java
                replaceEnum(f.getPath());
            }else {
                if (f.toString().endsWith(".java")){
                    String content = getCodeString(f);
                    //过滤
                    //写入文件
                }
            }
        }
    }

    /**
     * 待删除
     * @param args
     */
    public static void main(String[] args) {
        replaceEnum("/Users/lihao/Desktop/学校/实验/替换/argouml");
        String code = "liaho enum. \tenum.     (enum.xac) @lihao (enum enum.\n \n \n@lihao\npublic Li_st<String<a,<b,c>>> = new Palhao<>()";
        System.out.println(replaceEnumInString(code));
        File file = new File("/Users/lihao/Desktop/学校/实验/替换/liaho.txt");
        writeInNewFile(file,"lihaotest\nhasas");
        System.out.println(replaceAngleBrackets(code));
    }
}
