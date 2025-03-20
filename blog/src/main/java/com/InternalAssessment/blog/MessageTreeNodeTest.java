package com.InternalAssessment.blog;
import java.util.*;

import com.InternalAssessment.blog.Messages.*;
public class MessageTreeNodeTest {
    public static void main(String[] args) {
        Util.loadMessages();
        List<Message> theList = Util.getMessages(); 
        MessageTreeNode treeNode = new MessageTreeNode(theList.get(0));
        System.out.println(treeNode.findMessageBFS(0).getMessage().getTitle());
        for(int i = 1; i < theList.size(); i++){
            treeNode.addNode(theList.get(i));
        }
        long mToGet = 1742327122858L;
        System.out.println(treeNode.findMessageBFS(mToGet).getMessage().getTitle());
    }

    
}
