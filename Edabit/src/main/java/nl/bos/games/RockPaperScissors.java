package nl.bos.games;

public class RockPaperScissors {
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "TIE";
        } else {
            return null;
        }
    }
}
