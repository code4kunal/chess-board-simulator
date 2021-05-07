package domain;

import constant.ChessPiece;

import java.util.List;

public interface IChessBoard {

    List<String> getPossibleMoves(ChessPiece chessPiece, int rowIndex, int columnIndex );

}
