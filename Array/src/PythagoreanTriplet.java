import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by abhimanyus on 3/22/18.
 */
public class PythagoreanTriplet {

    public static void main(String [] args) throws IOException {

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
            System.out.println(findTriplet(mainArr[i]));
        }

    }

    private static String findTriplet(int[] ints) {

        int N = ints.length;
        int [] squares = new int[N];
        HashSet<Integer> setOfSquares = new HashSet<Integer>();
        for(int i=0 ; i< N; i++){
            squares[i] = ints[i]*ints[i];
            setOfSquares.add(squares[i]);
        }

        for(int i =0; i< N ; i++){
            for(int j = i; j< N; j++){
                if(setOfSquares.contains(squares[i]+ squares[j])){
                    return "Yes";
                }
            }
        }
        return "No";

    }

}
