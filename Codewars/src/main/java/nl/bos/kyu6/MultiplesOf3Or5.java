package nl.bos.kyu6;

class MultiplesOf3Or5 {

    int solution(int number) {
        int result = 0;
        for (int i = 3; i < number; i++) {
            if (i % 3 == 0) {
                result += i;
                continue;
            }
            if (i % 5 == 0) {
                result += i;
            }
        }
        return result;
    }
}
