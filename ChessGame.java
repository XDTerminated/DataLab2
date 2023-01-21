public class ChessGame {
    private boolean rated;
    private int turns;
    private String victoryStatus;
    private String winner;
    private String incrementCode;
    private int whiteRating;
    private int blackRating;
    private String moves;
    private String openingName;

    public ChessGame(boolean rated, int turns, String victoryStatus, String winner, String incrementCode, int whiteRating, int blackRating, String moves, String openingName) {
        this.rated = rated;
        this.turns = turns;
        this.victoryStatus = victoryStatus;
        this.winner = winner;
        this.incrementCode = incrementCode;
        this.whiteRating = whiteRating;
        this.blackRating = blackRating;
        this.moves = moves;
        this.openingName = openingName;

    }

    // Getters
    public boolean getRated() {
        return this.rated;
    }

    public int getTurns() {
        return this.turns;
    }

    public String getVictoryStatus() {
        return this.victoryStatus;
    }

    public String getWinner() {
        return this.winner;
    }

    public String getIncrementCode() {
        return this.incrementCode;
    }

    public int getBlackRating() {
        return this.blackRating;
    }

    public int getWhiteRating() {
        return this.whiteRating;
    }

    public String getMoves() {
        return this.moves;
    }

    public String getOpeningName() {
        return this.openingName;
    }

    // Functions






}
