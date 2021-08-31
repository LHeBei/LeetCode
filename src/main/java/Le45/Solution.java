package Le45;

public class Solution {

    public int jump(int[] nums) {
        if(nums == null) return 0;
        int res = 0, next_scope = 0,length = nums.length, cur_scope = 0;
        for(int i=0; i < length - 1; i++) {
            next_scope = Math.max(next_scope, nums[i] + i);
            if(i == cur_scope) {
                cur_scope = next_scope;
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
