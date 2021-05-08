
import domain.ChessBoard;
import domain.ChessBoardUtility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ChessBoardSimulator {
    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(ChessBoardSimulator.class.getName());
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        ChessBoard board = new ChessBoard();
        while(true) {
            try {
                System.out.println("Please enter next input values!");
                String inputs = reader.readLine();
                ChessBoardUtility.validateInput(inputs);
                board.getPossibleMoves(inputs);

            } catch (Exception e) {
                logger.severe("Error parsing input string.");
            }
        }
    }
}
