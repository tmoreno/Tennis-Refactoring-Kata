
public class TennisGame2 implements TennisGame {
    public int pointsPlayer1;
    public int pointsPlayer2;
    public String P1res;
    public String P2res;

    public TennisGame2() {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
        P1res = "";
        P2res = "";
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            pointsPlayer1++;
        }
        else {
            pointsPlayer2++;
        }
    }

    public String getScore(){
        String score = "";

        if (pointsPlayer1 == pointsPlayer2) {
            score = drawScore(pointsPlayer1);
        }

        if (pointsPlayer1 > 0 && pointsPlayer2 == 0) {
            if (pointsPlayer1 == 1) {
                P1res = "Fifteen";
            }

            if (pointsPlayer1 == 2) {
                P1res = "Thirty";
            }

            if (pointsPlayer1 == 3) {
                P1res = "Forty";
            }

            P2res = "Love";
            score = P1res + "-" + P2res;
        }

        if (pointsPlayer2 > 0 && pointsPlayer1 == 0) {
            if (pointsPlayer2 == 1) {
                P2res = "Fifteen";
            }

            if (pointsPlayer2 == 2) {
                P2res = "Thirty";
            }

            if (pointsPlayer2 == 3) {
                P2res = "Forty";
            }

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (pointsPlayer1 > pointsPlayer2 && pointsPlayer1 < 4) {
            if (pointsPlayer1 == 2) {
                P1res = "Thirty";
            }

            if (pointsPlayer1 == 3) {
                P1res = "Forty";
            }

            if (pointsPlayer2 == 1) {
                P2res = "Fifteen";
            }

            if (pointsPlayer2 == 2) {
                P2res = "Thirty";
            }

            score = P1res + "-" + P2res;
        }

        if (pointsPlayer2 > pointsPlayer1 && pointsPlayer2 < 4) {
            if (pointsPlayer2 == 2) {
                P2res = "Thirty";
            }

            if (pointsPlayer2 == 3) {
                P2res = "Forty";
            }

            if (pointsPlayer1 == 1) {
                P1res = "Fifteen";
            }

            if (pointsPlayer1 == 2) {
                P1res = "Thirty";
            }

            score = P1res + "-" + P2res;
        }

        if (pointsPlayer1 > pointsPlayer2 && pointsPlayer2 >= 3) {
            score = "Advantage player1";
        }

        if (pointsPlayer2 > pointsPlayer1 && pointsPlayer1 >= 3) {
            score = "Advantage player2";
        }

        if (pointsPlayer1 >= 4 && pointsPlayer2 >= 0 && (pointsPlayer1 - pointsPlayer2) >= 2) {
            score = "Win for player1";
        }

        if (pointsPlayer2 >= 4 && pointsPlayer1 >= 0 && (pointsPlayer2 - pointsPlayer1) >= 2) {
            score = "Win for player2";
        }

        return score;
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
}