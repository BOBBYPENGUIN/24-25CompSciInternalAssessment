package com.InternalAssessment.blog;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.InternalAssessment.blog.Messages.*;
/**
 * Creates a tree of messages present. Note that, under nominal circumstances, a parent will never come after its child while parsing the database
 */
public class MessageTreeNode {
    private Message message;
    private ArrayList<MessageTreeNode> children;
    public MessageTreeNode(Message message){
        this.message = message;
    }
    public MessageTreeNode findMessageBFS(long id){
        Queue<MessageTreeNode> mainQueue = new PriorityQueue<>();
        mainQueue.add(this);
        while(mainQueue.peek() != null){
            MessageTreeNode curNode = mainQueue.poll();
            if(curNode.getMessage().getId() == id){
                return curNode;
            }
        }
        return null;
    }
    public Message getMessage(){
        return message;
    }
}
