package Le509;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int s=solution.fib(4);
        System.out.println(s);

    }
    public int fib(int n) {
        int[] fibs=new int[31];
        fibs[0]=0;fibs[1]=1;
        if(n<=1) return fibs[n];
        for (int i=2;i<=n;i++){
            fibs[i]=fibs[i-1]+fibs[i-2];
        }
        return fibs[n];
    }
}
