import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by abhimanyus on 3/22/18.
 */
public class ChocolateDistribution {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] mainArr = new int[N][];
        int[] numberOfPeople = new int[N];
        for(int i =0; i< N ; i++){
            int arraySize = Integer.parseInt(br.readLine());
            int[] array = new int[arraySize];
            String[] values = br.readLine().split(" ");
            numberOfPeople[i] = Integer.parseInt(br.readLine());
            for(int j=0; j< arraySize; j++ ){
                array[j] = Integer.parseInt(values[j]);
            }
            mainArr[i] = array;
        }

        for(int i=0; i<N; i++) {
            System.out.println(distribute(mainArr[i], numberOfPeople[i]));
        }

    }

    private static int distribute(int[] ints, int numberOfPerson) {

        Arrays.sort(ints);
        int i = 0;
        int j = numberOfPerson-1;
        int minDiff = Integer.MAX_VALUE;
        for(; j< ints.length; i++, j++){
            minDiff = Math.min(minDiff, ints[j]- ints[i]);
        }

        return minDiff;

    }


}
