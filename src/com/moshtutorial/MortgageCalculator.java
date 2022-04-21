package com.moshtutorial;

public class MortgageCalculator {
    public final static byte MONTHS = 12;
    public final static byte PERCENT = 100;
    private int principal;
    private float apr;
    private byte years;

    public MortgageCalculator(int principal, float apr, byte years) {
        this.principal = principal;
        this.apr = apr;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = apr / PERCENT / MONTHS;
        short totalPayments = (short)(years * MONTHS);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = apr / PERCENT / MONTHS;
        short totalPayments = (short)(years * MONTHS);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, totalPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1);

        return balance;
    }

    public byte getYears() {
        return years;
    }
}
