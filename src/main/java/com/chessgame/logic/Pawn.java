package com.chessgame.logic;

public class Pawn extends Piece{
    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return true;
    }
}
