import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args){
        Integer [] array = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(removeDuplicates(arrayList));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i =0, val = Integer.MIN_VALUE ; i< a.size(); i++){
            val = a.get(i);
            if(!set.contains(val)){
                set.add(val);
            }
        }

        return set.size();
    }

}
