
public class TennisGame2 implements TennisGame {

    private int pointsPlayer1;
    private int pointsPlayer2;

    public TennisGame2() {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            pointsPlayer1++;
        }
        else {
            pointsPlayer2++;
        }
    }

    public String getScore() {
        if (isDraw(pointsPlayer1, pointsPlayer2)) {
            return drawScore(pointsPlayer1);
        }

        if (isWinner(pointsPlayer1, pointsPlayer2)) {
            return winnerScore(pointsPlayer1, pointsPlayer2);
        }

        if (isAdvantage(pointsPlayer1, pointsPlayer2)) {
            return advantageScore(pointsPlayer1, pointsPlayer2);
        }

        return getGameScore();
    }

    private boolean isDraw(int pointsPlayer1, int pointsPlayer2) {
        return pointsPlayer1 == pointsPlayer2;
    }

    private String drawScore(int playerPoints) {
        switch (playerPoints) {
            case 0:
                return "Love-All";

            case 1:
                return "Fifteen-All";

            case 2:
                return "Thirty-All";

            default:
                return "Deuce";
        }
    }

    private boolean isWinner(int pointsPlayer1, int pointsPlayer2) {
        int diff = Math.abs(pointsPlayer1 - pointsPlayer2);

        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) && diff >= 2;
    }

    private String winnerScore(int pointsPlayer1, int pointsPlayer2) {
        if (pointsPlayer1 >= pointsPlayer2) {
            return "Win for player1";
        }
        else {
            return "Win for player2";
        }
    }

    private boolean isAdvantage(int pointsPlayer1, int pointsPlayer2) {
        int diff = Math.abs(pointsPlayer1 - pointsPlayer2);

        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) && diff >= 1;
    }

    private String advantageScore(int pointsPlayer1, int pointsPlayer2) {
        if (pointsPlayer1 > pointsPlayer2) {
            return "Advantage player1";
        }
        else {
            return "Advantage player2";
        }
    }

    private String getGameScore() {
        if (pointsPlayer1 == 0 || pointsPlayer2 == 0) {
            String P1res = "Love";
            String P2res = "Love";

            if (pointsPlayer1 > 0) {
                P1res = playerScore(pointsPlayer1);
            }

            if (pointsPlayer2 > 0) {
                P2res = playerScore(pointsPlayer2);
            }

            return P1res + "-" + P2res;
        }

        return playerScore(pointsPlayer1) + "-" + playerScore(pointsPlayer2);
    }

    private String playerScore(int playerPoints) {
        switch (playerPoints) {
            case 1:
                return "Fifteen";

            case 2:
                return "Thirty";

            default:
                return "Forty";
        }
    }
}