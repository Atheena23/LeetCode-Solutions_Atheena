class Solution {
    public void solveSudoku(char[][] b) {
        solve(b);
    }
    static boolean isSafe(char[][] b,int row,int col, char num){
        for(int i=0;i<9;i++){
            if(b[row][i]==num||b[i][col]==num){
                return false;
            }
        }
        int box_row = (row/3)*3;
        int box_col = (col/3)*3;
        for(int i = box_row;i<box_row+3;i++){
            for(int j=box_col;j<box_col+3;j++){
                if(b[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean solve(char[][] b){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(b[row][col]=='.'){
                    for(char num ='1';num<='9';num++){
                        if(isSafe(b,row,col,num)){
                            b[row][col] = num;
                            if(solve(b)){
                                return true;
                            }
                            b[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}