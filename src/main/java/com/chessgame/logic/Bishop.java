package com.chessgame.logic;

public class Bishop extends Piece{

    public Bishop(int row, int col, boolean isWhite)
    {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int row, int col)
    {
        return false;
    }
}
