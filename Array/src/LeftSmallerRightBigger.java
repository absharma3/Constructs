import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 3/23/18.
 */
public class LeftSmallerRightBigger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] values = new int[N][];
        for(int i =0;i<N;i++){
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M];
            String[] stringArr = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                arr[j]= Integer.parseInt(stringArr[j]);
            }
            values[i] = arr;
        }

        for(int[] val : values){
            System.out.println(calculate(val));
        }
    }

    private static int calculate(int[] val) {
        int N = val.length;
        int[] increasingValuesFromLeft= new int[N];
        int[] increasingValuesFromRight = new int[N];
        increasingValuesFromLeft[0]= val[0];
        increasingValuesFromRight[N-1] = val[N-1];
        for(int i=1; i<N;i++){
            increasingValuesFromLeft[i] = Math.max(increasingValuesFromLeft[i-1], val[i]);
        }

        for(int i = N-2; i>=0; i--){
            increasingValuesFromRight[i] = Math.max(increasingValuesFromRight[i+1], val[i]);
        }

        for(int i =1 ; i< N-1; i++ ){
            if(val[i]> increasingValuesFromLeft[i-1] && val[i]< increasingValuesFromRight[i+1])
                return val[i];
        }
        return -1;
    }

}
