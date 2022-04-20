package com.moshtutorial;

import java.text.NumberFormat;
import java.util.Scanner;

public class MoshTutorial {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float apr = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) readNumber("Period (Years): ", 0, 30);

        double mortgage = calculateMortgage(principal, apr, years);

        String payment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + payment);
    }

    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
    public static double calculateMortgage(
            int principal,
            float apr,
            byte years) {

        final byte MONTHS = 12;
        final byte PERCENT = 100;

        float monthlyInterest = apr / PERCENT / MONTHS;
        short totalPayments = (short)(years * MONTHS);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        return mortgage;
    }
}
