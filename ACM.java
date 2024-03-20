import java.io.*;
import java.util.*;
public class ACM {
    static int calculatePenalty(int[] times) {
        int totalPenalty = 0;
        int penaltyTime = 0;
        for (int time : times) {
            totalPenalty += penaltyTime;
            penaltyTime += time;
        }
        return totalPenalty;
    }
    static int winner(int N, int[] taskTimes) {
        int[] fifthYearTimes = Arrays.copyOf(taskTimes, N);
        int[] thirdYearTimes = new int[N];
        int[] freshmanTimes = new int[N];

        // Reverse the task times for the third-year student
        for (int i = 0; i < N; i++) {
            thirdYearTimes[i] = taskTimes[N - 1 - i];
        }

        // Sort the task times for the freshman student
        System.arraycopy(taskTimes, 0, freshmanTimes, 0, N);
        Arrays.sort(freshmanTimes);

        int fifthYearPenalty = calculatePenalty(fifthYearTimes);
        int thirdYearPenalty = calculatePenalty(thirdYearTimes);
        int freshmanPenalty = calculatePenalty(freshmanTimes);
        if (fifthYearPenalty < thirdYearPenalty && fifthYearPenalty < freshmanPenalty) {
            return 5;
        } else if (thirdYearPenalty < freshmanPenalty) {
            return 3;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            int N = scanner.nextInt();
            int[] taskTimes = new int[N];
            for (int i = 0; i < N; i++) {
                taskTimes[i] = scanner.nextInt();
            }
            scanner.close();
            int winnerIndex = winner(N, taskTimes);
            File outputFile = new File("output.txt");
            FileWriter writer = new FileWriter(outputFile);
            writer.write(Integer.toString(winnerIndex));
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error writing to output file.");
            e.printStackTrace();
        }
    }
}
