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

    public Move(int row, int col, int newCol, int col1) {
    }


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

    public Move(Chessboard Chessboard, Piece piece, int newCol, int newRow) {
        this.oldRow = piece.getRow();
        this.oldCol = piece.getCol();
        this.newRow = newRow;
        this.newCol = newCol;
        this.piece = piece;
        this.capturedPiece = Chessboard.getPiece(newRow, newCol);
    }
}
