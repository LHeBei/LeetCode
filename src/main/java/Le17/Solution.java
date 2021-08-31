package Le17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        if (digits == null) return strings;
        if(digits.length()<=0) return strings;
        char[][] data = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        int[] index = new int[]{0, 0, 0, 0, 0, 0};
        for (char ch : digits.toCharArray()) {
            int pos = ch - '2';

        }

        Queue<Character> characters = new LinkedList<>();
        int length = digits.length();
        StringBuilder stringBuilder = new StringBuilder();
        do{
            int size=characters.size();
            int pos=digits.charAt(size)-'2';
            if(index[size]>=data[pos].length){
                if(size==0) return strings;
                characters.poll();
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                index[size]=0;
            }else{
                char c=data[pos][index[size]++];
                stringBuilder.append(c);
                if(size==length-1){
                    strings.add(stringBuilder.toString());
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }else{
                    characters.offer(c);
                }
            }
        }while (true);
    }

}