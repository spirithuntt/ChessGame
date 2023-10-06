package com.chessgame.movement;

import com.chessgame.logic.Pawn;
import com.chessgame.logic.Piece;
import com.chessgame.ui.Chessboard;

public class Move {

    int oldRow;
    int oldCol;
    int newRow;
    int newCol;
    Piece piece;

    Piece capturedPiece;



    //getters
    public int getOldRow() {
        return oldRow;
    }

    public int getOldCol() {
        return oldCol;
    }

    public int getNewRow() {
        return newRow;
    }

    public int getNewCol() {
        return newCol;
    }

    public Piece getPiece() {
        return piece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    //constructor
    public Move(Piece piece, int newCol, int newRow, Piece capturedPiece) {
        this.piece = piece;
        this.newCol = newCol;
        this.newRow = newRow;
        this.capturedPiece = capturedPiece;
        if(piece != null){
            this.oldCol = piece.getCol();
            this.oldRow = piece.getRow();
        }
    }
}
