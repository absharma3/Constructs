import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 3/21/18.
 */
public class TrappingRainWater {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = br.readLine().split(" ");
        int [] values = new int[arr.length];
            for(int k=0; k< arr.length;k++){
                values[k] = Integer.parseInt(arr[k]);
            }
        System.out.println(trappedRainWater(values));


    }

    private static int trappedRainWater(int[] arr) {
        int N = arr.length;
        int[] maxFromLeft = new int[N];
        int[] maxFromRight = new int[N];

        maxFromLeft[0] = arr[0];
        for(int i=1; i< N ; i++){
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], arr[i]);
        }

        maxFromRight[N-1] = arr[N-1];
        for(int i = N-2; i>=0 ; i--){
            maxFromRight[i] = Math.max(maxFromRight[i+1], arr[i]);
        }

        int water = 0;

        for(int i =0; i< N ; i++){
            water += Math.min(maxFromLeft[i], maxFromRight[i]) - arr[i];
        }

        return water;
    }

}
