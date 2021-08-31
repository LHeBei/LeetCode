package Le15;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{1,-1,-1,0};
        System.out.println(solution.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null || nums.length<3) return lists;
        int length=nums.length;
        Arrays.sort(nums);
        int record_i=100005,record_j=100005;
        int minNum=nums[0];
        int maxNum=nums[length-1];
        int rest=0;
        for (int i=0;i<length-2;i++){
            if(record_i==nums[i]) continue;
            record_i=nums[i];
            rest=-nums[i];
            int s=rest;
            record_j=100005;
            for (int j=i+1;j<length-1;j++){
                if(record_j==nums[j]) continue;
                record_j=nums[j];
                int tempRest=rest-nums[j];
                if(tempRest<nums[i] || tempRest>maxNum) continue;
                int r=find(j+1,length-1,nums,tempRest);
                if(tempRest==r) {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(r);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
    int find(int l,int r,int[] nums,int target){
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return nums[mid];
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return 100005;
    }
}