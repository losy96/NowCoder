public class JumpFloorII {
    public static int JumpFloorII(int target) {
        if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else {
            int[] history = new int[target];
            history[0] = 1;
            history[1] = 2;
//            for (int i=2;i<target;i++){
//                history[i] = 1;
//                for (int j = 0;j<i;j++){
//                    history[i] = history[j] + history[i];
//                }
//            }
            /**
             * f(1) = 1;
             * f(2) = f(1)+1;
             * f(3) = f(2) + f(1) + 1;
             * f(4) = f(3) + f(2) + f(1) + 1;
             * f(n) = 2*f(n-1);
             */
            for (int i = 2;i<target;i++){
                history[i] = 2*history[i-1];
            }
            return history[target-1];
        }
    }
}
