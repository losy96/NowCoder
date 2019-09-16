public class ChangeNum {
    public static void ChangeNum(int a,int b){
        //第一次ab异或之后，a为ab异或之后的结果
        a = a ^ b;
        //a已是异或之后的结果，下方式再次与b异或之后，效果为将第一次与b异或的结果抵消，恢复出a
        b = a ^ b;
        //a在上方代码中未出现变化，但上方代码已经b的值变成了初始的a
        // 所以下方使用的是a与b异或，使用初次异或之后的结果与初始的a进行异或，会抵消初始a，恢复出初始b
        a = a ^ b;
        //实现了ab互换
    }
}
