package com.chessgame.logic;

import com.chessgame.movement.Move;
import com.chessgame.ui.Chessboard;
import java.util.ArrayList;
import java.util.Arrays;

public class Rook extends Piece {

    public Rook(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    @Override
    public boolean isValidMove(int nRow, int nCol) {
        return true;
    }

    @Override
    public ArrayList<Move> validMoves(Chessboard chessboard) {
        ArrayList<Move> validMoves = new ArrayList<>();
        int x = getCol();
        int y = getRow();

        int[][] moves = {{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};

        for (int[] move : moves) {
            int dx = move[0];
            int dy = move[1];
            System.out.println("1-----------");
            System.out.println("dx : " + dx);
            System.out.println("dy : " + dy);

            while (dx >= 0 && dx < 8 && dy >= 0 && dy < 8) {
                if (chessboard.getPiece(dx, dy) == null) {
                    validMoves.add(new Move(chessboard.getPiece(dx, dy), dx, dy, null));
                } else if (chessboard.getPiece(dx, dy).isWhite() != this.isWhite()) {
                    validMoves.add(new Move(this, dx, dy, chessboard.getPiece(dx, dy)));
                    break;
                } else {
                    break;
                }
                System.out.println();
                dx += move[0] - x;
                dy += move[1] - y;
                System.out.println("2-----------");
                System.out.println("dx : " + dx);
                System.out.println("dy : " + dy);
            }
            System.out.println("3-----------");
            System.out.println("dx : " + dx);
            System.out.println("dy : " + dy);
        }

        return validMoves;
    }
}

