package com.case1;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Accounts {
    String accNo;
    String accHolderName;
    double balance;
    int depositCount=0;
    int withdrawnCount=0;
    String accType;
    ArrayList<Transactions> transactions = new ArrayList<>();
    int transactionID=100;

    public Accounts() {
        this.accHolderName="Not Given";
        this.accNo="000000";
        this.balance=000.0;
    }
    public Accounts(String accHolderName, String accNo, double balance) {
        this.accHolderName = accHolderName;
        this.accNo = accNo;
        this.balance = balance;
    }

    abstract double calculateInterest();
    abstract void endOfDayReport();

    public void deposit(double amt,Date date){
        transactionID++;
        this.balance = balance + amt;
        transactions.add(new Transactions(amt,balance,date,transactionID,"Deposited"));
        System.out.println("Amount deposited: "+amt);
        System.out.println("Current Balance: "+balance);
        System.out.println();
        depositCount++;
    }
//    public void deposit(double amt,){
//        System.out.println("Amount deposited:"+amt);
//        System.out.println("Date:"+date);
//    }

    public void withdrawn(double amt,Date date){
        transactionID++;
        this.balance = balance - amt;
        transactions.add(new Transactions(amt,balance,date,transactionID,"Withdrawn"));
        System.out.println("Amount withdrawn: "+amt);
        System.out.println("Current Balance: "+balance);
        System.out.println();
        withdrawnCount++;
    }
//    public void withdrawn(double amt,){
//        System.out.println("Amount withdrawn:"+amt);
//        System.out.println("Date:"+date);
//    }

//    public void getTransactions(){
//        for (int i = 0; i <transactions.size(); i++) {
//            if(transactions.get(i)>0){
//                System.out.println("Deposited = "+transactions.get(i));
//            }else{
//                System.out.println("Withdrawn = "+transactions.get(i));
//            }
//        }
//        System.out.println("Current Balance: "+balance);
//        System.out.println();
//    }
    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void accountStatus(){
        System.out.println("Account is Active:");
    }

    public void getTransactions(){
        for (Transactions transaction : transactions) {
            System.out.println(transaction);
            System.out.println();
        }
    }
    @Override
    public String toString() {
        return "Account Holder Name='" + accHolderName +
                "\nAccount Number =" + accNo +
                "\nBalance=" + balance;
    }
}// class accounts ends here

class SavingAccount extends Accounts{
    double MIN_BALANCE=1000;
    int count=0;

    public SavingAccount() {
        this.accHolderName="not given";
        this.balance=000.0;
        this.accNo="000000";
        this.accType="Savings Account";
        count++;
    }
    public SavingAccount(String accHolderName, String accNo, double balance) {
        super(accHolderName, accNo, balance);
        this.accType="Savings Account";
        count++;
    }

    public void endOfDayReport(){
        System.out.println("Number of Savings Accounts opened today: "+count);
        System.out.println("Number of deposits in Saving Accounts:"+depositCount);
        System.out.println("Number of withdrawn in Saving Accounts: "+withdrawnCount);
        System.out.println();
    }
    public double calculateInterest(){
        balance = balance + balance*0.05;
        return balance;
    }

    public void withdrawn(double amt,Date date){
        if(balance-amt > MIN_BALANCE){
            transactionID++;
            balance = balance - amt;
            transactions.add(new Transactions(amt,balance,date,transactionID,"withdrawn"));
            System.out.println("Amount withdrawn: "+amt);
            System.out.println("Current Balance: "+balance);
            System.out.println();
            withdrawnCount++;
        }else{
            System.out.println("Cannot Withdrawn amount");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Account Holder Name:" + accHolderName +
                "\nAccount No:" + accNo +
                "\nAccount Type:" + accType +
                "\nBalance:" + balance;
    }
}// class savings account ends here

class SalaryAccount extends Accounts{
    ArrayList<Date> transactionDate = new ArrayList<>();
    Date date;
    int count;

    public SalaryAccount() {
        super();
        this.date=new Date(5,4,2025);
    }
    public SalaryAccount(String accHolderName, String accNo, double balance, Date date) {
        super(accHolderName, accNo, balance);
        this.date = date;
        transactionDate.add(date);
        count++;
    }

    @Override
    double calculateInterest() {
        balance = balance + balance*0.07;
        return balance;
    }

    @Override
    void endOfDayReport() {
        System.out.println("No of salary account opened:"+count);
        System.out.println("No of withdrawn done:"+withdrawnCount);
        System.out.println("No of deposit done:"+depositCount);
    }

    @Override
    public void accountStatus(){
        int countDays = 0;
        LocalDate today = LocalDate.now();
        if(transactionDate.getLast().getYear()-today.getYear()==0){
            for (int i = transactionDate.getLast().getMonth(); i<=today.getMonthValue(); i++) {
                for (int j =transactionDate.getLast().getDay() ; j < 30; j++) {
                    countDays++;
                }
            }
        }
        if(count>=60){
            System.out.println("Account is Frozen");
        }else{
            System.out.println("Account is Active");
        }
    }
}// class salary account ends here

class CurrentAccount extends Accounts{
    double overDraftLimit;
    int count=0;

    public CurrentAccount() {
        super();
        overDraftLimit = 00000.0;
        count++;
    }
    public CurrentAccount(String accHolderName, String accNo, double balance, double overDraftLimit) {
        super(accHolderName, accNo, balance);
        this.overDraftLimit = overDraftLimit;
        count++;
    }

    public double calculateInterest(){
        balance = balance + balance*0.08;
        return balance;
    }
    public void endOfDayReport(){
        System.out.println("No of Salary Accounts opened: "+count);
        System.out.println("No of withdrawn: "+withdrawnCount);
        System.out.println("No of Deposits: "+depositCount);
    }

    @Override
    public void withdrawn(double amt,Date date) {
        if(amt>balance){
            balance = balance + overDraftLimit;
            if(amt>balance){
                System.out.println("Cannot withdrawn,exceeding the over draft limit");
            }else{
                System.out.println("Amount withdrawn: "+amt);
                balance = balance - amt - overDraftLimit;
                System.out.println("Current Balance: "+balance);
                transactions.add(new Transactions(amt,balance,date,transactionID,"withdrawn"));
                withdrawnCount++;
            }
        }else{
            System.out.println("Amount withdrawn: "+amt);
            balance = balance - amt;
            System.out.println("Current Balance: "+balance);
            withdrawnCount++;
            transactionID++;
        }
    }
}//current account ends here

class LoanAccount extends Accounts{
    double loanAmt;
    int count=0;

    public LoanAccount(){
        super();
        this.loanAmt = 0.0;
        count++;
    }
    public LoanAccount(String accHolderName, String accNo, double loanAmt) {
        super(accHolderName, accNo, -loanAmt);
        this.loanAmt = -loanAmt;
        count++;
    }

    public double calculateInterest(){
        loanAmt = loanAmt + loanAmt*0.10;
        return loanAmt;
    }
    public void endOfDayReport(){
        System.out.println("Number of loan accounts opened: "+count);
        System.out.println("Number of Deposits into loan account: "+depositCount);
        if(loanAmt==0.0){
            System.out.println("Loan is cleared");
        }else{
            System.out.println("Loan Amount is pending: "+loanAmt);
        }
    }

    public void deposit(double amt,Date date){
            transactionID++;
            this.loanAmt = loanAmt + amt;
            transactions.add(new Transactions(amt,loanAmt,date,transactionID,"Deposited"));
            System.out.println("Amount deposited: "+amt);
            System.out.println("Loan Remaining: "+loanAmt);
            System.out.println();
            depositCount++;
    }
}//loan account ends here