package nl.bos.kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DRootExampleTest {
    @Test
    public void Tests() {
        assertEquals("Nope!", 7, DRoot.digitalRoot(16));
        assertEquals("Nope!", 6, DRoot.digitalRoot(456));
    }
}