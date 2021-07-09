package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatePINTest {
    @Test
    public void test01() {
        assertEquals(true, PersonalIdNumber.validate("544466"));
    }

    @Test
    public void test02() {
        assertEquals(true, PersonalIdNumber.validate("121317"));
    }

    @Test
    public void test03() {
        assertEquals(false, PersonalIdNumber.validate("4512a5"));
    }

    @Test
    public void test04() {
        assertEquals(true, PersonalIdNumber.validate("123456"));
    }

    @Test
    public void test05() {
        assertEquals(false, PersonalIdNumber.validate(""));
    }

    @Test
    public void test06() {
        assertEquals(false, PersonalIdNumber.validate("21904"));
    }

    @Test
    public void test07() {
        assertEquals(true, PersonalIdNumber.validate("9451"));
    }

    @Test
    public void test08() {
        assertEquals(true, PersonalIdNumber.validate("213132"));
    }

    @Test
    public void test09() {
        assertEquals(false, PersonalIdNumber.validate(" 4520"));
    }

    @Test
    public void test10() {
        assertEquals(false, PersonalIdNumber.validate("15632 "));
    }

    @Test
    public void test11() {
        assertEquals(true, PersonalIdNumber.validate("000000"));
    }
}