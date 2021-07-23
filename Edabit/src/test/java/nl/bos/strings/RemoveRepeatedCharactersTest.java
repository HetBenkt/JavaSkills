package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveRepeatedCharactersTest {
    @Test
    public void test01() {
        assertEquals("helo", RemoveRepeatedCharacters.unrepeated("hello"));
    }

    @Test
    public void test02() {
        assertEquals("WE!", RemoveRepeatedCharacters.unrepeated("WWEE!!!"));
    }

    @Test
    public void test03() {
        assertEquals("cal 91", RemoveRepeatedCharacters.unrepeated("call 911"));
    }

    @Test
    public void test04() {
        assertEquals("a", RemoveRepeatedCharacters.unrepeated("aaaaaa"));
    }

    @Test
    public void test05() {
        assertEquals("alwf tes", RemoveRepeatedCharacters.unrepeated("alwaff test"));
    }

    @Test
    public void test06() {
        assertEquals("tesha", RemoveRepeatedCharacters.unrepeated("teshahset"));
    }

    @Test
    public void test07() {
        assertEquals("porcuine", RemoveRepeatedCharacters.unrepeated("porcupine"));
    }

    @Test
    public void test08() {
        assertEquals("alter go", RemoveRepeatedCharacters.unrepeated("alter ego"));
    }

    @Test
    public void test09() {
        assertEquals("rejuvnat", RemoveRepeatedCharacters.unrepeated("rejuvenate"));
    }

    @Test
    public void test10() {
        assertEquals("strau nimb", RemoveRepeatedCharacters.unrepeated("stratus nimbus"));
    }

    @Test
    public void test11() {
        assertEquals("strageiz", RemoveRepeatedCharacters.unrepeated("stragegize"));
    }
}