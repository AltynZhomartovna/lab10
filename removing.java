public class removing {
    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 6, 3, 9, 7, 5, 9, 7};
        int value = 6;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                continue;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
