import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerManipulation {


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number  = br.readLine();

        System.out.println(manipulateInteger(number));

    }

    private static String manipulateInteger(String number) {
        int previousVal = Integer.MIN_VALUE;
        int currentVal = Integer.MIN_VALUE;

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(String.valueOf(number.charAt(0))));

        for(int i=1; i< number.length(); i++){
            previousVal = Integer.parseInt(String.valueOf(number.charAt(i-1)));
            currentVal = Integer.parseInt(String.valueOf(number.charAt(i)));
            if(currentVal ==0 || previousVal ==0){
                sb.append(currentVal);
                continue;
            }else if(currentVal % 2 == 0 && previousVal % 2 == 0){
                sb.append("*");
            } else if( currentVal %2 != 0 && previousVal %2 !=0){
                sb.append("-");
            }
            sb.append(currentVal);
        }

        return sb.toString();

    }

}
