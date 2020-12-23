package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day5BinaryBoarding {

    private final static int COLUMNS = 8;
    private int rows = 128;

    public Day5BinaryBoarding() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day5BinaryBoarding");
        List<String> data = AdventReadInput.readData(is);

        for (String seat : data) {
            List<Integer> resultNumbers = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                resultNumbers.add(i);
            }

            String rowRegions = seat.substring(0, 7);
            List<Integer> tempNumbers = new ArrayList<>();
            for (char rowRegion : rowRegions.toCharArray()) {
                rows /= 2;
                switch (rowRegion) {
                    case 'F':
                        //lower half
                        for (int i = 0; i < rows; i++) {
                            tempNumbers.add(resultNumbers.get(i));
                        }
                        resultNumbers.clear();
                        resultNumbers.addAll(tempNumbers);
                        tempNumbers.clear();
                        break;
                    case 'B':
                        //upper half
                        for (int i = 0; i < rows; i++) {
                            tempNumbers.add(resultNumbers.get(i + rows));
                        }
                        resultNumbers.clear();
                        resultNumbers.addAll(tempNumbers);
                        tempNumbers.clear();
                        break;
                    default:
                        break;
                }
            }

            String columnRegions = seat.substring(7);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Day5BinaryBoarding();
    }
}
