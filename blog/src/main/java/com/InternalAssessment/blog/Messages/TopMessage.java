package com.InternalAssessment.blog.Messages;
/**
 * This class creates a more specific type of message, used for the top-level message. As such, it allows for more flexibility and better readability
 */
public class TopMessage extends Message{
    public TopMessage(long id, String title, String content){
        super(id, 0, title, content);
    }
    public void forceMessage(){
        this.setTitle("TOP: " + this.getTitle());
    }
    
}
