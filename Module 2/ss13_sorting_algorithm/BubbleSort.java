package ss13_sorting_algorithm;

public class BubbleSort {
    static int[] array = {5, 2, 6, 7, 3, 9, 1};
    public static void bubbleSort(int[] array) {
        boolean needNextPass = true;
        for (int k = 0; k < array.length - 1 && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < array.length - 1 - k; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        bubbleSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
