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
    private static List<Message> messages = new ArrayList<>();
    private static MessageTreeNode tree;
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
    /**
     * This method parses a CSV file, a format which is necessary for long-term data storage
     */
    public static void loadMessages() {
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
        if(messages.size() == 0){
            loadMessages();
        }
        return messages;
    }
    public static Message getMessage(String id){
        long lid = getId(id);
        Optional<Message> message = messages.stream().filter(m -> m.getId() == lid).findFirst();
        if(message.isPresent()){
            return message.get();
        }
        throw new RuntimeException("Error Could not find");
    }
    public static Message saveMessage(Message message){
        messages.add(message);
        tree.addNode(message);
        try(PrintWriter out = new PrintWriter(new File("blog\\src\\main\\resources\\data\\messages.csv"))) {
            for(var m : messages){
                out.println(m.toCsv());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        loadMessages();
        return message;
    }
    public static void buildTree(){
        getMessages();
        tree = new MessageTreeNode(messages.get(0));
        for(int i = 1; i < messages.size(); i++){
            tree.addNode(messages.get(i));
        }
    }
    public static MessageTreeNode getTree(){
        if(tree == null){
            buildTree();
        }
        return tree;
    }
}
