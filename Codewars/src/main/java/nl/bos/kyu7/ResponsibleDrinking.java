package nl.bos.kyu7;

public class ResponsibleDrinking {
    public String hydrate(String drinkString) {
        int nrOfGlassesWater = 0;

        String[] drinkSplit = drinkString.split(" ");
        for (String drink : drinkSplit) {
            try {
                nrOfGlassesWater += Integer.parseInt(drink);
            } catch (NumberFormatException nfe) {
                //do nothing!
            }
        }

        return String.format("%d glass%s of water", nrOfGlassesWater, nrOfGlassesWater > 1 ? "es" : "");
    }
}
