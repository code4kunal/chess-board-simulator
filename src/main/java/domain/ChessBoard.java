package domain;

import constant.ChessPiece;
import constant.InputToIndexMapping;
import java.util.ArrayList;
import java.util.List;

import static domain.ChessBoardUtility.*;

public class ChessBoard implements IChessBoard{

    public ChessBoard(){}

    public void getPossibleMoves(String inputs) {
        ChessPiece piece = ChessBoardUtility.findPieceValue(inputs.split(" ")[0]);
        String indexes = inputs.split(" ")[1];
        String rowIndex = String.valueOf(indexes.charAt(0));
        String columnIndex = String.valueOf(indexes.charAt(1));
        List<String> possibleMoves = new ArrayList<>();

        switch (piece){
            case BISHOP:
                possibleMoves =  getAllPossibleBishopMoves(rowIndex, InputToIndexMapping.valueOf(columnIndex).toString());
                break;
            case KING:
                possibleMoves = getAllPossibleKingMoves(rowIndex, InputToIndexMapping.valueOf(columnIndex).toString());
                break;
            case QUEEN:
                possibleMoves = getAllPossibleQueenMoves(rowIndex, InputToIndexMapping.valueOf(columnIndex).toString());
                break;
            case ROOK:
                possibleMoves = getAllPossibleRookMoves(rowIndex, InputToIndexMapping.valueOf(columnIndex).toString() );
                break;
            case HORSE:
                possibleMoves = getAllPossibleHorseMoves(rowIndex, InputToIndexMapping.valueOf(columnIndex).toString());
                break;
            case PAWN:
                possibleMoves = getAllPossiblePawnMoves(rowIndex, InputToIndexMapping.valueOf(columnIndex).toString());
                break;
            default:
                logger.info("Chess piece not found");

        }
        possibleMoves.stream().forEach(System.out::print);
    }
}
