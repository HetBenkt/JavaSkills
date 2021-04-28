package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day17ConwayCubes {

    private final static int CYCLES = 6;
    public Day17ConwayCubes() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day17ConwayCubes");
        List<String> data = AdventReadInput.readData(is);

        ArrayList<ArrayList<ArrayList<ConwayCube>>> space = new ArrayList<>();
        ArrayList<ArrayList<ConwayCube>> layer = new ArrayList<>();

        for (int i = 0; i < CYCLES; i++) {
            space.add(-2, layer);
            space.add(-1, layer);
            space.add(0, layer);
            space.add(1, layer);
            space.add(2, layer);
        }

        System.out.printf("# of cubes left in the active state after the sixth cycle = %d%n", 0);
    }

    private enum State {
        ACTIVE,
        INACTIVE
    }

    private class ConwayCube {
        private final State state;
        private final int coordinateX;
        private final int coordinateY;
        private final int coordinateZ;

        private final ConwayCube[] neighbors = new ConwayCube[26];

        public ConwayCube(State state, int coordinateX, int coordinateY, int coordinateZ) {
            this.state = state;
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
            this.coordinateZ = coordinateZ;
            //z=0
            neighbors[0] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY + 1, coordinateZ);
            neighbors[1] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY + 0, coordinateZ);
            neighbors[2] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY - 1, coordinateZ);
            neighbors[3] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY + 1, coordinateZ);
            neighbors[4] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY - 1, coordinateZ);
            neighbors[5] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY + 1, coordinateZ);
            neighbors[6] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY + 0, coordinateZ);
            neighbors[7] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY - 1, coordinateZ);
            //z=1
            neighbors[8] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY + 1, coordinateZ - 1);
            neighbors[9] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY + 0, coordinateZ - 1);
            neighbors[10] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY - 1, coordinateZ - 1);
            neighbors[11] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY + 1, coordinateZ - 1);
            neighbors[12] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY + 0, coordinateZ - 1);
            neighbors[13] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY - 1, coordinateZ - 1);
            neighbors[14] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY + 1, coordinateZ - 1);
            neighbors[15] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY + 0, coordinateZ - 1);
            neighbors[16] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY - 1, coordinateZ - 1);
            //z=-1
            neighbors[17] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY + 1, coordinateZ + 1);
            neighbors[18] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY + 0, coordinateZ + 1);
            neighbors[19] = new ConwayCube(State.INACTIVE, coordinateX - 1, coordinateY - 1, coordinateZ + 1);
            neighbors[20] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY + 1, coordinateZ + 1);
            neighbors[21] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY + 0, coordinateZ + 1);
            neighbors[22] = new ConwayCube(State.INACTIVE, coordinateX + 0, coordinateY - 1, coordinateZ + 1);
            neighbors[23] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY + 1, coordinateZ + 1);
            neighbors[24] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY + 0, coordinateZ + 1);
            neighbors[25] = new ConwayCube(State.INACTIVE, coordinateX + 1, coordinateY - 1, coordinateZ + 1);
        }
    }
}

