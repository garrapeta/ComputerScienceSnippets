package com.garrapeta.alg.queens;

import java.util.Set;

import org.junit.Test;

public class QueensTest {

    @Test
    public void queens_4_returns_solution() {
        Queens queens = new Queens();
        Set<boolean[][]> sols = queens.solve(4);
        print(sols);
    }

    @Test
    public void queens_8_returns_solution() {
        Queens queens = new Queens();
        Set<boolean[][]> sols = queens.solve(8);
        print(sols);
    }

    // TODO: check solution

    // private boolean isSolution(boolean[][] board) {
    // int placements = 0;
    // int boardSize = board[0].length;
    // for (int i = 0; i < boardSize; i++) {
    // for (int j = 0; j < boardSize; j++) {
    // if (board[i][j]) {
    // if (Queens.isAllowed(board, i, j)) {
    // placements++;
    // } else {
    // return false;
    // }
    // }
    // }
    // }
    // return placements == boardSize;
    // }

    public static void print(Set<boolean[][]> sols) {
        for (boolean[][] board : sols) {
            print(board);
        }
    }

    private static void print(boolean[][] board) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
   
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] ? "X" : ".");
            }
            System.out.println();
        }
    }

}
