package Le5;

public class Solution {
    private char[] str;
    private int n;
    private int beginIndex, longestLength;

    public static void main(String[] args) {
        System.out.println(16>>3);
    }
    public String longestPalindrome(String s) {
        str = s.toCharArray();
        n = str.length;
        extendedCenter(n >> 1, 0);
        return new String(str, beginIndex, longestLength);
    }

    // 从 index 位置开始搜索最长回文子串，direction 表示搜索方向。
    private void extendedCenter(int index, int direction) {
        int i = index - 1, j = index + 1;
        while (i >= 0 && str[i] == str[index]) {
            i--;
        }
        while (j < n && str[j] == str[index]) {
            j++;
        }
        int left = i, right = j; // str(i, j) 区间的字符相同，以 str(i, j) 为中心进行扩展。
        while (left >= 0 && right < n && str[left] == str[right]) {
            left--;
            right++;
        }
        if (right - left - 1 > longestLength) {
            beginIndex = left + 1;
            longestLength = right - left - 1;
        }
        if (direction >= 0 && n - j << 1 > longestLength) {
            extendedCenter(j, 1);
        }
        if (direction <= 0 && i + 1 << 1 > longestLength) {
            extendedCenter(i, -1);
        }
    }
}