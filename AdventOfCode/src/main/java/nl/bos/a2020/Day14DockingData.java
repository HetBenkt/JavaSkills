package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14DockingData {

    public Day14DockingData() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day14DockingData");
        List<String> data = AdventReadInput.readData(is);

        //Parse data to objects
        List<Bitmask> bitmasks = new ArrayList<>();
        int bitmaskIndex = -1;
        for (String line : data) {
            if (line.startsWith("mask")) {
                Bitmask bitmask = new Bitmask(line.split(" ")[2]);
                bitmasks.add(bitmask);
                bitmaskIndex++;
            } else if (line.startsWith("mem")) {
                Bitmask bitmask = bitmasks.get(bitmaskIndex);
                int address = Integer.parseInt(line.substring(line.indexOf('[') + 1, line.indexOf(']')));
                String value = line.split(" ")[2];
                String binary = Integer.toBinaryString(Integer.parseInt(value));
                bitmask.addMemory(address, value, String.format("%36s", binary).replace(' ', '0'));
            }
        }

        Map<Integer, Long> memoryAddresses = new HashMap<>();
        for (Bitmask bitmask : bitmasks) {
            String mask = bitmask.getMask();
            List<Mem> memory = bitmask.getMemory();
            for (Mem mem : memory) {
                memoryAddresses.put(mem.getAddress(), calcMaskedValue(mask, mem.getBinary()));
            }
        }

        System.out.println(String.format("The sum of all values left in memory after it completes = %d", memoryAddresses.values().stream().reduce(0L, Long::sum)));
    }

    private long calcMaskedValue(String mask, String binary) {
        StringBuilder newBinary = new StringBuilder();
        int index = 0;
        char[] masks = mask.toCharArray();
        for (char character : binary.toCharArray()) {
            if (masks[index] == 'X') {
                newBinary.append(character);
            } else if (masks[index] == '1') {
                newBinary.append('1');
            } else if (masks[index] == '0') {
                newBinary.append('0');
            }
            index++;
        }

        long sum = 0L;
        long bit = 1;
        for (int i = newBinary.length() - 1; i >= 0; i--) {
            char charAt = newBinary.charAt(i);
            if (charAt == '1') {
                sum += bit;
            }
            bit *= 2;
        }

        return sum;
    }

    public static void main(String[] args) {
        new Day14DockingData();
    }

    private class Bitmask {

        private final String mask;
        private final List<Mem> memory = new ArrayList<>();

        public Bitmask(String mask) {
            this.mask = mask;
        }

        public void addMemory(int address, String value, String binary) {
            memory.add(new Mem(address, value, binary));
        }

        public List<Mem> getMemory() {
            return memory;
        }

        public String getMask() {
            return mask;
        }
    }

    private class Mem {
        private final int address;
        private final String value;
        private final String binary;

        public Mem(int address, String value, String binary) {
            this.address = address;
            this.value = value;
            this.binary = binary;
        }

        public String getValue() {
            return value;
        }

        public int getAddress() {
            return address;
        }

        public String getBinary() {
            return binary;
        }
    }
}