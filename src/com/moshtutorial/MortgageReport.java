package com.moshtutorial;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS; month++) {
            double balance = calculator.calculateBalance(month);
                String remainder = NumberFormat.getCurrencyInstance().format(balance);
                System.out.println("Balance after payment " + month +": " + remainder);
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String payment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
    }
}
