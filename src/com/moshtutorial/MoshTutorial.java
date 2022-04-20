package com.moshtutorial;


import java.text.NumberFormat;
import java.util.Scanner;

public class MoshTutorial {
    public static void main(String[] args) {

        int principal = 0;
        float apr = 0;
        byte years = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Number out of range");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            apr  = scanner.nextFloat();
            if (apr > 0 && apr <= 30)
                break;
            System.out.println("Number out of range");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years > 0 && years <= 30)
                break;
            System.out.println("Number out of range");
        }

        double mortgage = calculateMortgage(principal, apr, years);

        String payment = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + payment);
    }

    public static double calculateMortgage(
            int principal,
            float apr,
            byte years) {

        final byte MONTHS = 12;
        final byte PERCENT = 100;

        float monthlyInterest = apr / PERCENT / MONTHS;
        float totalPayments = years * MONTHS;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        return mortgage;
    }
}
