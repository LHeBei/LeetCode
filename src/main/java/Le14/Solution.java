package Le14;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"a"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        int length=strs.length;
        int[][] pos=new int[27][201];
        int res=0;
        for (int i=0;i<length;i++){
            int j=strs[i].length();
            if(j==0) return "";
            for (int m=0;m<j;m++){
                int index=strs[i].charAt(m)-'a';
                pos[index][m]++;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        int j = strs[0].length();
        for (int m = 0; m < j; m++) {
            int index=strs[0].charAt(m)-'a';
            if(pos[index][m]==length){
                stringBuilder.append(strs[0].charAt(m));
            }else{
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }
}
