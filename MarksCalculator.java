import java.util.Scanner;

public class MarksCalculator {
    public static void main(String[] args) {
        // Using try-with-resources to ensure Scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {

            // Input: Taking marks for 5 subjects (you can change the number of subjects as needed)
            int numSubjects = 5;
            int[] marks = new int[numSubjects];
            int totalMarks = 0;

            // Collect marks
            System.out.println("Enter marks obtained in each subject (out of 100):");
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
                totalMarks += marks[i];
            }

            // Calculate total and average
            double averagePercentage = (double) totalMarks / numSubjects;

            // Grade calculation
            String grade;
            if (averagePercentage >= 90) {
                grade = "A+";
            } else if (averagePercentage >= 80) {
                grade = "A";
            } else if (averagePercentage >= 70) {
                grade = "B";
            } else if (averagePercentage >= 60) {
                grade = "C";
            } else if (averagePercentage >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display results
            System.out.println("\nTotal Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
        }
    }
}
