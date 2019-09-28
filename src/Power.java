public class Power {
    public static double Power(double base, int exponent) {
        if (base == 0&&exponent == 0){
            return 0;
        }else {
            if (base == 0){
                return 0;
            }
            if (exponent == 0){
                return 1;
            }
            double anser = 1;
            if (exponent<0){
                base = 1/base;
                exponent = exponent*-1;
            }
            for (int i = 0;i<exponent;i++){
                anser = anser * base;
            }
            return anser;
        }
    }
}
