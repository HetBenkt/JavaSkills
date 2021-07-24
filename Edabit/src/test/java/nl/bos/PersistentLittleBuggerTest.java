package nl.bos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistentLittleBuggerTest {
    @Test
    public void test1() {
        assertEquals(3, PersistentLittleBugger.bugger(39));
    }

    @Test
    public void test2() {
        assertEquals(0, PersistentLittleBugger.bugger(4));
    }

    @Test
    public void test3() {
        assertEquals(2, PersistentLittleBugger.bugger(25));
    }

    @Test
    public void test4() {
        assertEquals(4, PersistentLittleBugger.bugger(999));
    }
}