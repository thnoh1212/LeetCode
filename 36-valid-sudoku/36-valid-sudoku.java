class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                for(int k = 0; k < 9; k++){
                    if(i == k) continue;
                    if(board[i][j] == board[k][j]) return false;
                }
                for(int k = 0; k < 9; k++){
                    if(j == k) continue;
                    if(board[i][j] == board[i][k]) return false;
                }
                
            }
        }
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                boolean check[] = new boolean[10];
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++){
                        if(board[k][l] == '.') continue;
                        if(check[Character.getNumericValue(board[k][l])]) return false;
                        check[Character.getNumericValue(board[k][l])] = true;
                    }
                } 
            }
        }
        return true;
    }
}