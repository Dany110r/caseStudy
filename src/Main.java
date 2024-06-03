import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + "-answers.txt"))) {
            for (int i = 0; i < 5; i++) {
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                System.out.print("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ");
                int userAnswer = scanner.nextInt();

                int correctAnswer = num1 + num2;
                boolean isCorrect = userAnswer == correctAnswer;

                writer.write("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = " + userAnswer + " (Correct: " + isCorrect + ")\n");
            }

            System.out.println("Assessment results saved to " + name + "-answers.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}