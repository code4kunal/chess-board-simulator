package domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChessBoardUtilityTest {

    @Test
    public void givenChessBoard_validInputs_findAllPossibleKingMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleKingMoves("3", "E");
        Assert.assertTrue(actualOutput.size()==8);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("D2", "F3", "E4")
                .collect(Collectors.toList())));

    }

    @Test
    public void givenChessBoard_validInputsAtEndOfChessBoard_findAllPossibleKingMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleKingMoves("1", "H");
        Assert.assertTrue(actualOutput.size()==3);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("G1", "G2", "H2")
                .collect(Collectors.toList())));

    }

    @Test
    public void givenChessBoard_validInputs_findAllPossibleQueenMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleQueenMoves("3", "E");
        Assert.assertTrue(actualOutput.size()==25);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("E2", "G1", "A7")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputsAtEndOfChessBoard_findAllPossibleQueenMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleQueenMoves("1", "H");
        Assert.assertTrue(actualOutput.size()==21);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("G1", "G2", "H2")
                .collect(Collectors.toList())));

    }

    @Test
    public void givenChessBoard_validInputs_findAllPossibleRookMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleRookMoves("3", "F");
        Assert.assertTrue(actualOutput.size()==11);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("D1", "G2", "A8")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputsAtEndOfChessBoard_findAllPossibleRookMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleRookMoves("8", "H");
        Assert.assertTrue(actualOutput.size()==7);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("A1", "D4", "G7")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputs_findAllPossibleBishopMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleBishopMoves("3", "G");
        Assert.assertTrue(actualOutput.size()==14);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("D3", "G2", "H3")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputsAtEndOfChessBoard_findAllPossibleBishopMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleBishopMoves("8", "H");
        Assert.assertTrue(actualOutput.size()==14);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("H1", "E8", "G8")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputs_findAllPossibleHorseMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleHorseMoves("3", "D");
        Assert.assertTrue(actualOutput.size()==8);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("E5", "C1", "F4")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputsAtEndOfChessBoard_findAllPossibleHorseMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossibleHorseMoves("1", "H");
        Assert.assertTrue(actualOutput.size()==2);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("G3", "F2")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputs_findAllPossiblePawnMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossiblePawnMoves("3", "B");
        Assert.assertTrue(actualOutput.size()==3);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("B4", "C4", "A4")
                .collect(Collectors.toList())));
    }

    @Test
    public void givenChessBoard_validInputsAtEndOfChessBoard_findAllPossiblePawnMoves(){
        List<String> actualOutput = ChessBoardUtility.getAllPossiblePawnMoves("8", "A");
        Assert.assertTrue(actualOutput.size()==2);
        Assert.assertTrue(actualOutput.containsAll(Stream.of("A9", "B9")
                .collect(Collectors.toList())));
    }



}
