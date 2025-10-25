package ss8_CleanCode;
public class TennisGame {


    public static final int SCORE_TO_WIN = 4;
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    public void wonPoint(String playerName) {
        if (PLAYER_1.equals(playerName)) player1Score += 1;
        else if(PLAYER_2.equals(playerName)) player2Score += 1;
    }
    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score) {
            score = getScoreRank();
        } else if (player1Score >= SCORE_TO_WIN || player2Score >= SCORE_TO_WIN) {
            int ScoreDifference = getScoreDifference();
            if (ScoreDifference == 1) score = "Advantage player1";
            else if (ScoreDifference == -1) score = "Advantage player2";
            else if (ScoreDifference >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            score = getScoreName(score);
        }
        return score;
    }

    private int getScoreDifference() {
        int ScoreDifference = player1Score - player2Score;
        return ScoreDifference;
    }

    private String getScoreRank() {
        String score;
        switch (player1Score) {
            case 0: score = "Love-All"; break;
            case 1: score = "Fifteen-All"; break;
            case 2: score = "Thirty-All"; break;
            default: score = "Deuce"; break;
        }
        return score;
    }

    private String getScoreName(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else { score += "-"; tempScore = player2Score; }
            switch (tempScore) {
                case 0: score += "Love"; break;
                case 1: score += "Fifteen"; break;
                case 2: score += "Thirty"; break;
                case 3: score += "Forty"; break;
            }
        }
        return score;
    }


}
