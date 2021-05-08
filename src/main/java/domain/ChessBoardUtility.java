package domain;


import constant.ChessPiece;
import constant.ColIndexMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ChessBoardUtility {

    static final Logger logger = Logger.getLogger(ChessBoardUtility.class.getName());

    /**
     * Method to find out all possible moves for KING in chess based on given
     * row and column indexes.
     *
     * @param rowIndex
     * @param columnIndex
     * @return List of all possible moves for King in chess game.
     */
    public static List<String> getAllPossibleKingMoves(String rowIndex, String columnIndex){
       int rowIn = Integer.parseInt(rowIndex);
       int colIn = Integer.parseInt(ColIndexMapping.valueOf(columnIndex).getIndex());
       List<String> moves = new ArrayList<>();
       for(int row = rowIn -1; row < rowIn + 2; row++){
           if(row <1) continue;
           for(int col = colIn-1; col < colIn +2; col++){
               if (col < 1) continue;
               String move = ChessBoardUtility.findColFromIndex(String.valueOf(col))+String.valueOf(row);
               if(!move.equalsIgnoreCase(columnIndex+rowIndex)) {
                   moves.add(move);
               }
           }
       }
       return moves;
    }

    /**
     * Method to find out all possible moves for QUEEN in chess based on given
     * row and column indexes.
     *
     * @param rowIndex
     * @param columnIndex
     * @return List of all possible moves for QUEEN in chess game.
     */
    public static List<String> getAllPossibleQueenMoves(String rowIndex, String columnIndex){
        List<String> moves = new ArrayList<>();

        moves.addAll(getAllPossibleBishopMoves(rowIndex, columnIndex));
        moves.addAll(getAllPossibleRookMoves(rowIndex, columnIndex));

        return moves;
    }

    /**
     * Method to find out all possible moves for BISHOP in chess based on given
     * row and column indexes.
     *
     * @param rowIndex
     * @param columnIndex
     * @return List of all possible moves for BISHOP in chess game.
     */
    public static List<String> getAllPossibleBishopMoves(String rowIndex, String columnIndex){
        String columnName  = ColIndexMapping.valueOf(columnIndex).toString();
        List<String> moves = new ArrayList<>();

        //vertical moves
        for (int i=1; i<9; i++){
            String move = columnName+String.valueOf(i);
            if(!move.equalsIgnoreCase(columnIndex+rowIndex)) {
                moves.add(move);
            }
        }

        //horizontal Moves
        for(ColIndexMapping index : ColIndexMapping.values()){
            String move = index.toString()+rowIndex;
            if(!move.equalsIgnoreCase(columnIndex+rowIndex)) {
                moves.add(move);
            }
        }

        return moves;
    }

    /**
     * Method to find out all possible moves for ROOK in chess based on given
     * row and column indexes.
     *
     * @param rowIndex
     * @param columnIndex
     * @return List of all possible moves for ROOK in chess game.
     */
    public static List<String> getAllPossibleRookMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(ColIndexMapping.valueOf(columnIndex).getIndex());
        List<String> moves = new ArrayList<>();

        // diagonal moves
        int indexSum = rowIn + colIn;
        int indexDiff = rowIn - colIn;
        for (int i=1; i<9;i++){
            for (int j=1; j<9; j++){
                if(i+j == indexSum || i-j == indexDiff){
                    String move =  ChessBoardUtility.findColFromIndex(String.valueOf(j)).toString()+String.valueOf(i);
                    if(!move.equalsIgnoreCase(columnIndex+rowIndex)) {
                        moves.add(move);
                    }
                }
            }
        }

        return moves;
    }

    /**
     * Method to find out all possible moves for HORSE in chess based on given
     * row and column indexes.
     *
     * @param rowIndex
     * @param columnIndex
     * @return List of all possible moves for HORSE in chess game.
     */
    public static List<String> getAllPossibleHorseMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(ColIndexMapping.valueOf(columnIndex).getIndex());
        List<String> moves = new ArrayList<>();

        // upward moves
        if(rowIn+2 < 9 && colIn + 1 < 9) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn + 1)).toString() + String.valueOf(rowIn + 2));
        }
        if(rowIn+2 < 9 && colIn - 1 > 0){
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn - 1)).toString()+ String.valueOf(rowIn + 2));
        }

        // downward moves
        if(rowIn-2 > 0 && colIn + 1 < 9) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn + 1)).toString()+ String.valueOf(rowIn - 2));
        }
        if(rowIn-2 > 0 && colIn - 1 > 0){
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn - 1)).toString() + String.valueOf(rowIn - 2));
        }

        // leftward moves
        if(colIn-2 > 0 && rowIn + 1 < 9 ) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn - 2)).toString() + String.valueOf(rowIn + 1));
        }
        if(colIn-2 > 0 && rowIn - 1 > 0 ) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn - 2)).toString()+ String.valueOf(rowIn - 1));
        }

        // rightward moves
        if(colIn+2 < 9 && rowIn + 1 < 9 ) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn + 2)).toString() + String.valueOf(rowIn + 1));
        }
        if(colIn+2 < 9 && rowIn - 1 > 0 ) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn + 2)).toString() + String.valueOf(rowIn - 1));
        }
        return moves;
    }

    /**
     * Method to find out all possible moves for PAWN in chess based on given
     * row and column indexes.
     *
     * @param rowIndex
     * @param columnIndex
     * @return List of all possible moves for PAWN in chess game.
     */
    public static List<String> getAllPossiblePawnMoves(String rowIndex, String columnIndex){
        int rowIn = Integer.parseInt(rowIndex);
        int colIn = Integer.parseInt(ColIndexMapping.valueOf(columnIndex).getIndex());
        String columnName  = ColIndexMapping.valueOf(columnIndex).toString();
        List<String> moves = new ArrayList<>();

        //assuming forward direction is upwards, i.e incrementing row index
        moves.add(columnName+String.valueOf(rowIn+1));

        //diagnol moves, assuming forward direction is incrementing row index
        if(colIn + 1 < 9) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn + 1)).toString() + String.valueOf(rowIn + 1));
        }
        if(colIn - 1 > 0) {
            moves.add(ChessBoardUtility.findColFromIndex(String.valueOf(colIn - 1)).toString() + String.valueOf(rowIn + 1));
        }
        return moves;
    }

    /**
     * Method to validate input string.
     * @param input
     */
    public static void validateInput(String input) {
        Boolean isValidPiece = Boolean.FALSE;
        Boolean isValidPieceRowIndex = Boolean.TRUE;
        Boolean isValidPieceColumnIndex = Boolean.FALSE;
        String[] inputArray = input.split(" ");

        if(inputArray.length < 2  &&  inputArray.length > 2){
            logger.info("Please provide valid input.");
        }

        for (ChessPiece chessPiece : ChessPiece.values()) {
            if(inputArray[0].equalsIgnoreCase(chessPiece.toString())){
                isValidPiece = true;
                break;
            }
        }

        if(!isValidPiece){
            logger.info("Please provide valid chess piece value.");
        }

        if(inputArray[1].toCharArray().length>2){
            logger.info("Please provide valid input.");
        }

        if(ColIndexMapping.valueOf(String.valueOf(inputArray[1].charAt(0))) != null){
            isValidPieceColumnIndex= true;
        }

        if(!isValidPieceColumnIndex){
            logger.info("Please provide valid column index.");
        }


        if(Integer.valueOf(inputArray[1].charAt(1))  > 7 && Integer.valueOf(inputArray[1].charAt(1)) < 0){
            isValidPieceRowIndex= false;
        }

        if(!isValidPieceRowIndex){
            logger.info("Please provide valid row index.");
        }
    }

    /**
     * Method to evaluate ChessPiece Enum Constant from String value.
     * @param piece
     * @return
     */
    public static ChessPiece findPieceValue(String piece) {
        for (ChessPiece chessPiece : ChessPiece.values()) {
            if(piece.equalsIgnoreCase(chessPiece.toString())){
                return chessPiece;
            }
        }
        return ChessPiece.KING;
    }

    /**
     *  Method to return ColMappingConstant from index value.
     * @param index
     * @return
     */
    public static ColIndexMapping findColFromIndex(String index) {
        for (ColIndexMapping cols : ColIndexMapping.values()) {
            if(index.equalsIgnoreCase(ColIndexMapping.valueOf(cols.toString()).getIndex())){
                return cols;
            }
        }
        return ColIndexMapping.A;
    }
}
