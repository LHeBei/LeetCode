package Le20;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValid("{}"));
    }
    public boolean isValid(String s) {
        Stack<Character> strings=new Stack<>();
        for (Character ch:s.toCharArray()){
            switch (ch){
                case '{':
                case '[':
                case '(':
                    strings.push(ch);
                    break;
                case '}':
                    if(strings.isEmpty()){
                        return false;
                    }else {
                        Character character=strings.pop();
                        if(character!='{'){
                            return false;
                        }
                    }
                    break;
                case ']':
                    if(strings.isEmpty()){
                        return false;
                    }else {
                        Character character=strings.pop();
                        if(character!='['){
                            return false;
                        }
                    }
                    break;
                case ')':
                    if(strings.isEmpty()){
                        return false;
                    }else {
                        Character character=strings.pop();
                        if(character!='('){
                            return false;
                        }
                    }

                    break;
            }
        }
        if(strings.isEmpty()) return true;
        else return false;
    }
}
