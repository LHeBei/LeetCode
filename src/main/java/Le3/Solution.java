package Le3;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution {
    public static void main(String[] args) {
//        Solution solution=new Solution();
//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(5/2);
    }

    public int lengthOfLongestSubstring(String s) {
        if(!s.isEmpty()){
            int length=s.length();
            HashMap<Character,Integer> repeat=new LinkedHashMap<>();
            int start=0,end=0;
            int max=0;
            while (end<length){

                if(repeat.containsKey(s.charAt(end))){
                    int index=repeat.get(s.charAt(end))+1;
                    for (int i=start;i<index;i++){
                        repeat.remove(s.charAt(i));
                    }
                    start=index;
                }else{
                    repeat.put(s.charAt(end),end);
                    max=Math.max(max,end-start+1);
                    end++;
                }

            }
            return max;
        }
        return 0;

    }
}