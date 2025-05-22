package com.case1;

public class Transactions {
    int id;
    String type;
    Date date;
    double amt;
    double balance;

    public Transactions(){
        this.amt=000.0;
        this.type="Not given";
        this.date=new Date(11,01,2002);
        this.balance=000.0;
        this.id=000;
    }
    public Transactions(double amt, double balance, Date date, int id, String type) {
        this.amt = amt;
        this.balance = balance;
        this.date = date;
        this.id = id;
        this.type = type;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Amount: " + amt +
                "\nTransaction Id: " + id +
                "\nType: " + type +
                "\nDate: " + date +
                "\nBalance: " + balance;
    }
}
