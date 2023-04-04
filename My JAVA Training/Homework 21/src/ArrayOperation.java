import java.util.Random;

public class ArrayOperation {
    public static double divideByFirstElement(int index) throws ArrayIndexOutOfBoundsException, ArithmeticException {
        int[] array = new int[new Random().nextInt(30) + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(31);
        }

        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds.");
        }

        if (array[0] == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        return (double) array[index] / array[0];
    }
}
