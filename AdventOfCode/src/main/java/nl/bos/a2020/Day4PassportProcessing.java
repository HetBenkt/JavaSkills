package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

//195 is the wrong answer!?
public class Day4PassportProcessing {

    public Day4PassportProcessing() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day4PassportProcessing");
        ArrayList<String> data = AdventReadInput.readData(is);

        ArrayList<Passport> passports = new ArrayList<>();
        ArrayList<String> metadata = new ArrayList<>();
        for (String line : data) {
            if (!line.isEmpty()) {
                metadata.addAll(Arrays.asList(line.split(" ")));
            } else if (metadata.size() == 8 || (metadata.size() == 7 && metadataHasCid(metadata))) {
                Passport passport = new Passport();
                passport.setMetadata(metadata);
                passports.add(passport);
                metadata.clear();
            } else {
                metadata.clear();
            }
        }

        System.out.println(String.format("%s valid passports!", passports.size()));
    }

    public static void main(String[] args) {
        new Day4PassportProcessing();
    }

    private boolean metadataHasCid(ArrayList<String> metadata) {
        for (String metadataLin : metadata) {
            if (metadataLin.startsWith("cid")) {
                return false;
            }
        }
        return true;
    }

    private class Passport {
        private final ArrayList<String> metadata = new ArrayList<>();

        public ArrayList<String> getMetadata() {
            return metadata;
        }

        public void setMetadata(ArrayList<String> metadata) {
            for (String metadataLine : metadata) {
                this.metadata.add(metadataLine);
            }
        }
    }
}
