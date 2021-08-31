package Le37;

public class Solution {

    public static String numStr="123456789";
    public boolean isValidSudoku(char[][] board,boolean[][] row,boolean[][] col,boolean[][] block) {
//        // 记录某行，某位数字是否已经被摆放
//        boolean[][] row = new boolean[9][9];
//        // 记录某列，某位数字是否已经被摆放
//        boolean[][] col = new boolean[9][9];
//        // 记录某 3x3 宫格内，某位数字是否已经被摆放
//        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];
        isValidSudoku(board,row,col,block);
        dfs(board,row,col,block,0);
    }
    public void printBoard(char[][] board){
        System.out.print("[");
        int j = 0;
        for (int i = 0; i < 9; i++) {
            System.out.print("[");
            for (j=0;j < 8; j++) {
                System.out.print("\""+board[i][j]+"\",");
            }
            System.out.print("\""+board[i][j]+"\"");
            System.out.print("]\n");
        }
        System.out.println("]");
    }
    public boolean dfs(char[][] board,boolean[][] row,boolean[][] col,boolean[][] block,int i) {
        for (;i<9;i++){
            for (int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    int blockIndex = i / 3 * 3 + j / 3;
                    for (int k=0; k<9; k++){
                        if(!row[i][k] && !col[j][k] && !block[blockIndex][k]){
                            board[i][j]=numStr.charAt(k);
                            row[i][k] = true;
                            col[j][k] = true;
                            block[blockIndex][k] = true;
                            if(dfs(board,row,col,block,i)) return true;
                            board[i][j]= '.';
                            row[i][k] = false;
                            col[j][k] = false;
                            block[blockIndex][k] = false;
                        }
                    }
                    return false;
                }
            }
        }
        printBoard(board);
        return true;
    }

    public static void main(String[] args) {
//        Solution solution=new Solution();
//        char[][] board=new char[][]{
//                {'7','3','4','5','8','.','.','.','.'},
//                {'6','.','.','1','.','.','4','.','9'},
//                {'2','.','9','.','.','.','.','.','8'},
//                {'9','.','.','8','.','.','.','.','.'},
//                {'.','.','.','3','.','.','.','.','6'},
//                {'.','.','.','.','6','5','.','.','.'},
//                {'.','.','8','.','7','2','9','.','.'},
//                {'.','4','.','.','.','.','.','.','.'},
//                {'.','.','.','.','.','.','.','5','.'}};
//        solution.solveSudoku(board);
        System.out.println(2%3*3+3%3);
    }

}
