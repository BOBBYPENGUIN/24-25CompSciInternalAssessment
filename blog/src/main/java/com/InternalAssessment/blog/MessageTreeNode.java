package com.InternalAssessment.blog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.InternalAssessment.blog.Messages.*;
/**
 * Creates a tree of messages present. Note that, under nominal circumstances, a parent will never come after its child while parsing the database
 */
public class MessageTreeNode {
    private Message message;
    private ArrayList<MessageTreeNode> children =new ArrayList<>();
    public MessageTreeNode(Message message){
        this.message = message;
    }
    public MessageTreeNode findMessageBFS(long id){
        Queue<MessageTreeNode> mainQueue = new LinkedList<>();
        mainQueue.add(this);
        while(mainQueue.peek() != null){
            MessageTreeNode curNode = mainQueue.poll();
            if(curNode.getMessage().getId() == id){
                return curNode;
            }
            for(MessageTreeNode childNode : curNode.children){
                mainQueue.add(childNode);
            }
        }
        return null;
    }
    public void addNode(Message otherMessage){
        MessageTreeNode parent = findMessageBFS(otherMessage.getParent());
        parent.addChild(new MessageTreeNode(otherMessage));
    }
    private void addChild(MessageTreeNode child){
        children.add(child);
    }
    public Message getMessage(){
        return message;
    }
    public ArrayList<MessageTreeNode> getChildren(){
        return children;
    }
}
