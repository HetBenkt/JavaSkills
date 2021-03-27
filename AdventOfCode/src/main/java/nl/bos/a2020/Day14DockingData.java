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
                String addressBinary = Integer.toBinaryString(address);
                int value = Integer.parseInt(line.split(" ")[2]);
                bitmask.addMemory(String.format("%36s", addressBinary).replace(' ', '0'), value);
            }
        }

        Map<Long, Long> memoryAddresses = new HashMap<>();
        for (Bitmask bitmask : bitmasks) {
            String mask = bitmask.getMask();
            List<Mem> memory = bitmask.getMemory();
            for (Mem mem : memory) {
                String bitMaskAddress = applyBitmask(mem.getAddressBinary(), mask);
                List<Long> newAddresses = calcNewAddresses(bitMaskAddress);
                for (long newAddress : newAddresses) {
                    memoryAddresses.put(newAddress, (long) mem.getValue());
                }
            }
        }

        System.out.println(String.format("The sum of all values left in memory after it completes = %d", memoryAddresses.values().stream().reduce(0L, Long::sum)));
    }

    private List<Long> calcNewAddresses(String bitMaskAddress) {
        List<Long> result = new ArrayList<>();

        long nrFloatingBits = bitMaskAddress.chars().filter(ch -> ch == 'X').count();
        List<String> binaryCombinations = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nrFloatingBits); i++) {
            String format = String.format("%ds", nrFloatingBits);
            String combination = String.format("%" + format, Integer.toBinaryString(i)).replace(' ', '0');
            binaryCombinations.add(combination);
        }

        for (String binaryCombination : binaryCombinations) {
            result.add(calcNewAddress(bitMaskAddress, binaryCombination));
        }

        return result;
    }

    private long calcNewAddress(String bitMaskAddress, String binaryCombination) {
        for (char binary : binaryCombination.toCharArray()) {
            bitMaskAddress = bitMaskAddress.replaceFirst("X", String.valueOf(binary));
        }

        long sum = 0L;
        long bit = 1;
        for (int i = bitMaskAddress.length() - 1; i >= 0; i--) {
            char charAt = bitMaskAddress.charAt(i);
            if (charAt == '1') {
                sum += bit;
            }
            bit *= 2;
        }

        return sum;
    }

    private String applyBitmask(String addressBinary, String mask) {
        StringBuilder result = new StringBuilder();

        int index = 0;
        char[] masks = mask.toCharArray();
        for (char character : addressBinary.toCharArray()) {
            if (masks[index] == 'X') {
                result.append('X');
            } else if (masks[index] == '1') {
                result.append('1');
            } else if (masks[index] == '0') {
                result.append(character);
            }
            index++;
        }

        return String.valueOf(result);
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

        public void addMemory(String addressBinary, int value) {
            memory.add(new Mem(addressBinary, value));
        }

        public List<Mem> getMemory() {
            return memory;
        }

        public String getMask() {
            return mask;
        }
    }

    private class Mem {
        private final int value;
        private final String addressBinary;

        public Mem(String addressBinary, int value) {
            this.value = value;
            this.addressBinary = addressBinary;
        }

        public int getValue() {
            return value;
        }

        public String getAddressBinary() {
            return addressBinary;
        }
    }
}