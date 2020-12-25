package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5BinaryBoarding {

    public Day5BinaryBoarding() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day5BinaryBoarding");
        List<String> data = AdventReadInput.readData(is);

        List<Integer> seatIds = new ArrayList<>();

        for (String seat : data) {
            int columns = 8;
            int rows = 128;
            List<Integer> tempNumbers = new ArrayList<>();

            //rows
            List<Integer> resultNumbers = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                resultNumbers.add(i);
            }

            String rowRegions = seat.substring(0, 7);
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
            int row = resultNumbers.get(0);

            //columns
            resultNumbers.clear();
            for (int i = 0; i < columns; i++) {
                resultNumbers.add(i);
            }

            String columnRegions = seat.substring(7);
            for (char columnRegion : columnRegions.toCharArray()) {
                columns /= 2;
                switch (columnRegion) {
                    case 'L':
                        //lower half
                        for (int i = 0; i < columns; i++) {
                            tempNumbers.add(resultNumbers.get(i));
                        }
                        resultNumbers.clear();
                        resultNumbers.addAll(tempNumbers);
                        tempNumbers.clear();
                        break;
                    case 'R':
                        //upper half
                        for (int i = 0; i < columns; i++) {
                            tempNumbers.add(resultNumbers.get(i + columns));
                        }
                        resultNumbers.clear();
                        resultNumbers.addAll(tempNumbers);
                        tempNumbers.clear();
                        break;
                    default:
                        break;
                }
            }
            int column = resultNumbers.get(0);

            seatIds.add((row * 8) + column);
        }

        Collections.sort(seatIds); //682

        System.out.println(String.format("Highest seat ID = %d", Collections.max(seatIds)));
    }

    public static void main(String[] args) {
        new Day5BinaryBoarding();
    }
}
