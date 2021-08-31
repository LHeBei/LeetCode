package Le18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null || nums.length<4) return lists;
        int length=nums.length;
        Arrays.sort(nums);
        int min=nums[0],max=nums[length-1];
        int rest=0,rest_i,rest_j,rest_k,record_i=10005,record_j=10005,record_k=10005;
        for (int i=0;i<length-3;i++){

            if(record_i==nums[i]) continue;
            else record_i=nums[i];
            rest_i=target-nums[i];
            record_j=10005;
            for (int j=i+1;j<length-2;j++){
                if(record_j==nums[j]) continue;
                else record_j=nums[j];
                rest_j=rest_i-nums[j];
                record_k=10005;
                for (int k=j+1;k<length-1;k++){
                    if(record_k==nums[k]) continue;
                    else record_k=nums[k];
                    rest_k=rest_j-nums[k];
                    if(rest_k<nums[k-1] || rest_k>max) continue;
                    int pos=find(nums,k+1,length-1,rest_k);
                    if(pos!=-1){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(rest_k);
                        lists.add(list);
                    }
                }
            }
        }


        return lists;
    }

    public int find(int[] nums,int l,int r,int target){
        if(nums==null || nums.length==0) return 0;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{2,2,2,2,2};
        Arrays.sort(nums);
        int target=1;
//        System.out.println(solution.find(nums,4,nums.length-1,target));
        System.out.println(solution.fourSum(nums,8));

    }
}