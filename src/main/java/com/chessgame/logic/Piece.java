package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;
import java.util.ArrayList;

public abstract class Piece {
    private int row;
    private int col;
    private boolean isWhite;

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Piece(int row, int col, boolean isWhite) {
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }
    public abstract boolean isValidMove(int nRow, int nCol);

    public abstract ArrayList<Move> validMoves(Chessboard chessboard);

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isWhite() {
        return isWhite;
    }

}
