package Le39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(candidates, target, res, candidates.length, 0,new ArrayList<Integer>());
        return res;
    }

    private void backTrace(int[] candidates, int target,List<List<Integer>> res, int length, int startPos,ArrayList<Integer> tempArr) {
        if(candidates == null || length == 0) return;
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tempArr));
            return;
        }
        for(int start = startPos; start < length; start++) {
            tempArr.add(candidates[start]);
            backTrace(candidates, target - candidates[start], res, length, start, tempArr);
            tempArr.remove(tempArr.size() - 1);
        }
    }
}