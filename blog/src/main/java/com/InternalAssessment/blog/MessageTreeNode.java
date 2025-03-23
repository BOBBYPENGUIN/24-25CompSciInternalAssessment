package com.InternalAssessment.blog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.InternalAssessment.blog.Messages.*;
/**
 * Creates a tree of messages present. Note that, under nominal circumstances, a parent will never come after its child while parsing the database. This fact handles errors associated with building the tree. 
 * In addition, the tree is only edited when going through the program. Therefore, all error checking is handled much before any data reaches this tree, and as such, is very robust and not prone to error.
 */
public class MessageTreeNode {
    private Message message;
    //Uses a list to manage the children of a node. This list is dynamic and features error handling if the child being added or looked up is null
    private ArrayList<MessageTreeNode> children =new ArrayList<>();
    public MessageTreeNode(Message message){
        this.message = message;
    }
    /**
     * Uses Breadth First Search to look through the children of a node to find a matching ID
     * @param id
     * @return
     */
    public MessageTreeNode findMessageBFS(long id){
        //Uses a dynamically implemented linkedList as a queue, to search through the children. Such a method is one of the fastest ways of searching through such a tree/
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
    public MessageTreeNode findMessageDFS(long id){
        //Implements Depth First Search to locate a message. This is optimal if the user knows that the intended message is far away from the root node
        Stack<MessageTreeNode> mainQueue = new Stack<>();
        mainQueue.add(this);
        while(mainQueue.peek() != null){
            MessageTreeNode curNode = mainQueue.pop();
            if(curNode.getMessage().getId() == id){
                return curNode;
            }
            for(MessageTreeNode childNode : curNode.children){
                mainQueue.push(childNode);
            }
        }
        return null;
    }
    public void addNode(Message otherMessage){
        MessageTreeNode parent = findMessageBFS(otherMessage.getParent());
        parent.addChild(new MessageTreeNode(otherMessage));
    }
    //Note that this function is private. This use of encapsulation makes it so that only the class can utilize this method, reducing the possiblity of errors. This method has a rather generic name, which makes this encapsulation even more necessary.
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
