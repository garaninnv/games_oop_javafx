package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
           if (horizonWin(board, i) || verticalWin(board, i)) {
                return true;
           }
        }
        return false;
    }

    public static boolean horizonWin(int[][] board, int line){
        for (int i = 0; i < board.length; i++) {
            if (board[line][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean verticalWin(int[][] board, int line){
        for (int i = 0; i < board.length; i++) {
            if (board[i][line] != 1) {
                return false;
            }
        }
        return true;
    }
}
