package TasksCodeSoft;// STUDENT GRADE CALCULATOR

import java.util.Scanner;  

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSub = scanner.nextInt();
        
        // Declare an array to store marks for each subject
        int[] marks = new int[numSub];
        
        // Input marks for each subject
        int totalMarks = 0;
        for (int i = 0; i < numSub; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];  // Sum up the marks
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSub;

        // Determine the grade based on the average percentage
        String grade = "";
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B+";
        } else if (averagePercentage >= 60) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSub * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
