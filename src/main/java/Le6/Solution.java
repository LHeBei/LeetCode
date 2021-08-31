package Le6;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.convert("A",2));
    }
    public String convert(String s, int numRows) {
//        System.out.println(s.length());
        int length=s.length();
        if(numRows==1 || length<numRows) return s;

        int index=0,step=numRows*2-2;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<numRows;i++){
            index=i;
            do {
                stringBuilder.append(s.charAt(index));
                if(i!=0 && i!=numRows-1){
                    int sek=(numRows-i-1)*2;
                    if(index+sek<length){
                        stringBuilder.append(s.charAt(index+sek));
                    }
                }
                index=index+step;
            }while (index<length);

        }
//        System.out.println(stringBuilder.toString().length());
        return stringBuilder.toString();
    }
}