package com.garrapeta.alg.queens;

import java.util.HashSet;
import java.util.Set;

public class Queens {

    Set<boolean[][]> solve(int size) {
        final Set<boolean[][]> sols = new HashSet<boolean[][]>();
        solve(0, new boolean[size][size], sols);
        return sols;
    }

    void solve(int i,  boolean[][] board, Set<boolean[][]> sols) {
        if (i == board.length) {
            sols.add(board);
            return;
        }

        int boardSize = board[0].length;
        for (int j = 0; j < boardSize; j++) {
            if (isAllowed(board, i, j)) {
                boolean[][] board2 = copy(board);
                board2[i][j] = true;
                solve(i + 1, board2, sols);
            }
        }

    }

    private boolean[][] copy(boolean[][] board) {
        int boardSize = board[0].length;
        boolean[][] newBoard = new boolean[boardSize][boardSize];

        for (int h = 0; h < boardSize; h++) {
            System.arraycopy(board[h], 0, newBoard[h], 0, boardSize);
        }

        return newBoard;
    }

    static boolean isAllowed(boolean[][] board, int i, int j) {
        if (board[i][j]) {
            return false;
        }

        int boardSize = board[0].length;
        // horizontal
        for (int f = 0; f < boardSize; f++) {
            if (board[f][j]) {
                return false;
            }
        }

        // vertical
        for (int g = 0; g < boardSize; g++) {
            if (board[i][g]) {
                return false;
            }
        }

        // diag up left
        {
            int f = i;
            int g = j;
            while (f >= 0 && g >= 0) {
                if (board[f][g]) {
                    return false;
                }
                f--;
                g--;
            }
        }
        // diag up right
        {
            int f = i;
            int g = j;
            while (f < boardSize && g >= 0) {
                if (board[f][g]) {
                    return false;
                }
                f++;
                g--;
            }
        }
        // diag down left
        {
            int f = i;
            int g = j;
            while (f >= 0 && g < boardSize) {
                if (board[f][g]) {
                    return false;
                }
                f--;
                g++;
            }
        }
        // diag down right
        {
            int f = i;
            int g = j;
            while (f < boardSize && g < boardSize) {
                if (board[f][g]) {
                    return false;
                }
                f++;
                g++;
            }
        }
        return true;
    }

}
