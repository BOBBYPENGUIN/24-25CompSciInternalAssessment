package com.InternalAssessment.blog.People;

import java.sql.Date;
import java.util.Calendar;

public class Person {
    private int id;
    private String name;
    private long birthDate;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public long getBirthday(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTimeInMillis();
    }

    public Person(int id, String name, String lastName, long birthDate, int height) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    public Person(){

    }
    public String getName(){
        return name;
    }

/*/
    public String toString(){
        return String.format("[Person: firstName=%s\nlastName=%s\nage=%d\nheight=%d]", firstName, lastName,age, height);
    }
    public String toCsv(){
        return String.format("%d,%s,%s,%d,%d", id, firstName, lastName, age, height);
    }
    public int getId(){
        return id;
    }*/
}

