package com.lucaszeta.gameoflife.model;

public class GameModel {
    private int rows;
    private int columns;
    private boolean[][] map;

    public GameModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        map = new boolean[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isAlive(int row, int column) {
        return map[row][column];
    }

    public void heal(int row, int column) {
        map[row][column] = true;
    }

    public void kill(int row, int column) {
        map[row][column] = false;
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

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (Math.abs(row - i) <= 1 && Math.abs(column - j) <= 1) {
                    if (isAlive(i, j) && !(row == i && column == j)) {
                        ++neighboursAlive;
                    }
                }
            }
        }

        return neighboursAlive;
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
}
