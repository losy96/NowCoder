import java.util.Scanner;

public class SearchWord {
    public static boolean hasWord(String word){
        char[][] words = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//
//        }
//        return false;
        for (int i=0;i<words.length;i++){
            for (int j=0;j<words[0].length;j++){
                if (isExist(words,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isExist(char[][] words,String word,int i,int j,int k){
        if (k>= word.length()){
            return true;
        }
        if (i<0 || i >= words.length || j<0||j>=words[0].length||words[i][j] != word.charAt(k)){
            return false;
        }
        words[i][j] += 128;
        boolean anser = isExist(words,word,i-1,j,k+1) || isExist(words,word,i+1,j,k+1)
                ||isExist(words,word,i,j-1,k+1)|| isExist(words,word,i,j+1,k+1);
        words[i][j] -= 128;
        return anser;
    }

    public static void main(String[] args) {
        System.out.println(hasWord("ESES"));
    }
}
