package com.assignment1;

public class Complex {
    int real;
    int imaginary;

    public Complex() {
    }

    public Complex(int imaginary, int real) {
        this.imaginary = imaginary;
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public int getReal() {
        return real;
    }

    Complex add(Complex c1, Complex c2){
        Complex temp = new Complex();
        temp.setImaginary(c1.getImaginary()+c2.getImaginary());
        temp.setReal(c1.getReal() + c2.getReal());

        return temp;
    }
    Complex add(Complex c,int num){
        c.setReal(c.getReal()+num);
        c.setImaginary(c.getImaginary()+num);
        return c;
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(10,12);
        Complex c2 = new Complex(11,13);
        Complex c3 = c1.add(c1,c2);
        System.out.println(c3.getReal());
        System.out.println(c3.getImaginary());
        int num = 10;
        c3 = c1.add(c1,num);
        System.out.println(c3.getReal());
        System.out.println(c3.getImaginary());
    }
}
