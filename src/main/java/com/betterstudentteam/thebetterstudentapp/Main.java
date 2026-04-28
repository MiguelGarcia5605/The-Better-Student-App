package com.betterstudentteam.thebetterstudentapp;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalWeight = 0;
        double weightedScore = 0;

        System.out.println("=== Grade Calculator ===");

        // Ask the user the weight of a category
        while (true) {
            System.out.print("\nEnter category weight (or -1 to finish): ");
            double weight = sc.nextDouble();

            if (weight == -1) {
                break;
            }

            //Then asks them what percentage grade they have in that category.
            System.out.print("Enter your grade in this category (%): ");
            double grade = sc.nextDouble();

            totalWeight += weight;
            weightedScore += (weight * grade);
        }

        //Checks if the total weight is zero
        if (totalWeight == 0) {
            System.out.println("No categories entered.");
            return;
        }

        // Gives the user their CURRENT grade
        double currentGrade = weightedScore / totalWeight;

        System.out.printf("\nYour current grade is: %.2f%%\n", currentGrade);

        //Asks the user what their final exam weight is
        System.out.print("\nEnter final exam weight (% of total grade): ");
        double finalWeight = sc.nextDouble();

        //The user puts in their DESIRED final grade
        System.out.print("Enter your desired overall grade (%): ");
        double desiredGrade = sc.nextDouble();

        double finalWeightDecimal = finalWeight / 100.0;
        double currentWeightDecimal = totalWeight / 100.0;

        // Adjust current grade to its actual contribution
        double currentContribution = currentGrade * currentWeightDecimal;

        // Solve for required final exam score
        double neededFinal = (desiredGrade - currentContribution) / finalWeightDecimal;

        System.out.println("\nYou need " + neededFinal + " on the final exam.\n");

        if (neededFinal > 100) {
            System.out.println("It is NOT possible to reach your desired grade.");
        } else if (neededFinal <= 0) {
            System.out.println("You already secured your desired grade!");
        }

        sc.close();
    }
}