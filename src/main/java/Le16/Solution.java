package Le16;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,0,1,1,55},3));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int MAXINT = Integer.MAX_VALUE, rest = target;
        int len = nums.length - 1;
        for (int i = 0; i <= len - 2; i++) {
            int rest_A = target - nums[i];
            for (int j = i + 1; j <= len - 1; j++) {
                int rest_B = rest_A - nums[j];
                int temp = find(nums, rest_B, j + 1, len);
                int res = Math.abs(rest_B - temp);
                if (res == 0) return target;
                else if (res < MAXINT) {
                    MAXINT = res;
                    rest = nums[i] + nums[j] + temp;
                }
            }
        }
        return rest;
    }
    public static int find(int[] nums,int target,int l,int r){
        if(nums==null) return 0;
        int mid=0;
        int record=Integer.MAX_VALUE;
        int record_mid=0;
        while (l<=r){
            mid=(l+r)/2;
            if(Math.abs(nums[mid]-target)<record) {record=Math.abs(nums[mid]-target);record_mid=mid;}
            if(nums[mid]==target) return nums[mid];
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return nums[record_mid];
    }
}