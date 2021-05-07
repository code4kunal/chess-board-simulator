package domain;

import constant.ChessPiece;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChessBoard implements IChessBoard{

    private int rowIndex;
    private int columnIndex;
    private ChessPiece piece;

    public List<String> getPossibleMoves(ChessPiece chessPiece, int rowIndex, int columnIndex) {
        return new ArrayList<String>();
    }
}
