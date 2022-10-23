
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
        String P1res = "";
        String P2res = "";

        if (pointsPlayer1 == 0 || pointsPlayer2 == 0) {
            P1res = "Love";
            P2res = "Love";

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
            }

            return P1res + "-" + P2res;
        }

        if (pointsPlayer1 > pointsPlayer2) {
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
        }
        else {
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
        }

        return P1res + "-" + P2res;
    }
}