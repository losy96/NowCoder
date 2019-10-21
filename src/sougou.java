import java.lang.reflect.Array;

public class sougou {
    private static int[] change(String input){
        int[] state = new int[input.length()];
        for (int i=0;i<input.length();i++){
            if (input.charAt(i) == 'R'){
                state[i] = 1;
            }else {
                state[i] = -1;
            }
        }
        for (int i:state){
            System.out.println(i);
        }
        return state;
    }
    private static int[] anser(int[] state){
        int[] anser = new int[state.length];
        //计算第i个机器人最终位置
        for (int i = 0;i<state.length;i++){
            boolean flag = false;//判断是否进入震荡
            int step = 0;
            while (!flag){
                if (state[i+step] == 1&&state[i+step+1] == 1){
                    step++;
                }else if(state[i+step] == -1&&state[i+step-1] == -1){
                    step--;
                }else {
                    flag = true;
                    if (step%2==0){
                        anser[i+step] = anser[i+step]+1;
                    }else {
                        if (state[i+step] == 1){
                            anser[i+step+1]++;
                        }else {
                            anser[i+step-1]++;
                        }
                    }
                }
            }
        }
        for (int i:anser){
            System.out.println(i);
        }
        return anser;
    }
    public static void main(String[] args) {
//        System.out.println(NumberOf1Between1AndN.NumberOf1Between1AndN(1));
        sougou.anser(sougou.change("RRRRRLRLRL"));
    }
}
