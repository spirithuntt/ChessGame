package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King extends Piece{
    public King(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int nRow, int nCol) {
        System.out.println("you can move it ");
        return true;
    }
    @Override
    public ArrayList<Move> validMoves(Chessboard chessboard){
        ArrayList<Move> validMoves = new ArrayList<>();
        int x = getCol();
        int y = getRow();
        int [][]moves = {{x+1, y}, {x-1, y}, {x, y}, {x, y+1}, {x, y-1}, {x+1, y-1}, {x-1, y-1}, {x+1, y+1}, {x-1, y-1}, {x-1, y+1}};

        //to test
        for(int i = 0; i < moves.length; i++){
            System.out.println(Arrays.toString(moves[i]));
        }

        for(int []move : moves){
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
