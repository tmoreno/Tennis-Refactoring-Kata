
public class TennisGame3 implements TennisGame {

    private static final String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    private final String player1Name;
    private final String player2Name;
    private int player1Points;
    private int player2Points;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            player1Points++;
        } else {
            player2Points++;
        }
    }

    public String getScore() {
        if (player1Points >= 4 || player2Points >= 4 || player1Points + player2Points == 6) {
            String playerWithMorePoints = player1Points > player2Points ? player1Name : player2Name;

            int diff = Math.abs(player1Points - player2Points);

            switch (diff) {
                case 0:
                    return "Deuce";

                case 1:
                    return "Advantage " + playerWithMorePoints;

                default:
                    return "Win for " + playerWithMorePoints;
            }
        }
        
        if (player1Points == player2Points) {
            return playerScore(player1Points) + "-All";
        }

        return playerScore(player1Points) + "-" + playerScore(player2Points);
    }

    private String playerScore(int playerPoints) {
        return SCORES[playerPoints];
    }
}
