import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/19/18.
 */
public class MissingNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] mainArr = new int[N][];
        for(int i =0; i< N ; i++){
            int arraySize = Integer.parseInt(br.readLine());
            int[] array = new int[arraySize];
            String[] values = br.readLine().split(" ");
            for(int j=0; j< arraySize -1; j++ ){
                array[j] = Integer.parseInt(values[j]);
            }
            mainArr[i] = array;
        }

        for(int i=0; i<N; i++) {
            System.out.println(findMissingNumber(mainArr[i]));
        }
    }

    private static int findMissingNumber(int[] numbers) {

        int finalNumber = numbers.length;
        int sum = 0;
        while(finalNumber !=0){
            sum += finalNumber;
            finalNumber --;
        }
//        System.out.println(sum);

        for(int i=0; i<numbers.length; i++){
            sum = sum - numbers[i];
        }

        return sum;


    }

}
