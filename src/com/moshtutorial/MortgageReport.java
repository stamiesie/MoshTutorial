package com.moshtutorial;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(int principal, float apr, byte years) {
        double mortgage = MoshTutorial.calculateMortgage(principal, apr, years);
        String payment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
    }

    public static void printPaymentSchedule(int principal, float apr, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MoshTutorial.MONTHS; month++) {
            double balance = MoshTutorial.calculateBalance(principal, apr, years, month);
                String remainder = NumberFormat.getCurrencyInstance().format(balance);
                System.out.println("Balance after payment " + month +": " + remainder);
        }
    }
}
