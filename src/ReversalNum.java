public class ReversalNum {
    public static int ReversalNum(int input){
        try {
            if (input>0){
                String str = String.valueOf(input);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.reverse();
                str = stringBuffer.toString();
                int output = Integer.valueOf(str);
                return output;
            }else {
                input = -1*input;
                String str = String.valueOf(input);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.reverse();
                str = stringBuffer.toString();
                int output = Integer.valueOf(str);
                output  =output*-1;
                return output;
            }
        }catch (Exception e){
            return 0;
        }

    }
}
