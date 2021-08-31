package Le46;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = arrayToList(nums);
        List<List<Integer>> res = new ArrayList<>();
        fillNums(temp, 0, nums.length - 1, res);
        return res;
    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        if(nums == null) return temp;
        for (int n:nums) temp.add(n);
        return temp;
    }
    private void fillNums(List<Integer> nums, int cursor, int end, List<List<Integer>> res) {
        if(cursor == end) {
            res.add(new ArrayList<>(nums));
        }
        boolean isSwapAccept = swapAccept(nums, cursor, end);
        for(int i = cursor; i <= end; i++){
            if(isSwapAccept) {
                swap(nums, cursor, i);
                fillNums(nums, cursor + 1, end,res);
                swap(nums, cursor, i);
            }
        }
    }

    private boolean swapAccept(List<Integer> nums, int start, int end) {
        for(int i = start; i < end; i++) {
            if(nums.get(i) < nums.get(end)) {
                return false;
            }
        }
        return true;
    }
    private void swap(List<Integer> nums, int cursor, int dest) {
        if(nums == null) return;
        int temp = nums.get(cursor);
        nums.set(cursor, nums.get(dest));
        nums.set(dest, temp);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Solution solution =new Solution();
        System.out.println(solution.permute(nums));
    }
}
