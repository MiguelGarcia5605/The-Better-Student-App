package com.betterstudentteam.thebetterstudentapp;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        System.out.print("Enter your attendance goal percentage: ");
        double goal = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("How many courses do you want to track? ");
        int numCourses = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nCourse #" + (i + 1));

            System.out.print("Course name: ");
            String name = sc.nextLine();

            System.out.print("Classes attended: ");
            int attended = sc.nextInt();

            System.out.print("Total classes: ");
            int total = sc.nextInt();
            sc.nextLine();

            courses.add(new Course(name, attended, total));
        }

        System.out.println("\n=== Attendance Report ===");

        for (Course c : courses) {
            double percentage = c.getPercentage();

            System.out.println("\nCourse: " + c.name);
            System.out.println("Attendance: " + c.getFraction());
            System.out.printf("Percentage: %.2f%%\n", percentage);

            if (percentage >= goal) {
                System.out.println("Status: Meeting goal");
            } else {
                System.out.println("Status: Below goal");
            }
        }

        sc.close();
    }
}