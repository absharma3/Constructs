import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/26/18.
 */
public class Sorting012 {

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
            int[] retArr = sort(mainArr[i]);
            for(int j = 0 ; j< retArr.length ; j++){
                System.out.print(retArr[j] +" ");
            }
            System.out.println("");
        }
    }

    private static int[] sort(int[] ints) {


        int N = ints.length;
        if(N == 1){
            return ints;
        }
        int updatedIndex = 0;
        int temp =0;
        for(int i=0;i< 3; i++){
            for(int j=updatedIndex; j<N; j++){
                if(i == ints[j]){
                    temp = ints[j];
                    ints[j] = ints[updatedIndex];
                    ints[updatedIndex] = temp;
                    updatedIndex++;
                }
            }
        }
        return ints;
    }


}
