package com.lucaszeta.gameoflife.model;

import java.util.Random;

public class GameModel {
    private int rows;
    private int columns;
    private boolean[][] map;

    public GameModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        initMap();
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isAlive(int row, int column) {
        if (isInBounds(row, column)) {
            return map[row][column];
        }

        return false;
    }

    public void heal(int row, int column) {
        if (isInBounds(row, column)) {
            map[row][column] = true;
        }
    }

    public void kill(int row, int column) {
        if (isInBounds(row, column)) {
            map[row][column] = false;
        }
    }

    public boolean willLive(int row, int column) {
        int neighboursAlive = getNeighboursAlive(row, column);

        if (neighboursAlive == 3) {
            return true;
        }

        return (isAlive(row, column) && neighboursAlive == 2);
    }

    private int getNeighboursAlive(int row, int column) {
        int neighboursAlive = 0;

        for (int i = row-1; i <= row + 1; ++i) {
            for (int j = column - 1; j <= column + 1; ++j) {
                if (isAlive(i, j) && !(row == i && column == j)) {
                    ++neighboursAlive;
                }
            }
        }

        return neighboursAlive;
    }

    private boolean isInBounds(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public void tick() {
        boolean[][] nextGeneration = new boolean[rows][columns];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                nextGeneration[i][j] = willLive(i, j);
            }
        }

        map = nextGeneration;
    }

    public void seed(int maxCells) {
        initMap();

        Random r = new Random();
        int cellsCount = 0;

        do {
            int row = r.nextInt(rows);
            int column = r.nextInt(columns);

            if (!isAlive(row, column)) {
                heal(row, column);
                cellsCount++;
            }
        } while (cellsCount < maxCells);
    }

    private void initMap() {
        map = new boolean[rows][columns];
    }
}
