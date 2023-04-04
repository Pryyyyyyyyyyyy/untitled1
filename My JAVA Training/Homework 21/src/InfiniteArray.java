import java.util.Arrays;
public class InfiniteArray {
    public static void main(String[] args) {
        try {
            fillArray();
        } catch (ArrayOverflowException e) {
            System.out.println("Произошло исключение переполнения массива: " + e.getMessage());
        }
    }

    private static void fillArray() throws ArrayOverflowException {
        Integer[] array = new Integer[1];
        array[0] = 2147483638;
        int i = 1;
        while (true) {
            try {
                array = Arrays.copyOf(array, i + 1);
                array[i] = Math.addExact(array[i-1], 1);
                i++;
            } catch (OutOfMemoryError e) {
                throw new ArrayOverflowException("Превышен максимальный размер массива");
            } catch (ArithmeticException e) {
                throw new ArrayOverflowException("Произошло целочисленное переполнение");
            }
        }
    }

    static class ArrayOverflowException extends Exception {
        public ArrayOverflowException(String message) {
            super(message);
        }
    }
}
