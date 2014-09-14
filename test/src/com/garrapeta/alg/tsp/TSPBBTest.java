package com.garrapeta.alg.tsp;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TSPBBTest {

    int[][] matrix = createAdjacencyMatrix();

    @Test
    public void algorithm_returns_optimum_solution() {

        TSVBB tsvbb = new TSVBB();
        int[] solution = tsvbb.solve(matrix);
        assertSolution(solution);
    }

    private void assertSolution(int[] solution) {
        Set<Integer> visitted = new HashSet<Integer>();
        int cityCount = matrix[0].length;

        int cost = 0;

        for (int i = 0; i < cityCount; i++) {
            if (i < cityCount - 1) {
                int thisCity = solution[i];
                int nexcCity = solution[i + 1];
                int thisCost = matrix[thisCity][nexcCity];
                cost += thisCost;
            }
            visitted.add(i);
        }

        assertEquals("All cities visited", cityCount, visitted.size());
        assertEquals("Cost is minimum", 43, cost);
    }

    /**
     * @return the adjacency matrix for this problem:
     *         https://www.youtube.com/watch?v=BmsC6AEbkrw
     */
    private int[][] createAdjacencyMatrix() {
        int[][] m = {
                {
                        0,
                        16,
                        Integer.MAX_VALUE,
                        14,
                        22 },
                {
                        16,
                        0,
                        18,
                        Integer.MAX_VALUE,
                        4 },
                {
                        Integer.MAX_VALUE,
                        18,
                        0,
                        19,
                        23 },
                {
                        14,
                        Integer.MAX_VALUE,
                        19,
                        0,
                        7 },
                {
                        22,
                        4,
                        23,
                        7,
                        0 } };
        ;

        return m;
    }

}
