package com.moshtutorial;


import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class MoshTutorial {
    public static void main(String[] args) {
        final byte MONTHS = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float apr  = scanner.nextFloat();
        float monthlyInterest = apr / PERCENT / MONTHS;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int totalPayments = years * MONTHS;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        String payment = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + payment);
    }
}
