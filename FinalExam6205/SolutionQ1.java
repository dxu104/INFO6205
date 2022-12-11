package FinalExam6205;

import java.util.*;

class SolutionQ1 {

    //Time Complexity: O(NKlogK);
   // Space Complexity: O(NK);

    public List<List<String>> group(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String word_ordered = Arrays.toString(word);
            //if key not exists, we will create a new ArrayList.
            //if key exists, we will assign the default value to list.
            List<String> subList = map.getOrDefault(word_ordered, new ArrayList<String>());
            subList.add(s);
            map.put(word_ordered, subList);
        }

        ArrayList<List<String>> res= new ArrayList<>();
        for(List<String> sub : map.values()){
            res.add(sub);
        }
        return res;
    }

    public static void main(String[] args) {
       String [] s1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        ArrayList<List<String>> res1= new ArrayList<>();
        SolutionQ1 solution = new SolutionQ1();
        res1= (ArrayList<List<String>>) solution.group(s1);
        System.out.println(res1.toString());

        String [] s2 = new String[]{""};
        ArrayList<List<String>> res2= new ArrayList<>();
        res2= (ArrayList<List<String>>) solution.group(s2);
        System.out.println(res2);

        String [] s3 = new String[]{"a"};
        ArrayList<List<String>> res3= new ArrayList<>();
        res3= (ArrayList<List<String>>) solution.group(s3);
        System.out.println(res3);


    }
}
