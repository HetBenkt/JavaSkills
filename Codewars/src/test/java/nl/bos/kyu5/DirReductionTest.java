package nl.bos.kyu5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DirReductionTest {
    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
        assertArrayEquals("\"NORTH\",\"EAST\",\"WEST\",\"SOUTH\",\"WEST\",\"WEST\"",
                new String[]{"WEST", "WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"}));
        assertArrayEquals("\"NORTH\",\"WEST\",\"SOUTH\",\"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }
}