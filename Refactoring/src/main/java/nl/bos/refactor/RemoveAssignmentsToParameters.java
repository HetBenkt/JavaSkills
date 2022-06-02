package nl.bos.refactor;

public class RemoveAssignmentsToParameters {

    public int discount(int inputVal) {
        if (inputVal > 50) {
            inputVal -= 2;
        }
        return inputVal;
    }
}
