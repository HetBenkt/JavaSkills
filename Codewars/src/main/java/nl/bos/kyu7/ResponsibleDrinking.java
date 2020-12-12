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

        return (nrOfGlassesWater > 1) ? String.format("%d glasses of water", nrOfGlassesWater) : String.format("%d glass of water", nrOfGlassesWater);
    }
}
