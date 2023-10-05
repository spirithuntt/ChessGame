package com.chessgame.ui;

import com.chessgame.logic.Piece;
import com.chessgame.movement.Move;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Input {
    private int startCol;
    private int startRow;
    private Chessboard chessboard;
    private boolean isDragging = false;

    public Input(Chessboard chessboard) {
        this.chessboard = chessboard;
        //lambda expression for event handling
        chessboard.setOnMousePressed(event -> mousePressed(event));
        chessboard.setOnMouseReleased(event -> mouseReleased(event));
        chessboard.setOnMouseDragged(event -> mouseDragged(event));

    }
    private void mousePressed(MouseEvent event) {
        //get the square size and cast it to int
        //casting is converting one data type to another
        double x = event.getX();
        double y = event.getY();
        int col = (int) (x / chessboard.getSquareSize());
        int row = (int) (y / chessboard.getSquareSize());

        Piece piece = chessboard.getPiece(col, row);

        if (piece != null) {
            startCol = col;
            startRow = row;
            isDragging = true;

            ArrayList<Move> moves = piece.validMoves(chessboard);
            chessboard.highlightMoves(moves);
        }
        System.out.println("test valid moves");

    }

    private void mouseReleased(MouseEvent event) {
        if (isDragging) {
            double x = event.getX();
            double y = event.getY();
            int endCol = (int) (x / chessboard.getSquareSize());
            int endRow = (int) (y / chessboard.getSquareSize());

            //dragged and captured
            Piece dp = chessboard.getPiece(startCol, startRow);
            Piece cp = chessboard.getPiece(endCol, endRow);

            if (dp.isValidMove(endRow, endCol, dp.validMoves(chessboard))) {
                if (cp == null) {
                    dp.setRow(endRow);
                    dp.setCol(endCol);
                    chessboard.updatePieceView(startCol, startRow, endCol, endRow);
                } else {
                    if (!chessboard.sameTeam(dp, cp)) {
                        chessboard.capture(new Move(dp, endCol, endRow, cp));
                    }
                }
            } else {
                ImageView pieceView = chessboard.getPieceView(startCol, startRow);
                pieceView.setLayoutX(startCol * chessboard.getSquareSize());
                pieceView.setLayoutY(startRow * chessboard.getSquareSize());
            }

            isDragging = false;
            chessboard.removeHighlight();
        }

    }

    private void mouseDragged(MouseEvent event) {
        if (isDragging) {
            double x = event.getX();
            double y = event.getY();
            ImageView pieceView = chessboard.getPieceView(startCol, startRow);
            double size = chessboard.getSquareSize();
            double halfS = size / 2;
            pieceView.setLayoutX(x - halfS);
            pieceView.setLayoutY(y - halfS);
        }
    }
}
