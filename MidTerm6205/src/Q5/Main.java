package Q5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {


    public ArrayList<Integer> getStartOfEachValues(int[] nums, int[] values) {
        ArrayList<Integer> indexes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums.length) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            i++;
        }
        i=0;
        while (i < values.length) {
            if (map.containsKey(values[i])) {
                indexes.add(map.get(values[i]));
            } else {
                indexes.add(-1);
            }
            i++;
        }

        return indexes;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 5, 5, 5, 8, 9, 10, 11};
        int[] values = new int[]{1, 4, 5, 10};
        Main main = new Main();
        ArrayList<Integer> indexes = main.getStartOfEachValues(nums, values);
        System.out.println(indexes.toString());

    }
}

        // output = [5, -1, 12, 17]


