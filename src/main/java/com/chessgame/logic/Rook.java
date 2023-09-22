package com.chessgame.logic;

public class Rook extends Piece{

        public Rook(int row, int col, boolean isWhite)
        {
            super(row, col, isWhite);
        }

        @Override
        public boolean isValidMove(int row, int col)
        {
            return false;
        }
}
