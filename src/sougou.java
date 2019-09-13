import java.lang.reflect.Array;

public class sougou {
    public static int[][] string_to_array(String str){

        String[] line_str = str.split("\n");
        int[][] input = new int[line_str.length][];
        for (int i = 0;i<line_str.length;i++){
            String[] node_str = line_str[i].split(" ");
            int[] temp = new int[node_str.length];
            for (int j =0 ;j<node_str.length;j++){
                temp[j] = Integer.parseInt(node_str[j]);
            }
            input[i] = temp;
        }
        return input;
    }
    public static boolean find_num(int[] input,int i){
        for (int j:input){
            if (i == j){
                return true;
            }
        }
        return false;
    }
    public static void run(int[][] input,int v){
        int k = input[0][0];
        for (int i=v;i<input.length-1;i++){
            //行
            for (int j=2;j<input[i].length;j++){
                if (input[i+1][1] == input[i][j]){
                    if (k>0){
                        k--;
                        input[i][j] = -1;
                    }
                }
            }
        }
    }
    public static int find_anser(int[][] input){
        int k = input[0][0];
        for (int i=1;i<input.length-1;i++){
            //行
            for (int j=2;j<input[i].length;j++){
                if (input[i+1][1] == input[i][j]){
                    if (k>0){
                        k--;
                        input[i][j] = -1;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] input = string_to_array("1 2 4\n2 4 5\n1 3");
        for (int[] i:input){
            for (int j:i){
                System.out.println(j);
            }
        }
    }
}
