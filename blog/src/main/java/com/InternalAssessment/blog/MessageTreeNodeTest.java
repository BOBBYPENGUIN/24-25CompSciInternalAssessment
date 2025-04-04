package com.InternalAssessment.blog;
import java.util.*;

import com.InternalAssessment.blog.Messages.*;
public class MessageTreeNodeTest {
    public void main(String[] args) {
        Util.buildTree();
        long mToGet = 1742327122858L;
        System.out.println(Util.getTree().findMessageBFS(mToGet).getMessage().toCsv("—ƒ—"));
    }

    
}
