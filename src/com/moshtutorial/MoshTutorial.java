package com.moshtutorial;


import java.text.NumberFormat;
import java.util.Scanner;

public class MoshTutorial {
    public static void main(String[] args) {

        final byte MONTHS = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int totalPayments = 0;

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
            float apr  = scanner.nextFloat();
            if (apr > 0 && apr <= 30) {
                monthlyInterest = apr / PERCENT / MONTHS;
                break;
            }
            System.out.println("Number out of range");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years > 0 && years <= 30) {
                totalPayments = years * MONTHS;
                break;
            }
            System.out.println("Number out of range");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, totalPayments)
                / (Math.pow(1 + monthlyInterest, totalPayments) - 1));

        String payment = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + payment);
    }
}
