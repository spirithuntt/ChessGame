package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;
import java.util.ArrayList;
import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;
import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    public int getTheColor() {
        if (isWhite()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isValidMove(int row, int col, ArrayList<Move> validMoves) {
        int d = getTheColor();

        if (col == getCol() && row == getRow() + d) {
            return true;
        }
        if (isFirstMove && col == getCol() && row == getRow() + 2 * d) {
            System.out.println(isFirstMove);
            isFirstMove = false;
            return true;
        }
        if ((col - getCol() == 1 || col - getCol() == -1) && (row - getRow() == d)) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<Move> validMoves(Chessboard chessboard) {
        ArrayList<Move> validMoves = new ArrayList<>();
        int x = getCol();
        int y = getRow();
        int d = getTheColor();

        //1 step
        int nX = x;
        int nY = y + d;

        //if position is empty
        if (nX >= 0 && nX < 8 && nY >= 0 && nY < 8 && chessboard.getPiece(nX, nY) == null) {
            validMoves.add(new Move(chessboard.getPiece(nX, nY), nX, nY, null));
        }
        //2 steps
        if (isFirstMove) {
            int twoStepsX = x;
            int twoStepsY = y + 2 * d;
            //if 1st step is empty and second step is also empty
            if (twoStepsX >= 0 && twoStepsX < 8 && nY >= 0 && nY < 8 && chessboard.getPiece(twoStepsX, twoStepsY) == null && chessboard.getPiece(nX, nY) == null) {
                validMoves.add(new Move(chessboard.getPiece(twoStepsX, twoStepsY), twoStepsX, twoStepsY, null));
            }
        }
        //capture
        int [][]capture = {{x+1, y+d}, {x-1, y+d}};

        for (int []c : capture){
            if(c[0]>= 0 && c[0] < 8 && c[1]>= 0 && c[1] < 8){
                if (chessboard.getPiece(c[0], c[1]) != null && chessboard.getPiece(c[0] , c[1]).isWhite() != this.isWhite()) {
                    validMoves.add(new Move(this, c[0], c[1], chessboard.getPiece(c[0], c[1])));
                }
            }
        }


        return validMoves;
    }
}
