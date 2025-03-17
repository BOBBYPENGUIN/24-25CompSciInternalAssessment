package com.InternalAssessment.blog;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.InternalAssessment.blog.Messages.Message;
import com.InternalAssessment.blog.People.Person;

public class Util {
    public static long dateToMilliseconds(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTimeInMillis();
    }
    public static String padId(long id){
        return String.format("%019d", id);
    }
    public static long getId(String id){
        return Long.parseLong(id);
    }
    public static String getDateTime(long id){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");    
        Date resultdate = new Date(id);  
        return sdf.format(resultdate); 
    }
    public static void loadMessages(List<Message> messages) {
        try(Scanner in = new Scanner(new File("blog\\src\\main\\resources\\data\\messages.csv"))) {
            while(in.hasNextLine()){
                String line = in.nextLine();
                String fields[] = line.split(",");
                messages.add(new Message(Long.parseLong(fields[0]), fields[1], fields[2]));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Message> getMessages(){
        List<Message> messages = new ArrayList<>();
        loadMessages(messages);
        return messages;
    }
}
