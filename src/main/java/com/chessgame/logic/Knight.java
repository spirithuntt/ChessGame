package com.chessgame.logic;

public class Knight extends Pawn{

    public Knight(int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public  boolean isValidMove(int row, int col)
    {
        return false;
    }
}
