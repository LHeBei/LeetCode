package Le36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'.','.','.','.','8','.','.','.','7'},
                {'.','.','7','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','6','.','.'},
                {'.','.','.','.','9','.','.','.','.'},
                {'.','.','4','.','.','8','3','8','.'},
                {'.','.','.','.','.','.','.','.','8'},
                {'.','5','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','7','.'},
                {'.','.','.','.','.','.','.','.','.'}}
        ));
    }
    static class Node{
        private final int x;
        private final int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
    public static boolean getFlag(Node A,Node B){
        if(A==null || B==null) return false;
        if(A.getX()==B.getX()){
            return true;
        }else if (A.getY()==B.getY()){
            return true;
        }else{
//            int divX=Math.abs(A.getX()-B.getX());
//            int divY=Math.abs(A.getY()-B.getY());
            int Ax,Ay,Bx,By;
            Ax=Math.max(A.getX(),B.getX());
            Bx=Math.min(A.getX(),B.getX());
            Ay=Math.max(A.getY(),B.getY());
            By=Math.min(A.getY(),B.getY());
            while (Bx>=3){
                Bx-=3;
                Ax-=3;
            }
            if(Ax<3){
                while (By>=3){
                    By-=3;
                    Ay-=3;
                }
                return Ay < 3;
            }
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board) {
        if(board==null) return false;
        Node[][] nodes=new Node[10][10];
        int[] pos=new int[]{0,0,0,0,0,0,0,0,0,0,0};
        int len_x=board.length;
        for (int i=0;i<len_x;i++){
            int len_y=board[i].length;
            for (int j=0;j<len_y;j++){
                if(board[i][j]!='.'){
                    int ch=board[i][j]-'0';
                    Node tempNode= new Node(i, j);
                    for (int k=0;k<pos[ch];k++){
                        if(getFlag(tempNode,nodes[ch][k])) return false;
                    }
                    nodes[ch][pos[ch]++]=tempNode;
                }
            }
        }
        return true;
    }
}