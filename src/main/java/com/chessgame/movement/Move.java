package com.chessgame.movement;

import com.chessgame.logic.Piece;
import com.chessgame.ui.Chessboard;

public class Move {

    int oldRow;
    int oldCol;
    int newRow;
    int newCol;
    Piece piece;
    Piece capturedPiece;

    public Move(Chessboard Chessboard, Piece piece, int newCol, int newRow) {
        this.oldRow = piece.getRow();
        this.oldCol = piece.getCol();
        this.newRow = newRow;
        this.newCol = newCol;
        this.piece = piece;
        this.capturedPiece = Chessboard.getPiece(newRow, newCol);
    }
}
