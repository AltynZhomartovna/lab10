public class getRandom {
    private int[] extendedValues; // значения
    public getRandom(int[] values, int[] weights) {
        // Сумма длин всех отрезков
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        extendedValues = new int[sum];
        int cursor = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i]; j++) {
                extendedValues[cursor++] = values[i];
            }
        }
    }
    public int getRandom() {
        int random = (int) (Math.random() * extendedValues.length);
        return extendedValues[random];
    }
    public static void main(String[] args) {
        int[] values = {20, 55, 36, 14, 87};
        int[] weights = {20, 56, 84, 35, 96};
        getRandom getRandomInstance = new getRandom(values, weights);
        // Generate and print some random values
        for (int i = 0; i < 5; i++) {
            int randomValue = getRandomInstance.getRandom();
            System.out.println("Random Value: " + randomValue);
        }
    }
}
