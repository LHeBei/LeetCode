package Le7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.reverse(1534236469));
    }
    public int reverse(int x) {
        Queue<Integer> integers=new LinkedList<>();
        if(x==0) return x;
        while (x!=0){
            integers.add(x%10);
            System.out.println(x%10);
            x=x/10;
        }
        long res=0;
        while (!integers.isEmpty()){
            res=res*10+integers.poll();
        }
        return (int)res==res? (int)res:0;
    }
}
