import java.util.Arrays;
public class remove {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 6, 3, 9, 7, 5, 9, 7};
        int valueToRemove = 6;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToRemove) {
                count++;
            }
        }
        int[] newArr = new int[arr.length - count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != valueToRemove) {
                newArr[index] = arr[i];
                index++;
            }
        }
        System.out.println("Array after removing " + valueToRemove + ": " + Arrays.toString(newArr));
    }
}
