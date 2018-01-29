import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/27/18.
 */
public class MaxSumIncreasingContSubSeq {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] mainArr = new int[N][];
        for(int i =0; i< N ; i++){
            int arraySize = Integer.parseInt(br.readLine());
            int[] array = new int[arraySize];
            String[] values = br.readLine().split(" ");
            for(int j=0; j< arraySize; j++ ){
                array[j] = Integer.parseInt(values[j]);
            }
            mainArr[i] = array;
        }

        for(int i=0; i<N; i++) {
            System.out.println(maxSumIncreasingSubSeq(mainArr[i]));
        }
    }

    private static int maxSumIncreasingSubSeq(int[] values) {
        int startingIndex =0;
        int lastElementVal = 0;
        int maxSum = 0;
        int currentSum =0;
        int finalStartIndex = 0;
        int finalEndIndex = 0;

        for(int i=0; i<values.length; i++){

            if(maxSum<currentSum){
                maxSum = currentSum;
                finalStartIndex = startingIndex;
                finalEndIndex = i;
            }
            if(lastElementVal > values[i]){
                currentSum = 0;
                startingIndex = i;
            }
            currentSum += values[i];
            lastElementVal = values[i];
        }

        return maxSum;
    }

}
