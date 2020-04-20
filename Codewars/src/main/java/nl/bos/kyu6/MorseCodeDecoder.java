package nl.bos.kyu6;

class MorseCodeDecoder {

    private MorseCodeDecoder() {
    }

    static String decode(String morseCode) {
        String[] wordCodes = morseCode.trim().split(" {3}");
        for (int i = 0; i < wordCodes.length; i++) {
            StringBuilder wordCode = new StringBuilder(wordCodes[i]);
            String[] letterCodes = wordCode.toString().split(" ");
            wordCode = new StringBuilder();
            for (int j = 0; j < letterCodes.length; j++) {
                letterCodes[j] = MorseCode.get(letterCodes[j]);
                wordCode.append(letterCodes[j]);
            }
            wordCodes[i] = wordCode.toString();
        }
        return String.join(" ", wordCodes);
    }
}
