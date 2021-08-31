package Le12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.romanToInt("CMXCIX"));
    }
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new LinkedHashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        int record=0;
        char[] clone=s.toCharArray();
        int len=s.length()-1;
        for (int i=len;i>=0;i--){
            int dig=map.get(clone[i]);
            if(dig>=record) {
                res+=dig;
                if(dig>record) record =dig;
            }else res-=dig;
        }
        return res;
    }
}