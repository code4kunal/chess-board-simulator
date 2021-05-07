package domain;


import constant.ChessPiece;
import constant.InputToIndexMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ChessBoardUtility {

    static final Logger logger = Logger.getLogger(ChessBoardUtility.class.getName());

    public static List<String> getAllPossibleKingMoves(String rowIndex, String columnIndex){
       int rowIn = Integer.parseInt(rowIndex);
       int colIn = Integer.parseInt(columnIndex);
       List<String> moves = new ArrayList<>();
       for(rowIn = rowIn -1; rowIn < rowIn + 2; rowIn++){
           if(rowIn <1) continue;
           for(colIn = colIn-1; colIn < colIn +2; colIn++){
               if (colIn <1) continue;
              String move = InputToIndexMapping.valueOf(String.valueOf(colIn)).toString()+String.valueOf(rowIn);
              moves.add(move);
           }
       }
       return moves;
    }

    public static List<String> getAllPossibleQueenMoves(String rowIndex, String columnIndex){
        List<String> moves = new ArrayList<>();

        moves.addAll(getAllPossibleBishopMoves(rowIndex, columnIndex));
        moves.addAll(getAllPossibleRookMoves(rowIndex, columnIndex));

        return moves;
    }

    public static List<String> getAllPossibleBishopMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(columnIndex);
        String columnName  = InputToIndexMapping.valueOf(columnIndex).toString();
        List<String> moves = new ArrayList<>();

        //vertical moves
        for (int i=1; i<9; i++){
            moves.add(columnName+String.valueOf(i));
        }

        //horizontal Moves
        for(InputToIndexMapping index : InputToIndexMapping.values()){
            moves.add(index.toString()+rowIndex);
        }

        return moves;
    }

    public static List<String> getAllPossibleRookMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(columnIndex);
        List<String> moves = new ArrayList<>();

        // diagonal moves
        int indexSum = rowIn + colIn;
        int indexDiff = rowIn - colIn;
        for (int i=1; i<9;i++){
            for (int j=1; j<9; j++){
                if(i+j == indexSum || i-j == indexDiff){
                    moves.add(InputToIndexMapping.valueOf(columnIndex).toString()+String.valueOf(i));
                }

            }
        }

        return moves;
    }

    public static List<String> getAllPossibleHorseMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(columnIndex);
        List<String> moves = new ArrayList<>();

        // upward moves
        if(rowIn+2 < 9 && colIn + 1 < 9) {
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn + 1)).toString() + String.valueOf(rowIn + 2));
        }
        if(rowIn+2 < 9 && colIn - 1 < 0){
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn - 1)).toString() + String.valueOf(rowIn + 2));
        }

        // downward moves
        if(rowIn-2 > 0 && colIn + 1 < 9) {
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn + 1)).toString() + String.valueOf(rowIn - 2));
        }
        if(rowIn-2 > 0 && colIn - 1 < 0){
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn - 1)).toString() + String.valueOf(rowIn - 2));
        }

        // leftward moves
        if(colIn-2 > 0 && rowIn + 1 < 9 ) {
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn - 2)).toString() + String.valueOf(rowIn + 1));
        }
        if(colIn-2 > 0 && rowIn - 1 > 0 ) {
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn - 2)).toString() + String.valueOf(rowIn - 1));
        }

        // rightward moves
        if(colIn+2 < 9 && rowIn + 1 < 9 ) {
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn + 2)).toString() + String.valueOf(rowIn + 1));
        }
        if(colIn+2 < 9 && rowIn - 1 > 0 ) {
            moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn + 2)).toString() + String.valueOf(rowIn - 1));
        }
        return new ArrayList<>();
    }

    public static List<String> getAllPossiblePawnMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(columnIndex);
        String columnName  = InputToIndexMapping.valueOf(columnIndex).toString();
        List<String> moves = new ArrayList<>();

        //assuming forward direction is upwards, i.e incrementing row index
        moves.add(columnName+String.valueOf(rowIn+1));

        //diagnol moves, assuming forward direction is incrementing row index
        moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn+1)).toString()+String.valueOf(rowIn+1));
        moves.add(InputToIndexMapping.valueOf(String.valueOf(colIn-1)).toString()+String.valueOf(rowIn+1));
        return new ArrayList<>();
    }

    public static void validateInput(String input) {
        Boolean isValidPiece = Boolean.FALSE;
        Boolean isValidPieceRowIndex = Boolean.FALSE;
        Boolean isValidPieceColumnIndex = Boolean.FALSE;
        String[] inputArray = input.split(" ");

        if(inputArray.length < 2  &&  inputArray.length > 2){
            logger.info("Please provide valid input.");
        }

        for (ChessPiece chessPiece : ChessPiece.values()) {
            if(inputArray[0].equalsIgnoreCase(chessPiece.toString())){
                isValidPiece = true;
            }
        }

        if(!isValidPiece){
            logger.info("Please provide valid chess piece value.");
        }

        if(InputToIndexMapping.valueOf(String.valueOf(inputArray[1].charAt(0))) != null){
            isValidPieceColumnIndex= true;

        }

        if(!isValidPieceRowIndex){
            logger.info("Please provide valid column index.");
        }

        if(Integer.valueOf(inputArray[1].charAt(0))  > 7 && Integer.valueOf(inputArray[1].charAt(0)) < 0){
            isValidPieceRowIndex= false;
        }

        if(!isValidPieceColumnIndex){
            logger.info("Please provide valid row index.");
        }


    }

    public static ChessPiece findPieceValue(String piece) {
        for (ChessPiece chessPiece : ChessPiece.values()) {
            if(piece.equalsIgnoreCase(chessPiece.toString())){
                return chessPiece;
            }
        }
        return ChessPiece.KING;
    }
}
