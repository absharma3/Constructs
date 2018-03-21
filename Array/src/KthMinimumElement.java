import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhimanyus on 3/19/18.
 */
public class KthMinimumElement {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        String [] values = br.readLine().split(" ");

        for(int i =1 ; i<N+1;i++){
            arr[i] = Integer.parseInt(values[i-1]);
        }
        minHeapify(arr);
    }

    private static void minHeapify(int[] arr) {

        int N = arr.length;
        for(int i = N/2 ; i>0; i-- ){
            minHeapify(arr, i);
        }

    }

    private static void minHeapify(int[] arr, int i) {

        int left = 2*i;
        int right = 2*i+1;
        int N = arr.length;
        int smallest = 0;
        int index = i;
        if(left< N && arr[left]<arr[i]){
            smallest = arr[left];
            index = left;

        }else if(right< N && arr[right]<arr[i]){
            smallest = arr[right];
            index = right;
        }
        if(index != i) {
            swap(arr, i, index);
            minHeapify(arr, index);
        }

    }

    private static void swap(int[] arr, int i, int i1) {
        int temp  = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }


}
