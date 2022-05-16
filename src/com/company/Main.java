package com.company;

import com.company.Classes.Time;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Time t1 = new Time(23,5,25);
        Time t2 = new Time(18,45,35);
        Time t3 = new Time(5,7,4);
        Time t4 = new Time(13,58,40);
        System.out.println(t1);
        System.out.println(t1.TimesOfDay());
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        Time T1 = t1.Plus(t3);
        Time T2 = t4.Plus(t2);
        System.out.println(T2.isSmaller(T1));
    }
}
