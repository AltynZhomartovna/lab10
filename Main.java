import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt(); // Number of refrigerators
        int M = scanner.nextInt(); // Number of microwaves
        int N = scanner.nextInt(); // Number of televisions
        Product[] refrigerators = readProducts(scanner, L, 1);
        Product[] microwaves = readProducts(scanner, M, L + 1);
        Product[] televisions = readProducts(scanner, N, L + M + 1);
        // Find the most profitable combination
        int maxDiscount = 0;
        int fridgeId = 0;
        int microwaveId = 0;
        int tvId = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    int discount = refrigerators[i].getDiscountedPrice() + microwaves[j].getDiscountedPrice() + televisions[k].getDiscountedPrice();
                    if (discount > maxDiscount) {
                        maxDiscount = discount;
                        fridgeId = refrigerators[i].id;
                        microwaveId = microwaves[j].id;
                        tvId = televisions[k].id;
                    } else if (discount == maxDiscount) {
                        if (refrigerators[i].price + microwaves[j].price + televisions[k].price <
                                refrigerators[fridgeId - 1].price + microwaves[microwaveId - L - 1].price + televisions[tvId - L - M - 1].price) {
                            fridgeId = refrigerators[i].id;
                            microwaveId = microwaves[j].id;
                            tvId = televisions[k].id;
                        }
                    }
                }
            }
        }

        // Output result
        System.out.println(fridgeId + " " + microwaveId + " " + tvId);

        scanner.close();
    }
    private static Product[] readProducts(Scanner scanner, int count, int startId) {
        Product[] products = new Product[count];
        for (int i = 0; i < count; i++) {
            int price = scanner.nextInt();
            int discount = scanner.nextInt();
            products[i] = new Product(startId + i, price, discount);
        }
        return products;
    }
}
