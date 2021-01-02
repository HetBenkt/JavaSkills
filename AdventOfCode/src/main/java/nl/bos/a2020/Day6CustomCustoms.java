package nl.bos.a2020;

import nl.bos.general.AdventReadInput;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day6CustomCustoms {

    public Day6CustomCustoms() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day6CustomCustoms");
        List<String> data = AdventReadInput.readData(is);

        List<DataHelper> groups = new ArrayList<>();
        StringBuilder answers = new StringBuilder();
        int peopleInGroup = 0;
        String dataOnePerson = "";
        for (String line : data) {
            if (!line.isEmpty()) {
                answers.append(line);
                peopleInGroup++;
                dataOnePerson = line;
            } else {
                DataHelper pair = new DataHelper(peopleInGroup, String.valueOf(answers), dataOnePerson);
                groups.add(pair);
                answers.delete(0, answers.length());
                peopleInGroup = 0;
                dataOnePerson = "";
            }
        }
        //The last group...As it has no empty line at the end to detect it!!!!
        DataHelper pair = new DataHelper(peopleInGroup, String.valueOf(answers), dataOnePerson);
        groups.add(pair);

        int index = 0;
        for (DataHelper datahelper : groups) {
            for (char value : datahelper.getDataOnePerson().toCharArray()) {
                if (datahelper.getPeopleInGroup() == StringUtils.countMatches(datahelper.getData(), value)) {
                    index++;
                }
            }
        }
        System.out.println(index);
    }

    public static void main(String[] args) {
        new Day6CustomCustoms();
    }

    private class DataHelper {
        private final int peopleInGroup;
        private final String data;
        private final String dataOnePerson;

        public DataHelper(int peopleInGroup, String data, String dataOnePerson) {
            this.peopleInGroup = peopleInGroup;
            this.data = data;
            this.dataOnePerson = dataOnePerson;
        }

        public int getPeopleInGroup() {
            return peopleInGroup;
        }

        public String getData() {
            return data;
        }

        public String getDataOnePerson() {
            return dataOnePerson;
        }
    }
}
