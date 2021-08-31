package Le13;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s= solution.intToRoman(1994);
        System.out.println(s);
    }
    public String intToRoman(int num) {
        char[][] romans= new char[][]{{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M','\0'}};
        int pos=0;
        Stack<Character> characters=new Stack<>();
        while (num!=0){
            int temp=num%10;
            num=num/10;
            if(temp==4){
                characters.push(romans[pos][1]);
                characters.push(romans[pos][0]);
            } else if(temp==9){
                characters.push(romans[pos+1][0]);
                characters.push(romans[pos][0]);
            }else if(temp==5){
                characters.push(romans[pos][1]);
            }else if(temp==0) {

            }else if (temp<5){
                for (int i=0;i<temp;i++){
                    characters.push(romans[pos][0]);
                }
            } else {
                temp=temp-5;
                for (int i=0;i<temp;i++){
                    characters.push(romans[pos][0]);
                }
                characters.push(romans[pos][1]);
            }
            pos++;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while (!characters.isEmpty()){
            stringBuilder.append(characters.pop());
        }
        return stringBuilder.toString();
    }
}
