package com.garrapeta.alg.queens;

public class Queens {

    boolean[][] solve(int size) {
        return solve(0, size, new boolean[size][size]);
    }

    boolean[][] solve(int current, int target, boolean[][] board) {
        if (current == target) {
            return board;
        }

        int boardSize = board[0].length;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (isAllowed(board, i, j)) {
                    boolean[][] newBoard = solve(current + 1, target, place(board, i, j));
                    if (newBoard != null) {
                        return newBoard;
                    }
                }
            }
        }

        return null;
    }

    private boolean[][] place(boolean[][] board, int i, int j) {
        int boardSize = board[0].length;
        boolean[][] newBoard = new boolean[boardSize][boardSize];

        for (int h = 0; h < boardSize; h++) {
            System.arraycopy(board[h], 0, newBoard[h], 0, boardSize);
        }

        newBoard[i][j] = true;

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
