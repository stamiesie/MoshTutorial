//Separation of Concerns - this class is all about calculation
package com.moshtutorial;

public class MortgageCalculator {
    private final static byte MONTHS = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float apr;
    private byte years;

//    Constructor
    public MortgageCalculator(int principal, float apr, byte years) {
        this.principal = principal;
        this.apr = apr;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short totalPayments = getTotalPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short totalPayments = getTotalPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, totalPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1);

        return balance;
    }
    public double[] getRemainingBalances() {
        var balances = new double[getTotalPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }

    private float getMonthlyInterest() {
        return apr / PERCENT / MONTHS;
    }

    private short getTotalPayments() {
        return (short) (years * MONTHS);
    }
}
