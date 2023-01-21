import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import core.data.*;


public class Main {
    public static void main(String[] args) {
        DataSource chessGames = DataSource.connect("/workspace/DataLab2/games.xml");
        chessGames.setCacheTimeout(15*60);
        chessGames.load();
        // chessGames.printUsageString();

        ArrayList<ChessGame> allGames =  chessGames.fetchList("ChessGame", "row/rated", "row/turns", "row/victory_status", "row/winner", "row/increment_code", "row/white_rating", "row/black_rating", "row/moves", "row/opening_name");

        // Variables to store found data
        int winCountWhite = 0;
        int winCountBlack = 0;
        int winCountDraw = 0;
        int resign = 0;
        int outOfTime = 0;
        int mate = 0;

        // Array List to store all the openings used
        ArrayList<String> openings = new ArrayList<>();

        // Iterates through all the games and stores all of the necessary data in appropiate variables.
        for (ChessGame g: allGames) {
            openings.add(g.getOpeningName());
            if (g.getVictoryStatus().equals("outoftime")) {
                outOfTime++;
            } else if (g.getVictoryStatus().equals("mate")) {
                mate++;
            } else if (g.getVictoryStatus().equals("resign")) {
                resign++;
            }

            if (g.getWinner().equals("white")) {
                winCountWhite++;
            } else if (g.getWinner().equals("black")) {
                winCountBlack++;
            } else {
                winCountDraw++;
            }
        }




        System.out.println("\n\nHow commonly an opening was used: ");

        // Converts openings to set to find the set of the openings used
        Set<String> openings2 = new HashSet<String>(openings);
        String mostUsed = "";
        int times = 0;

        for (String s: openings2) {
            System.out.println(s + ": " + Collections.frequency(openings, s));
            if (Collections.frequency(openings, s) > times) {
                times = Collections.frequency(openings, s);
                mostUsed = s;
            }
        }

        // Prints out all the data found
        System.out.println("\n\n\n Most Used Chess Opening: \n\t" + mostUsed + ": " + times);


        System.out.print("In all the chess games that were played that were rated (" + allGames.size() + "), ");
        System.out.print("white won " + winCountWhite + " games, black won " + winCountBlack + ", and the rest of the " + winCountDraw + " games ended in a draw.\n\n");

        System.out.println("How did losses occur: ");
        System.out.println("\tResignation: " + resign);
        System.out.println("\tCheckmate: " + mate);
        System.out.println("\tOut of time: " + outOfTime);


        
    }
}