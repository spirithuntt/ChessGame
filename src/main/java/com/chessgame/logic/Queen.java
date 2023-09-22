package com.chessgame.logic;

public class Queen extends Piece{
    public Queen(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return false;
    }
}
