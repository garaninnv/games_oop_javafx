package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
           if (board[i][i] == 1 && (horizonWin(board, i) || verticalWin(board, i))) {
                return true;
           }
        }
        return false;
    }

    public static boolean horizonWin(int[][] board, int line) {
        for (int j = 0; j < board.length; j++) {
            if (board[line][j] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean verticalWin(int[][] board, int line) {
        for (int[] ints : board) {
            if (ints[line] != 1) {
                return false;
            }
        }
        return true;
    }
}
