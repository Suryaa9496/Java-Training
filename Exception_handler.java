package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter rate of interest (in percentage): ");
            double rate = scanner.nextDouble();

            System.out.print("Enter time period in years: ");
            double time = scanner.nextDouble();

            System.out.print("Enter number of times interest is compounded annually: ");
            int n = scanner.nextInt();

            double simpleInterest = (principal * rate * time) / 100;
            double compoundInterest = principal * Math.pow((1 + rate / (n * 100)), n * time) - principal;

            System.out.println("Simple Interest: " + simpleInterest);
            System.out.println("Compound Interest: " + compoundInterest);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
