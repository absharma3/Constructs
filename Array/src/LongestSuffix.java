import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSuffix {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] words = br.readLine().split(",");
        System.out.println(longestCommonSuffix(words[0], words[1]));
    }


    public static String longestCommonSubsequence(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        if (word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) {
            return "";
        }
        int[][] count = new int[word1.length()][word2.length()];
        int maxLength = 0;
        int lastSubsIndex = 0;
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if ((i == 0) || (j == 0))
                        count[i][j] = 1;
                    else
                        count[i][j] = 1 + count[i - 1][j - 1];

                    if (count[i][j] > maxLength) {
                        maxLength = count[i][j];
                        int thisSubsBegin = i - count[i][j] + 1;
                        if (lastSubsIndex == thisSubsBegin) {
                            sb.append(word1.charAt(i));
                        } else {
                            lastSubsIndex = thisSubsBegin;
                            sb = new StringBuilder();
                            sb.append(word1.substring(lastSubsIndex, i + 1));
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

    public static String longestCommonSuffix(String word1, String word2){

        int N = Math.min(word1.length(), word2.length());
        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N ; i++){
            if(word1.charAt(n-1-i) == word2.charAt(m-1-i)){
                sb.append(word1.charAt(n-1-i));
            }else{
                break;
            }
        }
        String finalString = sb.reverse().toString();
        if(finalString.isEmpty()){
            return null;
        }
        return finalString;
    }


}
