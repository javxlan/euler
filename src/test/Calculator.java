package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calculator {

    private static final int interests = 17;

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2019, 5, 18);
        LocalDate end = LocalDate.of(2019, 5, 20);
        Double beginBalance = Double.valueOf(100000000);
        Calculator a = new Calculator();

        a.printStatement(a.initSchedule(start, end, beginBalance));


    }

    public void printStatement(List<Statement> statements) {
        for (Statement statement : statements) {
            System.out.println(statement.getId() + " " + statement.getDate() + " " + statement.getBalance() + " " + statement.getDailyIntAmount());
        }
    }

    public List<Statement> initSchedule(LocalDate start, LocalDate end, Double currentBalance) {

        int days = start.isLeapYear() ? 366 : 365;

        double dailyInt = interests / days;

        List<Statement> statements = new ArrayList<>();

        int i = 1;
        for (LocalDate s = start; s.isBefore(end); s = s.plusDays(1)) {
            double dailyIntAmount = (currentBalance * dailyInt) / 100;
            Statement temp = new Statement(i, s, currentBalance, dailyIntAmount);
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

        public Statement() {
        }

        public Statement(int id, LocalDate date, double balance, double dailyIntAmount) {
            this.id = id;
            this.date = date;
            this.balance = balance;
            this.dailyIntAmount = dailyIntAmount;
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
    }
}

