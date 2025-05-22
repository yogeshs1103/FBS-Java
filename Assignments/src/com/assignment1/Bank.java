package com.assignment1;

public class Bank {
    void loanApprover(Student s){
        if(s.getPercentage()>80.0){
            System.out.println(s.getName()+" Congratulations!!,Loan Approved for 2 Lakhs");
            return;
        }
        if(s.getPercentage()>60.0 && s.getPercentage()<80.0){
            System.out.println(s.getName()+" Congratulations!!,Loan Approved for 1 Lakhs");
            return;
        }
        if(s.getPercentage()<60.0 && s.getPercentage()>40.0){
            System.out.println(s.getName()+" Congratulations!!,Loan Approved for 1 Lakhs");
            return;
        }
        System.out.println(s.getName()+" Sorry, You're not eligible for any kind of loan");
    }

    void loanApprover(Employee e){
        if(e.getAnnualSalary()>1200000.0){
            System.out.println(e.getName()+" Congratulations!!, Loan approved for you is 7 lakhs");
            return;
        }
        if(e.getAnnualSalary()>1000000.0 && e.getAnnualSalary()<1200000.0){
            System.out.println(e.getName()+" Congratulations!!, Loan approved for you is 6 lakhs");
            return;
        }
        if(e.getAnnualSalary()>600000.0 && e.getAnnualSalary()<1000000.0){
            System.out.println(e.getName()+" Congratulations!!, Loan approved for you is 5 lakhs");
            return;
        }
        if(e.getAnnualSalary()>400000.0 && e.getAnnualSalary()<600000.0){
            System.out.println(e.getName()+" Congratulations!!, Loan approved for you is 4 lakhs");
            return;
        }
        System.out.println(e.getName()+" Sorry, You're not eligible for any kind of loan");
    }


    public static void main(String[] args) {
        Bank b  = new Bank();
        Student s1 = new Student("Om",95.2,3);
        b.loanApprover(s1);

        Employee e1 = new Employee(750550,005,"Yogesh");
        b.loanApprover(e1);
    }
}
class Student{
    int rollno;
    String name;
    double percentage;

    public Student(String name, double percentage, int rollno) {
        this.name = name;
        this.percentage = percentage;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getRollno() {
        return rollno;
    }
}
class Employee{
    int id;
    String name;
    double annualSalary;

    public Employee(double annualSalary, int id, String name) {
        this.annualSalary = annualSalary;
        this.id = id;
        this.name = name;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
