
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
        String s;
        if (player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6)) {
            if (player1Points == player2Points) {
                return playerScore(player1Points) + "-All";
            }
            
            return playerScore(player1Points) + "-" + playerScore(player2Points);
        } else {
            if (player1Points == player2Points)
                return "Deuce";
            s = player1Points > player2Points ? player1Name : player2Name;
            return ((player1Points - player2Points)*(player1Points - player2Points) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    private String playerScore(int playerPoints) {
        return SCORES[playerPoints];
    }
}
