import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/24/18.
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arrVal = new int[N][];
        int[] sum = new int[N];
        for(int i =0; i< N ; i++){
            String [] sizeAndSum = br.readLine().split(" ");
            int arraySize = Integer.parseInt(sizeAndSum[0]);
            sum[i] = Integer.parseInt(sizeAndSum[1]);
            int[] array = new int[arraySize];
            String[] values = br.readLine().split(" ");
            for(int j=0; j< arraySize; j++ ){
                array[j] = Integer.parseInt(values[j]);
            }
            arrVal[i] = array;
        }

        for(int i=0 ; i< N; i++) {
            System.out.println(findSumIndex(arrVal[i], sum[i]));

        }
    }

    private static String findSumIndex(int[] valuesArr, int sum) {

        int currentSum = valuesArr[0];
        int headPointer = 0, i =1;
        while(i<valuesArr.length) {
            if (currentSum == sum) {
                return "" + ++headPointer + " " + i;
            }
            if (currentSum > sum) {
                currentSum -= valuesArr[headPointer];
                headPointer++;
                continue;
            }
            if(currentSum< sum) {
                currentSum += valuesArr[i];
                i++;
            }
        }
        return "" + 0;

    }

}
