package Subset;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            int size = lists.size(); //dynamically change the size of lists
            for(int j = 0; j < size; j++){
                //copy  all array elements in the jth array of lists to an array newList.
                List<Integer> newList = new ArrayList<>(lists.get(j));
                newList.add(nums[i]);//Note: this newList is one dimensional.
                //such as []->[1] then stop.
                lists.add(newList);
            }
        }
        return lists;
    }
}
