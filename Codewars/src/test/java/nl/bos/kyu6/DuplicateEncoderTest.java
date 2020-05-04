package nl.bos.kyu6;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateEncoderTest {
    @Test
    public void test() {
        assertEquals("(((", DuplicateEncoder.encode("din"));
        assertEquals("()()()", DuplicateEncoder.encode("recede"));
        assertEquals(")())())", DuplicateEncoder.encode("Success"));
        assertEquals("))((", DuplicateEncoder.encode("(( @"));
        assertEquals(")()())()(()()(", DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))", DuplicateEncoder.encode("   ()(   "));
    }
}