
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
        } else {
            pointsPlayer2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (pointsPlayer1 == pointsPlayer2)
        {
            score = drawScore(pointsPlayer1);
        }
        else if (pointsPlayer1 >=4 || pointsPlayer2 >=4)
        {
            int minusResult = pointsPlayer1 - pointsPlayer2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
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
}
