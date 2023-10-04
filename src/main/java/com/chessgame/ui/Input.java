package com.chessgame.ui;

import com.chessgame.logic.Piece;
import com.chessgame.movement.Move;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

// This class is used to handle the click and drag event of the chess pieces
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
        //call the
        double mouseX = event.getX();
        double mouseY = event.getY();
        //(int) is casting to int type
        int col = (int) (mouseX / chessboard.getSquareSize());
        int row = (int) (mouseY / chessboard.getSquareSize());

        Piece PieceClicked = chessboard.getPiece(col, row);

        if (PieceClicked != null) {
            startCol = col;
            startRow = row;
            isDragging = true;


            ArrayList<Move> moves = PieceClicked.validMoves(chessboard);
                chessboard.highlightMoves(moves);
        }
        System.out.println("test valid moves");

    }

    private void mouseReleased(MouseEvent event) {
        if (isDragging) {
            double mouseX = event.getX();
            double mouseY = event.getY();
            //Casting to int type
            //get square size from chessboard to get the exact position of the piece
            int endCol = (int) (mouseX / chessboard.getSquareSize());
            int endRow = (int) (mouseY / chessboard.getSquareSize());

            Piece draggedPiece = chessboard.getPiece(startCol, startRow);
            Piece capturedPiece = chessboard.getPiece(endCol, endRow);

            if (draggedPiece.isValidMove(endRow, endCol, draggedPiece.validMoves(chessboard))) {
                //if there is no piece in the end position
                if(capturedPiece == null) {
                    draggedPiece.setRow(endRow);
                    draggedPiece.setCol(endCol);
                    chessboard.updatePieceView(startCol, startRow, endCol, endRow);
                }
                else{
                    //else there is a piece in the capturedPiece
                    if(!chessboard.sameTeam(draggedPiece, capturedPiece)){
                        chessboard.capture(new Move(draggedPiece, endCol, endRow, capturedPiece));

                    }
                }
            } else {
                ImageView dPieceView = chessboard.getPieceView(startCol, startRow);
                dPieceView.setLayoutX(startCol * chessboard.getSquareSize());
                dPieceView.setLayoutY(startRow * chessboard.getSquareSize());
            }

            isDragging = false;
            chessboard.removeHighlight();
        }
    }

    private void mouseDragged(MouseEvent event) {
        if (isDragging) {
            double mouseX = event.getX();
            double mouseY = event.getY();

            ImageView dPieceView = chessboard.getPieceView(startCol, startRow);

            double pieceSize = chessboard.getSquareSize();
            double offsetX = mouseX - pieceSize / 2;
            double offsetY = mouseY - pieceSize / 2;
            dPieceView.setLayoutX(offsetX);
            dPieceView.setLayoutY(offsetY);
        }
    }
}
