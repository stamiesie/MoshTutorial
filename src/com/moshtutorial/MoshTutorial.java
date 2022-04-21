package com.moshtutorial;

public class MoshTutorial {
    final static byte MONTHS = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float apr = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 0, 30);

        MortgageReport.printMortgage(principal, apr, years);
        MortgageReport.printPaymentSchedule(principal, apr, years);
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
