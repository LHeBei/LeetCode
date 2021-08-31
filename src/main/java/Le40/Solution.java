package Le40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrace(candidates, target, candidates.length, res, -1, new ArrayList<Integer>());

        return res;
    }

    private void backTrace(int[] candidates, int target, int length, List<List<Integer>> res, int startPos, ArrayList<Integer> tempArr) {
        if(candidates == null || length == 0) return;
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tempArr));
            return;
        }
        for (int start = startPos + 1; start < length; start++) {
            if(start > startPos + 1) {
                if (candidates[start] == candidates[start - 1]) continue;
            }

            tempArr.add(candidates[start]);
            backTrace(candidates, target - candidates[start], length, res, start,tempArr);
            tempArr.remove(tempArr.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = { 2,5,2,1,2};
        Solution solution = new Solution();
        Arrays.sort(candidates);
        System.out.println(solution.combinationSum2(candidates,5));
    }
}