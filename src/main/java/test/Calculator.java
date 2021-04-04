package test;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Calculator {

    private static final double interests = 17;


    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2019, 5, 18);
        LocalDate end = LocalDate.of(2020, 5, 18);
        Double beginBalance = Double.valueOf(0);
        Calculator a = new Calculator();


        a.printStatement(a.initSchedule(start, end, beginBalance));

    }

    public void printStatement(List<Statement> statements) {
        NumberFormat kr = NumberFormat.getCurrencyInstance(Locale.KOREA);
        for (Statement statement : statements) {
            System.out.println(statement.getId() + ", " + statement.getDate() + ", " + kr.format(statement.getBalance()) + ", " + kr.format(statement.getDailyIntAmount()) + ", " + kr.format(statement.getCurrentIntAmount()));
        }
    }

    public List<Statement> initSchedule(LocalDate start, LocalDate end, Double currentBalance) {


        Map<LocalDate, Double> income = Map.of(
                LocalDate.of(2019, 5, 18), Double.valueOf(79286931.02),
                LocalDate.of(2019, 5, 20), Double.valueOf(-1700000),
                LocalDate.of(2019, 6, 18), Double.valueOf(3433069),
                LocalDate.of(2019, 6, 26), Double.valueOf(1979999.98),
                LocalDate.of(2019, 7, 4), Double.valueOf(4000000),
                LocalDate.of(2019, 10, 29), Double.valueOf(6500000),
                LocalDate.of(2019, 12, 30), Double.valueOf(3500000),
                LocalDate.of(2020, 1, 22), Double.valueOf(3000000)
        );


        double days = start.isLeapYear() ? 366 : 365;

        double dailyInt = interests / days;

        List<Statement> statements = new ArrayList<>();

        int i = 1;
        double currentIntAmount = 0;
        double dailyIntAmount = 0;
        for (LocalDate s = start; s.isBefore(end); s = s.plusDays(1)) {

            if (income.get(s) != null) {
                currentBalance += income.get(s);
            }

            dailyIntAmount = (currentBalance * dailyInt) / 100;
            currentIntAmount += dailyIntAmount;


            Statement temp = new Statement(i, s, currentBalance, dailyIntAmount, currentIntAmount);
            statements.add(temp);
            i++;
        }
        return statements;
    }


    public class Statement {

        private int id;
        private LocalDate date;
        private double balance;
        private double dailyIntAmount;
        private double currentIntAmount;

        public Statement() {
        }

        public Statement(int id, LocalDate date, double balance, double dailyIntAmount, double currentIntAmount) {
            this.id = id;
            this.date = date;
            this.balance = balance;
            this.dailyIntAmount = dailyIntAmount;
            this.currentIntAmount = currentIntAmount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getDailyIntAmount() {
            return dailyIntAmount;
        }

        public void setDailyIntAmount(double dailyIntAmount) {
            this.dailyIntAmount = dailyIntAmount;
        }

        public double getCurrentIntAmount() {
            return currentIntAmount;
        }

        public void setCurrentIntAmount(double currentIntAmount) {
            this.currentIntAmount = currentIntAmount;
        }
    }
}