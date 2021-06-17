package nl.bos.games;

public class RockPaperScissors {
    public static final String THE_WINNER_IS_P_1 = "Player 1 wins";
    public static final String THE_WINNER_IS_P_2 = "Player 2 wins";
    public static final String IT_S_A_DRAW = "TIE";
    public static final String ROCK = "rock";
    public static final String SCISSORS = "scissors";
    public static final String PAPER = "paper";

    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return IT_S_A_DRAW;
        } else {
            switch (player1) {
                case ROCK:
                    if (player2.equals(SCISSORS)) {
                        return THE_WINNER_IS_P_1;
                    }
                    break;
                case SCISSORS:
                    if (player2.equals(PAPER)) {
                        return THE_WINNER_IS_P_1;
                    }
                    break;
                case PAPER:
                    if (player2.equals(ROCK)) {
                        return THE_WINNER_IS_P_1;
                    }
            }
        }
        return THE_WINNER_IS_P_2;
    }
}
