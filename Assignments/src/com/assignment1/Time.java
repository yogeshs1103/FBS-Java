package com.assignment1;

public class Time {
    int hr,min,sec;

    public Time() {
    }

    public Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    void add(Time t1, Time t2){
//        System.out.println("Time Time");
        Time temp = new Time();
        temp.setHr(t1.getHr()+t2.getHr());
        temp.setMin(t1.getMin()+t2.getMin());
        temp.setSec(t1.getSec()+t2.getSec());

        System.out.println(temp.getHr()+":"+temp.getMin()+":"+temp.getSec());
    }

    void add(Time t1, int num){
//        System.out.println("Time:int");
        Time temp = new Time();
        temp.setHr(t1.getHr()+num);
        temp.setMin(t1.getMin()+num);
        temp.setSec(t1.getSec()+num);

        System.out.println(temp.getHr()+":"+temp.getMin()+":"+temp.getSec());
    }

    public static void main(String[] args) {
        Time t1 = new Time(15,12,10);
        Time t2 = new Time(12,15,10);

        t1.add(t1,t2);
        int num=8;
        t2.add(t2,num);
    }
}
