package domain;

import constant.ChessPiece;
import constant.ColIndexMapping;
import java.util.ArrayList;
import java.util.List;

import static domain.ChessBoardUtility.*;

/**
 *  This class implements a facade layer IChessBoard and implements a possible moves method.
 */
public class ChessBoard implements IChessBoard{

    public ChessBoard(){}

    public void getPossibleMoves(String inputs) {
        ChessPiece piece = ChessBoardUtility.findPieceValue(inputs.split(" ")[0]);
        String indexes = inputs.split(" ")[1];
        String rowIndex = String.valueOf(indexes.charAt(1));
        String columnIndex = String.valueOf(indexes.charAt(0));
        List<String> possibleMoves = new ArrayList<>();

        switch (piece){
            case BISHOP:
                possibleMoves =  getAllPossibleBishopMoves(rowIndex, ColIndexMapping.valueOf(columnIndex).toString());
                break;
            case KING:
                possibleMoves = getAllPossibleKingMoves(rowIndex, ColIndexMapping.valueOf(columnIndex).toString());
                break;
            case QUEEN:
                possibleMoves = getAllPossibleQueenMoves(rowIndex, ColIndexMapping.valueOf(columnIndex).toString());
                break;
            case ROOK:
                possibleMoves = getAllPossibleRookMoves(rowIndex, ColIndexMapping.valueOf(columnIndex).toString() );
                break;
            case HORSE:
                possibleMoves = getAllPossibleHorseMoves(rowIndex, ColIndexMapping.valueOf(columnIndex).toString());
                break;
            case PAWN:
                possibleMoves = getAllPossiblePawnMoves(rowIndex, ColIndexMapping.valueOf(columnIndex).toString());
                break;
            default:
                logger.info("Chess piece not found");

        }
        System.out.println("All possible moves are :-");
        for (String possibleMove : possibleMoves) {
            System.out.print(possibleMove+ " \t");
        }
        System.out.println("\n");
    }
}
