package nl.bos.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneNumberWordDecoderTest {
    @Test
    public void test1() {
        assertEquals("123-647-3937", PhoneNumberWordDecoder.textToNum("123-647-EYES"));
    }

    @Test
    public void test2() {
        assertEquals("(325)444-8378", PhoneNumberWordDecoder.textToNum("(325)444-TEST"));
    }

    @Test
    public void test3() {
        assertEquals("653-879-8447", PhoneNumberWordDecoder.textToNum("653-TRY-THIS"));
    }

    @Test
    public void test4() {
        assertEquals("435-224-7613", PhoneNumberWordDecoder.textToNum("435-224-7613"));
    }

    @Test
    public void test5() {
        assertEquals("(333)668-3245", PhoneNumberWordDecoder.textToNum("(33D)ONT-FAIL"));
    }

    @Test
    public void test6() {
        assertEquals("(025)445-6741", PhoneNumberWordDecoder.textToNum("(025)445-6741"));
    }
}