package Le4;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{2},new int[]{}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1length=nums1.length;
        int num2length=nums2.length;
        int total=num1length+num2length;
        int top=0,bellow=0;
        if(total%2==0){
            top=total/2+1;
            bellow=total/2;
        }else {
            top = bellow= (int) Math.ceil((double) total/2);
        }
        int num1=0,num2=0;
        total=0;
        while (true){
            if(num1<num1length || nums1[num1] >= nums2[num2]){
                if (bellow == num1 + num2 + 1) {
                    total += nums2[num2];
                }
                if (top == num1 + num2 + 1) {
                    total += nums2[num2];
                    return (double) total / 2;
                }
                num2++;
            }else{
                if (bellow == num1 + num2 + 1) {
                    total += nums1[num1];

                }
                if (top == num1 + num2 + 1) {
                    total += nums1[num1];
                    return (double) total / 2;
                }
                num1++;

            }

        }
//        while (true) {
//            if (num1 == num1length) {
//                if (bellow == num1 + num2 + 1) {
//                    total += nums2[num2];
//                }
//                if (top == num1 + num2 + 1) {
//                    total += nums2[num2];
//                    return (double) total / 2;
//                }
//                num2++;
//            } else if (num2 == num2length) {
//
//                if (bellow == num1 + num2 + 1) {
//                    total += nums1[num1];
//                }
//                if (top == num1 + num2 + 1) {
//                    total += nums1[num1];
//                    return (double) total / 2;
//                }
//                num1++;
//            } else {
//                if (nums1[num1] >= nums2[num2]) {
//
//                    if (bellow == num1 + num2 + 1) {
//                        total += nums2[num2];
//                    }
//                    if (top == num1 + num2 + 1) {
//                        total += nums2[num2];
//                        return (double) total / 2;
//                    }
//                    num2++;
//                } else {
//
//                    if (bellow == num1 + num2 + 1) {
//                        total += nums1[num1];
//
//                    }
//                    if (top == num1 + num2 + 1) {
//                        total += nums1[num1];
//                        return (double) total / 2;
//                    }
//                    num1++;
//
//                }
//            }
//        }
    }

}