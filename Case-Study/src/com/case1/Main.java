package com.case1;

public class Main {
    public static void main(String[] args) {
        Accounts a1 = new LoanAccount("Yogesh Sawairam","100234",20000);
        a1.deposit(5000,new Date(5,21,2025));
        a1.getTransactions();
    }
    public static void main1(String[] args) {
        Accounts a1 = new CurrentAccount("Yogesh Sawairam","100653",10000,5000);
        a1.withdrawn(15000,new Date(11,01,2025));
        a1.deposit(2000,new Date(26,02,2025));
        a1.getTransactions();
    }
    public static void main2(String[] args) {
        Accounts a1 = new SalaryAccount("Yogesh Sawairam","100611",69200,new Date(18,1,2025));
        a1.withdrawn(2000,new Date(5,4,2025));
        a1.accountStatus();
    }
}
