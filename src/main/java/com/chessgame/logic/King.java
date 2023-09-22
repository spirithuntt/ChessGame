package com.chessgame.logic;

public class King extends Piece{
    public King(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return false;
    }
}
