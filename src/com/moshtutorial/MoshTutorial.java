package com.moshtutorial;

import jdk.swing.interop.SwingInterOpUtils;

import java.text.NumberFormat;
import java.util.Scanner;

public class MoshTutorial {
    final static byte MONTHS = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float apr = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) readNumber("Period (Years): ", 0, 30);

        printMortgage(principal, apr, years);

        printPaymentSchedule(principal, apr, years);
    }

    private static void printMortgage(int principal, float apr, byte years) {
        double mortgage = calculateMortgage(principal, apr, years);
        String payment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
    }

    private static void printPaymentSchedule(int principal, float apr, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS; month++) {
            double balance = calculateBalance(principal, apr, years, month);
                String remainder = NumberFormat.getCurrencyInstance().format(balance);
                System.out.println(remainder);
        }
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

        float monthlyInterest = apr / PERCENT / MONTHS;
        short totalPayments = (short)(years * MONTHS);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        return mortgage;
    }

    public static double calculateBalance(
            int principal,
            float apr,
            byte years,
            short numberOfPaymentsMade) {

        float monthlyInterest = apr / PERCENT / MONTHS;
        short totalPayments = (short)(years * MONTHS);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, totalPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1);

        return balance;
    }
}
