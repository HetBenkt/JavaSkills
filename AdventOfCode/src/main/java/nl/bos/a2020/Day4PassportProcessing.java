package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//195 is too low!?
//219 is too high!?
public class Day4PassportProcessing {

    public Day4PassportProcessing() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day4PassportProcessing");
        List<String> data = AdventReadInput.readData(is);

        List<Passport> passports = new ArrayList<>();
        List<String> metadata = new ArrayList<>();
        for (String line : data) {
            if (!line.isEmpty()) {
                metadata.addAll(Arrays.asList(line.split(" ")));
            } else if (metadata.size() == 8 || (metadata.size() == 7 && !hasCid(metadata))) {
                Passport passport = new Passport();
                passport.setMetadata(metadata);
                passports.add(passport);
                metadata.clear();
            } else {
                metadata.clear();
            }
        }

        //The last passport...As it has no empty line at the end to detect it!!!!
        if (metadata.size() == 8 || (metadata.size() == 7 && !hasCid(metadata))) {
            Passport passport = new Passport();
            passport.setMetadata(metadata);
            passports.add(passport);
            metadata.clear();
        }

        System.out.println(String.format("%s valid passports!", passports.size()));

        List<Passport> remainingPassports = new ArrayList<>();
        for (Passport passport : passports) {
            if (passport.isValid()) {
                remainingPassports.add(passport);
            }
        }

        System.out.println(String.format("%s remaining valid passports!", remainingPassports.size()));
    }

    private boolean hasCid(List<String> metadata) {
        for (String metadataLine : metadata) {
            if (metadataLine.startsWith("cid")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Day4PassportProcessing();
    }

    private class Passport {
        private final List<String> metadata = new ArrayList<>();

        public void setMetadata(List<String> metadata) {
            this.metadata.addAll(metadata);
            Collections.sort(this.metadata);
        }

        public boolean isValid() {
            boolean isValid = true;
            for (String metadataLine : metadata) {
                switch (metadataLine.substring(0, 3)) {
                    case "byr":
                        isValid = isValidByr(metadataLine.substring(4));
                        break;
                    case "iyr":
                        isValid = isValidIyr(metadataLine.substring(4));
                        break;
                    case "eyr":
                        isValid = isValidEyr(metadataLine.substring(4));
                        break;
                    case "hgt":
                        isValid = isValidHgt(metadataLine.substring(4));
                        break;
                    case "hcl":
                        isValid = isValidHcl(metadataLine.substring(4));
                        break;
                    case "ecl":
                        isValid = isValidEcl(metadataLine.substring(4));
                        break;
                    case "pid":
                        isValid = isValidPid(metadataLine.substring(4));
                        break;
                    default:
                        //Do nothing
                }
                if (!isValid) {
                    break;
                }
            }
            return isValid;
        }

        private boolean isValidByr(String value) {
            return false;
        }

        private boolean isValidIyr(String value) {
            return false;
        }

        private boolean isValidEyr(String value) {
            return false;
        }

        private boolean isValidHgt(String value) {
            return false;
        }

        private boolean isValidHcl(String value) {
            return false;
        }

        private boolean isValidEcl(String value) {
            return false;
        }

        private boolean isValidPid(String value) {
            return false;
        }
    }
}
