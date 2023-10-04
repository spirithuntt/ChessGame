package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Pawn{

    public Knight(int row, int col, boolean isWhite){
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int nRow, int nCol, ArrayList<Move> validMoves)
    {
        int x = nRow;
        int y = nCol;
        for (Move move : validMoves){
            if (move.getNewRow() == x && move.getNewCol() == y){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Move> validMoves(Chessboard chessboard){
        ArrayList<Move> validMoves = new ArrayList<>();
        int x = getCol();
        int y = getRow();

        int [][] moves = {{2+x, y+1}, {x+1 , y+2}, {x-1, y+2}, {x-2, y+1}, {x-1, y-2}, {x+1, y+2}, {x-2, y+1}, {x+1, y-2}, {x+2, y-1}, {x-2, y-1}};

        for (int[] move : moves) {
            if(move[0] >= 0 && move[0] < 8 && move[1] >= 0 && move[1] < 8){
                if(chessboard.getPiece(move[0] , move[1]) == null){
                    validMoves.add(new Move(chessboard.getPiece(move[0],move[1]), move[0],move[1], null));
                }
                else
                if(chessboard.getPiece(move[0] , move[1]).isWhite() != this.isWhite()){
                    validMoves.add(new Move(this,move[0],move[1],chessboard.getPiece(move[0],move[1])));
                }

            }
        }
        return validMoves;
    }
}
