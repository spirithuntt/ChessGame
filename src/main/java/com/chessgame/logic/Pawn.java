package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;
import java.util.ArrayList;
import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;
import java.util.ArrayList;

public class Pawn extends Piece{
    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int row, int col, ArrayList<Move> validMoves){
        return true;
    }

    @Override
    public ArrayList<Move> validMoves(Chessboard chessboard){
        return null;
    }
}
