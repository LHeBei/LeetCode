package Le8;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.myAtoi("-000000000000001"));
    }
    public int myAtoi(String s) {
        if(s.isEmpty()) return 0;
        int length=s.length();
        int MAX_INT=2147483647;
        int MIN_INT=-2147483648;

        int next=0,index=0,res=0;
        char ch;
        while (true){
            ch=s.charAt(index);
            switch (next){
                case 0://初始状态可读入空格、负号
                    if(Character.isDigit(ch)){
                        next=1;
                        break;
                    }
                    if(ch=='-'){
                        next=2;
                        index++;
                        break;
                    }
                    if(ch=='+'){
                        next=3;
                        index++;
                        break;
                    }
                    if(ch==' '){
                        index++;
                        break;
                    }
                    if(Character.isAlphabetic(ch)) return 0;
                    return 0;
                case 1://已经读入过数字
                    if(Character.isDigit(ch)){

                        int chValue=ch-'0';
                        if(res<0){
                            int rest=MIN_INT/10-res;
                            if(rest>0){
                                return MIN_INT;
                            }else if(rest==0){
                                if(chValue<=8){
                                    res =res*10-chValue;
                                }else{
                                    return MIN_INT;
                                }
                            }else {
                                res=res*10-chValue;
                            }
                        }else if(res>0){
                            int rest=MAX_INT/10-res;
                            if(rest<0){
                                return MAX_INT;
                            }else if (rest==0){
                                if(chValue<=7){
                                    res =res*10+chValue;
                                }else{
                                    return MAX_INT;
                                }
                            }else{
                                res=res*10+chValue;
                            }
                        }else{
                            res=chValue;
                        }
                    }else {
                        return res;
                    }
                    index++;
                    break;
                case 2://已经读入过-号
                    if(Character.isDigit(ch)) {
                        int chValue=ch-'0';
                        if (chValue!=0) {
                            res= -chValue;
                            next=1;
                        }
                        index++;
                        break;
                    }else{
                        return 0;
                    }

                case 3://已经读入过+号
                if(Character.isDigit(ch)) {
                        int chValue=ch-'0';
                    if (chValue!=0) {
                        res= chValue;
                        next=1;
                    }
                    index++;
                    break;
                }else{
                    return 0;
                }
                default:
                    return res;
            }
            if(index==s.length()) return res;
        }
    }
}
