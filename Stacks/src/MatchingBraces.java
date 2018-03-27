import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MatchingBraces {

    static Map<Character, Character> opposites = new HashMap<Character, Character>();

    public static void main(String [] args) throws IOException {
        opposites.put('}','{');
        opposites.put(')','(');
        opposites.put(']','[');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for(int i =0 ; i< N ; i++){
            strings[i] = br.readLine();
        }

        for(String braces: strings){
            System.out.println(isValid(braces));
        }


    }

    private static String isValid(String braces) {

        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i < braces.length(); i++){
            char character = braces.charAt(i);
            char poppingChar = 0;
            if(character == '{' || character == '(' || character == '['){
                stack.push(character);
            }else{
                try{
                poppingChar = stack.pop();
                if(opposites.get(character) != poppingChar){
                    return "NO";
                }
                }
                catch(EmptyStackException e){
                    return "NO";
                }
            }
        }
        if(stack.empty()){
            return "YES";
        }
        else{
            return "NO";
        }
    }


}
