package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4GiantSquid {

    private final List<BingoCard> overallBingoCards = new ArrayList<>();

    public Day4GiantSquid() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day4GiantSquid");
        List<String> data = AdventReadInput.readData(is);

        //Prepare data
        int[] bingoNumbers = Arrays.stream(data.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        List<BingoCard> bingoCards = new ArrayList<>();
        for (int i = 1; i < data.size(); i += 6) {
            int[][] cardNumbers = new int[5][5];
            cardNumbers[0] = Arrays.stream(data.get(i + 1).split("(?<=\\G.{3})")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            cardNumbers[1] = Arrays.stream(data.get(i + 2).split("(?<=\\G.{3})")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            cardNumbers[2] = Arrays.stream(data.get(i + 3).split("(?<=\\G.{3})")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            cardNumbers[3] = Arrays.stream(data.get(i + 4).split("(?<=\\G.{3})")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            cardNumbers[4] = Arrays.stream(data.get(i + 5).split("(?<=\\G.{3})")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            bingoCards.add(new BingoCard(cardNumbers));
        }

        for (int bingoNumber : bingoNumbers) {
            for (BingoCard bingoCard : bingoCards) {
                int[][] card = bingoCard.numbers();
                for (int row = 0; row < card.length; row++) {
                    for (int col = 0; col < card[row].length; col++) {
                        if (card[row][col] == bingoNumber) {
                            int lastNumber = card[row][col];
                            card[row][col] = -1;
                            doBingoCheck(bingoCards);
                            if ((bingoCards.size() - overallBingoCards.size()) == 1) {
                                int result = doBingoCheck(bingoCards);
                                if (result > 0) {
                                    System.out.printf("Final score be: %s", (result * lastNumber));
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private int doBingoCheck(List<BingoCard> bingoCards) {
        for (BingoCard bingoCard : bingoCards) {
            int[][] card = bingoCard.numbers();
            for (int[] ints : card) {
                if (Arrays.stream(ints).sum() == -5) {
                    //found a bingo in row
                    int sum = Arrays.stream(card).flatMapToInt(Arrays::stream).filter(value -> value != -1).sum();
                    if (bingoCards.size() - overallBingoCards.size() != 1) {
                        overallBingoCards.add(bingoCard);
                        clearBingoCard(bingoCard);
                    }
                    return sum;
                }
            }
        }

        for (BingoCard bingoCard : bingoCards) {
            int[][] card = bingoCard.numbers();
            int[][] rotatedCard = new int[5][5];
            for (int i = 0; i < card[0].length; i++) {
                for (int j = card.length - 1; j >= 0; j--) {
                    rotatedCard[i][j] = card[j][i];
                }
            }

            for (int[] ints : rotatedCard) {
                if (Arrays.stream(ints).sum() == -5) {
                    //found a bingo in column
                    int sum = Arrays.stream(rotatedCard).flatMapToInt(Arrays::stream).filter(value -> value != -1).sum();
                    if (bingoCards.size() - overallBingoCards.size() != 1) {
                        overallBingoCards.add(bingoCard);
                        clearBingoCard(bingoCard);
                    }
                    return sum;
                }
            }
        }
        return 0;
    }

    private void clearBingoCard(BingoCard bingoCard) {
        for (int[] numbers : bingoCard.numbers()) {
            Arrays.fill(numbers, -2);
        }
    }

    public static void main(String[] args) {
        new Day4GiantSquid();
    }

    public record BingoCard(int[][] numbers) {
    }
}
