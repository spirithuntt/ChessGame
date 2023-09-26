package com.chessgame.movement;

import com.chessgame.logic.Piece;
import com.chessgame.ui.Chessboard;

// This class is used to store the information of a move
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

    public Move(Piece piece, int newCol, int newRow, Piece capturedPiece) {
        this.oldRow = piece.getRow();
        this.oldCol = piece.getCol();
        this.newRow = newRow;
        this.newCol = newCol;
        this.piece = piece;
        this.capturedPiece = capturedPiece;
    }
}
