package com.InternalAssessment.blog;
import java.util.*;

import com.InternalAssessment.blog.Messages.*;
public class MessageTreeNodeTest {
    public static void main(String[] args) {
        Util.buildTree();
        long mToGet = 1743795368182L;
        System.out.println(Util.getTree().findMessageRecursive(mToGet, Util.getTree()).getMessage().toCsv("—ƒ—"));
    }

    
}
