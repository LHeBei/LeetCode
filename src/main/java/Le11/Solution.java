package Le11;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int s=solution.maxArea(new int[]{4,3,2,1,4});
        System.out.println(s);
    }
    public int maxArea(int[] height) {
        int len=height.length;
        int l=0,r=len-1,res=0;

        while (l<r){
            res = Math.max(Math.min(height[l],height[r])*(r-l),res);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return res;
    }
}
