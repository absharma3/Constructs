import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/23/18.
 */
public class KadanesAlgo {

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

        for(int i=0; i<N; i++){
            System.out.println(findMaxSum(mainArr[i]));
        }


    }

    private static int findMaxSum(int[] arr) {
        int leastNagativeNumber = -2147483648;
        int maxEndingHere =0 , maxSoFar = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]> leastNagativeNumber && arr[i]<0){
                leastNagativeNumber = arr[i];
            }
            maxEndingHere += arr[i];
            if(maxEndingHere < 0 ){
                maxEndingHere = 0;
            }
            if(maxSoFar< maxEndingHere){
                maxSoFar = maxEndingHere;
            }
        }
        if(maxSoFar == 0 ){
            return leastNagativeNumber;
        }
        return maxSoFar;

    }

}
