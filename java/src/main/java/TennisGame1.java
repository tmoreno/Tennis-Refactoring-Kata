
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

        String score = "";
        int tempScore=0;

        if (pointsPlayer1 >=4 || pointsPlayer2 >=4)
        {
            score = gamePointScore();
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = pointsPlayer1;
                else { score+="-"; tempScore = pointsPlayer2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
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
                return"Fifteen-All";

            case 2:
                return"Thirty-All";

            default:
                return"Deuce";
        }
    }

    private String gamePointScore() {
        int minusResult = pointsPlayer1 - pointsPlayer2;

        if (minusResult == 1) {
            return "Advantage player1";
        }
        else if (minusResult == -1) {
            return "Advantage player2";
        }
        else if (minusResult >= 2) {
            return "Win for player1";
        }
        else {
            return "Win for player2";
        }
    }
}
