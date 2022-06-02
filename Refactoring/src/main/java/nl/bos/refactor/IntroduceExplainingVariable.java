package nl.bos.refactor;


public class IntroduceExplainingVariable {
    private static final String BROWSER = "IE";
    private static final int RESIZE = 1;
    private static final String PLATFORM = "WIN";

    public void detection() {

        if ((PLATFORM.toUpperCase().indexOf("MAC") > -1) &&
                (BROWSER.toUpperCase().indexOf("IE") > -1) &&
                wasInitialized() &&
                RESIZE > 0) {
            // do something
        }
    }

    private boolean wasInitialized() {
        return true;
    }
}
