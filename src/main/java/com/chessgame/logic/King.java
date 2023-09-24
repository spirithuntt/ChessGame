package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;

import java.util.ArrayList;

public class King extends Piece{
    public King(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int nRow, int nCol) {
        return false;
    }
    @Override
    public ArrayList<Move> validMoves(Chessboard chessboard){
        return null;
    }
}
