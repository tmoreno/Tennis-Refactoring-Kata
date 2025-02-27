
public class TennisGame1 implements TennisGame {
    
    private int pointsPlayer1;
    private int pointsPlayer2;

    public TennisGame1() {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            pointsPlayer1 += 1;
        }
        else {
            pointsPlayer2 += 1;
        }
    }

    public String getScore() {
        if (isDraw(pointsPlayer1, pointsPlayer2)) {
            return drawScore(pointsPlayer1);
        }

        if (isAdvantage(pointsPlayer1, pointsPlayer2)) {
            return advantageScore(pointsPlayer1, pointsPlayer2);
        }

        if (isWinner(pointsPlayer1, pointsPlayer2)) {
            return winnerScore(pointsPlayer1, pointsPlayer2);
        }

        return playerScore(pointsPlayer1) + "-" + playerScore(pointsPlayer2);
    }

    private boolean isDraw(int pointsPlayer1, int pointsPlayer2) {
        return pointsPlayer1 == pointsPlayer2;
    }

    private String drawScore(int playerPoints) {
        switch (playerPoints) {
            case 0:
                return "Love-All";

            case 1:
                return"Fifteen-All";

            case 2:
                return"Thirty-All";

            default:
                return"Deuce";
        }
    }

    private boolean isAdvantage(int pointsPlayer1, int pointsPlayer2) {
        int diff = Math.abs(pointsPlayer1 - pointsPlayer2);

        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) && diff == 1;
    }

    private String advantageScore(int pointsPlayer1, int pointsPlayer2) {
        if (pointsPlayer1 > pointsPlayer2) {
            return "Advantage player1";
        }
        else {
            return "Advantage player2";
        }
    }

    private boolean isWinner(int pointsPlayer1, int pointsPlayer2) {
        int diff = Math.abs(pointsPlayer1 - pointsPlayer2);

        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) && diff >= 2;
    }

    private String winnerScore(int pointsPlayer1, int pointsPlayer2) {
        if (pointsPlayer1 > pointsPlayer2) {
            return "Win for player1";
        }
        else {
            return "Win for player2";
        }
    }
    
    private static String playerScore(int pointsPlayer) {
        switch (pointsPlayer) {
            case 0:
                return "Love";

            case 1:
                return "Fifteen";

            case 2:
                return "Thirty";

            default:
                return "Forty";
        }
    }
}
