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
}
