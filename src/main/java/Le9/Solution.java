package Le9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isPalindrome(1001));
    }
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if(x<10) return true;
        long n = 0;
        int y=x;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        if((int)n==n && (int) n==y){

            return true;
        }else {
            return false;
        }
    }
}
