package com.chessgame.ui;

import com.chessgame.logic.*;
import com.chessgame.movement.Move;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.collections.ObservableList;
import com.chessgame.logic.Piece;

import java.net.URL;
import java.util.ArrayList;

// This class is used to draw the chessboard and put the pieces on it
public class Chessboard extends GridPane {

    private double squareSize;
    private ArrayList<Piece> piecesList = new ArrayList<>();

    private ArrayList<Move> validMoves = new ArrayList<>();

    private ArrayList<Rectangle> highlights = new ArrayList<>();

    @Override
    public String toString() {
        return "Chessboard{" +
                "squareSize=" + squareSize +
                ", piecesList=" + piecesList +
                ", validMoves=" + validMoves +
                ", highlights=" + highlights +
                '}';
    }


    //getter
    public double getSquareSize() {
        return squareSize;
    }
    public ArrayList<Piece> getPiecesList() {
        return piecesList;
    }

    public Chessboard(double squareSize) {
        this.squareSize = squareSize;
        drawBoard();
        putPieces();

    }
    public ImageView getPieceView(int col, int row) {
        for (Node node : getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                if (node instanceof ImageView) {
                    return (ImageView) node;
                }
            }
        }
        return null;
    }
    
    public void updatePieceView(int startCol, int startRow, int endCol, int endRow) {
        ImageView pieceView = getPieceView(startCol, startRow);
        if (pieceView != null) {
            pieceView.setLayoutX(endCol * squareSize);
            pieceView.setLayoutY(endRow * squareSize);
            clearPiece(startCol, startRow);
            add(pieceView, endCol, endRow);
        }
    }
    public void clearPiece(int col, int row) {
        ObservableList<Node> children = getChildren();
        for (Node node : children) {
            if (node instanceof ImageView) {
                if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                    children.remove(node);
                    break;
                }
            }
        }
    }

    public void capture(Move move){
        //CHECK THE TYPE OF THE CAPTURED PIECE IF ITS A KING CLASS
        //instanceof in Java is used to check if the specified object is an instance of a class, subclass, or interface
        if(move.getCapturedPiece() instanceof King){
            System.out.println("game over hh");
            System.exit(0);
        }
        Piece capturedPiece = move.getCapturedPiece();
        if(capturedPiece != null){
            piecesList.remove(capturedPiece);
            clearPiece(capturedPiece.getCol(), capturedPiece.getRow());
            move.getPiece().setRow(move.getNewRow());
            move.getPiece().setCol(move.getNewCol());
            updatePieceView(move.getOldCol(), move.getOldRow(), move.getNewCol(), move.getNewRow());
        }
    }

    public boolean sameTeam(Piece p1, Piece p2){
        if(p1 == null || p2 == null){
            return false;
        }
        return p1.isWhite() == p2.isWhite();
    }




    //put pieces on the board
    public void putPieces(){
        //white pieces
        //pawns
        Piece whitePawn1 = new Pawn(1, 0, true, this);
        piecesList.add(whitePawn1);
        addPiece(whitePawn1.getRow(), whitePawn1.getCol(), "pawn", whitePawn1.isWhite());
        Piece whitePawn2 = new Pawn(1, 1, true, this);
        piecesList.add(whitePawn2);
        addPiece(whitePawn2.getRow(), whitePawn2.getCol(), "pawn", whitePawn2.isWhite());
        Piece whitePawn3 = new Pawn(1, 2, true, this);
        piecesList.add(whitePawn3);
        addPiece(whitePawn3.getRow(), whitePawn3.getCol(), "pawn", whitePawn3.isWhite());
        Piece whitePawn4 = new Pawn(1, 3, true, this);
        piecesList.add(whitePawn4);
        addPiece(whitePawn4.getRow(), whitePawn4.getCol(), "pawn", whitePawn4.isWhite());
        Piece whitePawn5 = new Pawn(1, 4, true, this);
        piecesList.add(whitePawn5);
        addPiece(whitePawn5.getRow(), whitePawn5.getCol(), "pawn", whitePawn5.isWhite());
        Piece whitePawn6 = new Pawn(1, 5, true, this);
        piecesList.add(whitePawn6);
        addPiece(whitePawn6.getRow(), whitePawn6.getCol(), "pawn", whitePawn6.isWhite());
        Piece whitePawn7 = new Pawn(1, 6, true, this);
        piecesList.add(whitePawn7);
        addPiece(whitePawn7.getRow(), whitePawn7.getCol(), "pawn", whitePawn7.isWhite());
        Piece whitePawn8 = new Pawn(1, 7, true, this);
        piecesList.add(whitePawn8);
        addPiece(whitePawn8.getRow(), whitePawn8.getCol(), "pawn", whitePawn8.isWhite());

        //Bishops
        Piece whiteBishop1 = new Bishop(0, 2, true);
        piecesList.add(whiteBishop1);
        addPiece(whiteBishop1.getRow(), whiteBishop1.getCol(), "bishop", whiteBishop1.isWhite());
        Piece whiteBishop2 = new Bishop(0, 5, true);
        piecesList.add(whiteBishop2);
        addPiece(whiteBishop2.getRow(), whiteBishop2.getCol(), "bishop", whiteBishop2.isWhite());

        //king
        Piece whiteKing = new King(0, 4, true);
        piecesList.add(whiteKing);
        addPiece(whiteKing.getRow(), whiteKing.getCol(), "king", whiteKing.isWhite());

        //knights
        Piece whiteKnight1 = new Knight(0, 1, true);
        piecesList.add(whiteKnight1);
        addPiece(whiteKnight1.getRow(), whiteKnight1.getCol(), "knight", whiteKnight1.isWhite());
        Piece whiteKnight2 = new Knight(0, 6, true);
        piecesList.add(whiteKnight2);
        addPiece(whiteKnight2.getRow(), whiteKnight2.getCol(), "knight", whiteKnight2.isWhite());

        //queen
        Piece whiteQueen = new Queen(0, 3, true);
        piecesList.add(whiteQueen);
        addPiece(whiteQueen.getRow(), whiteQueen.getCol(), "queen", whiteQueen.isWhite());

        //rooks
        Piece whiteRook1 = new Rook(0, 0, true);
        piecesList.add(whiteRook1);
        addPiece(whiteRook1.getRow(), whiteRook1.getCol(), "rook", whiteRook1.isWhite());
        Piece whiteRook2 = new Rook(0, 7, true);
        piecesList.add(whiteRook2);
        addPiece(whiteRook2.getRow(), whiteRook2.getCol(), "rook", whiteRook2.isWhite());


        //black pieces

        //pawns
        Piece blackPawn1 = new Pawn(6, 0, false, this);
        piecesList.add(blackPawn1);
        addPiece(blackPawn1.getRow(), blackPawn1.getCol(), "pawn", blackPawn1.isWhite());
        Piece blackPawn2 = new Pawn(6, 1, false, this);
        piecesList.add(blackPawn2);
        addPiece(blackPawn2.getRow(), blackPawn2.getCol(), "pawn", blackPawn2.isWhite());
        Piece blackPawn3 = new Pawn(6, 2, false, this);
        piecesList.add(blackPawn3);
        addPiece(blackPawn3.getRow(), blackPawn3.getCol(), "pawn", blackPawn3.isWhite());
        Piece blackPawn4 = new Pawn(6, 3, false, this);
        piecesList.add(blackPawn4);
        addPiece(blackPawn4.getRow(), blackPawn4.getCol(), "pawn", blackPawn4.isWhite());
        Piece blackPawn5 = new Pawn(6, 4, false, this);
        piecesList.add(blackPawn5);
        addPiece(blackPawn5.getRow(), blackPawn5.getCol(), "pawn", blackPawn5.isWhite());
        Piece blackPawn6 = new Pawn(6, 5, false, this);
        piecesList.add(blackPawn6);
        addPiece(blackPawn6.getRow(), blackPawn6.getCol(), "pawn", blackPawn6.isWhite());
        Piece blackPawn7 = new Pawn(6, 6, false, this);
        piecesList.add(blackPawn7);
        addPiece(blackPawn7.getRow(), blackPawn7.getCol(), "pawn", blackPawn7.isWhite());
        Piece blackPawn8 = new Pawn(6, 7, false, this);
        piecesList.add(blackPawn8);
        addPiece(blackPawn8.getRow(), blackPawn8.getCol(), "pawn", blackPawn8.isWhite());

        //Bishops
        Piece blackBishop1 = new Bishop(7, 2, false);
        piecesList.add(blackBishop1);
        addPiece(blackBishop1.getRow(), blackBishop1.getCol(), "bishop", blackBishop1.isWhite());
        Piece blackBishop2 = new Bishop(7, 5, false);
        piecesList.add(blackBishop2);
        addPiece(blackBishop2.getRow(), blackBishop2.getCol(), "bishop", blackBishop2.isWhite());

        //king
        Piece blackKing = new King(7, 4, false);
        piecesList.add(blackKing);
        addPiece(blackKing.getRow(), blackKing.getCol(), "king", blackKing.isWhite());

        //knights
        Piece blackKnight1 = new Knight(7, 1, false);
        piecesList.add(blackKnight1);
        addPiece(blackKnight1.getRow(), blackKnight1.getCol(), "knight", blackKnight1.isWhite());
        Piece blackKnight2 = new Knight(7, 6, false);
        piecesList.add(blackKnight2);
        addPiece(blackKnight2.getRow(), blackKnight2.getCol(), "knight", blackKnight2.isWhite());

        //queen
        Piece blackQueen = new Queen(7, 3, false);
        piecesList.add(blackQueen);
        addPiece(blackQueen.getRow(), blackQueen.getCol(), "queen", blackQueen.isWhite());

        //rooks
        Piece blackRook1 = new Rook(7, 0, false);
        piecesList.add(blackRook1);
        addPiece(blackRook1.getRow(), blackRook1.getCol(), "rook", blackRook1.isWhite());
        Piece blackRook2 = new Rook(7, 7, false);
        piecesList.add(blackRook2);
        addPiece(blackRook2.getRow(), blackRook2.getCol(), "rook", blackRook2.isWhite());
    }


    public Piece getPiece(int col, int row){
        for (Piece piece : piecesList){
            if(piece.getCol() == col && piece.getRow() == row) {
                return piece;
            }
        }
        return null;
    }

    public void drawBoard(){
        int size = 8;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Rectangle r = new Rectangle();
                r.setWidth(squareSize);
                r.setHeight(squareSize);
                if ((row + column) % 2 == 0) {
                    r.setFill(Color.SEASHELL);
                } else {
                    r.setFill(Color.SIENNA);
                }
                add(r, column, row);
            }
        }
    }

    public void addPiece(int row,int col, String piece, boolean isWhite){

        String color = isWhite ? "white" : "black";

        String pieceName = color + "-" + piece + ".png";

        Image pieceIcon = null;
        try {

            URL url = ClassLoader.getSystemClassLoader().getResource(pieceName);
            if(url != null) {
                pieceIcon = new Image(url.openStream());
            }
            else {
                System.out.println("error piece img not found");
            }

        } catch (Exception e) {
            System.out.println("Error loading piece icon " + e.getMessage());
        }

        if (pieceIcon != null) {
            ImageView pieceView = new ImageView(pieceIcon);

            pieceView.setFitWidth(squareSize);
            pieceView.setFitHeight(squareSize);

            add(pieceView, col, row);
        }
    }
    public void highlightMoves(ArrayList<Move> moves) {
        for (Move m : moves) {
            int r = m.getNewRow();
            int c = m.getNewCol();
            System.out.println("highlighting " + r + " " + c);
            Rectangle h = new Rectangle();
            h.setWidth(squareSize);
            h.setHeight(squareSize);
            h.setFill(Color.color(0, 1, 0, 0.5));

            highlights.add(h);
            add(h, c, r);
        }
    }

    public void removeHighlight() {
        for (Rectangle h : highlights) {
            getChildren().remove(h);
        }
        highlights.clear();
    }

    public void promotePawn(Pawn pawn, int row, int col){
        boolean isWhite = pawn.isWhite();
        piecesList.remove(pawn);
        clearPiece(pawn.getCol(), pawn.getRow());
        Piece queen = new Queen(row, col, isWhite);
        piecesList.add(queen);
        addPiece(queen.getRow(), queen.getCol(), "queen", queen.isWhite());
    }
}