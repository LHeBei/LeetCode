package Le1137;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int s=solution.tribonacci(25);
        System.out.println(s);
    }
    public int tribonacci(int n) {
        int[] tris=new int[38];
        tris[0]=0;
        tris[1]=tris[2]=1;
        if(n<=2) return tris[n];
        for (int i=3;i<=n;i++){
            tris[i]=tris[i-1]+tris[i-2]+tris[i-3];
        }
        return tris[n];
    }
}
