import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 1/25/18.
 */
class Equilibrium {


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
            System.out.println(findEquilibrium(mainArr[i]));
        }
    }

    private static int findEquilibrium(int[] values) {

        int N = values.length;
        if(N ==1)
            return 1;
        int [] forwardSum = new int[N];
        forwardSum[0] = values[0];
        int [] backwardSum = new int[N];
        backwardSum[N-1] =  values[N-1];
        for(int i=1; i<N; i++){
            forwardSum[i] = forwardSum[i-1] + values[i];
            backwardSum[N-1-i] = backwardSum[N-i] + values[N-1-i];
        }

        for(int i=1; i< N-1; i++){
            if(forwardSum[i-1] == backwardSum[i+1]){
                return i+1;
            }
        }
        return -1;
    }


}
