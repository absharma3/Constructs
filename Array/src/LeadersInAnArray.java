import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/29/18.
 */
public class LeadersInAnArray {

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
            System.out.println(leaders(mainArr[i]));
        }
    }

    private static String leaders(int[] ints) {

        int N = ints.length;
        int [] sum = new int[N];
        StringBuffer returnVal = new StringBuffer();
        sum[N-1] = ints[N-1];
        for(int i=1; i<N ; i++){
            if(ints[N-i-1] > sum[N-i]){
                sum[N-i-1] = ints[N-i-1];
            }else{
                sum[N-i-1] = sum[N-i];
            }
        }

        for(int i=0; i<N-1 ; i++){
            if(sum[i] != sum[i+1]){
                returnVal.append(sum[i] + " ");
            }
        }

        returnVal.append(ints[N-1]);

        return returnVal.toString();

    }


}
