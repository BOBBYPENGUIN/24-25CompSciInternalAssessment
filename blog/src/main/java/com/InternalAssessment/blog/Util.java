package com.InternalAssessment.blog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.InternalAssessment.blog.Messages.Message;

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
                messages.add(new Message(Long.parseLong(fields[0]), Long.parseLong(fields[1]), fields[2], fields[3]));

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
    public static Message getMessage(String id){
        long lid = getId(id);
        List<Message> messages = new ArrayList<>();
        loadMessages(messages);
        Optional<Message> message = messages.stream().filter(m -> m.getId() == lid).findFirst();
        if(message.isPresent()){
            return message.get();
        }
        throw new RuntimeException("Error Could not find");
    }
    public static Message saveMessage(Message message){
        List<Message> messages = new ArrayList<>();
        loadMessages(messages);
        messages.add(message);

        try(PrintWriter out = new PrintWriter(new File("blog\\src\\main\\resources\\data\\messages.csv"))) {
            for(var m : messages){
                out.println(m.toCsv());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
