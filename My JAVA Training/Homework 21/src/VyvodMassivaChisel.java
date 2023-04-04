import java.util.Arrays;

public class VyvodMassivaChisel {

    public static void main(String[] args) {
        SelfExpandingArray arr = new SelfExpandingArray();
        arr.fillArray();
    }

    static class SelfExpandingArray {

        private Integer[] arr = new Integer[1];

        public void fillArray() {
            int i = 0;
            int value = 2147483638;

            while (true) {
                try {
                    arr[i] = value;
                    System.out.println("Элемент " + i + " равен " + arr[i]);
                    i++;
                    value++;
                    if (i == arr.length) {
                        arr = Arrays.copyOf(arr, arr.length * 2);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Произошло исключение переполнения массива: " + e.getMessage());
                    break;
                } catch (Exception e) {
                    System.out.println("Произошло другое исключение: " + e.getMessage());
                    break;
                }
            }

            System.out.println("Текущее состояние массива: " + Arrays.toString(arr));
        }
    }
}
