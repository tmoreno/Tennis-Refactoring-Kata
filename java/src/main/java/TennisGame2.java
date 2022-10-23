
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

    public String getScore() {
        if (isDraw(pointsPlayer1, pointsPlayer2)) {
            return drawScore(pointsPlayer1);
        }

        if (isWinner(pointsPlayer1, pointsPlayer2)) {
            return winnerScore(pointsPlayer1, pointsPlayer2);
        }

        if ((pointsPlayer1 > pointsPlayer2 && pointsPlayer2 >= 3) || (pointsPlayer2 > pointsPlayer1 && pointsPlayer1 >= 3)) {
            if (pointsPlayer1 > pointsPlayer2 && pointsPlayer2 >= 3) {
                return "Advantage player1";
            }

            if (pointsPlayer2 > pointsPlayer1 && pointsPlayer1 >= 3) {
                return "Advantage player2";
            }
        }

        String score = "";

        if (pointsPlayer1 == 0 || pointsPlayer2 == 0) {
            if (pointsPlayer1 > 0) {
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

            if (pointsPlayer2 > 0) {
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

        return score;
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
}