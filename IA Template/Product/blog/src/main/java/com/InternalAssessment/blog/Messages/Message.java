package com.InternalAssessment.blog.Messages;
import com.InternalAssessment.blog.Util;
/**
 * Implements a message framework. This serves as a hierarchical composite data structure by allowing multiple values to be stored inside a single class. The parent, in this case, is stored as the ID of the parent. This makes the record easier to understand without loss of data._
 */
public class Message {
    protected long id;
    protected long parent;
    protected String title;
    protected String content;
    public Message(long id, long parent, String title, String content) {
        this.id = id;
        this.parent = parent;
        this.title = title;
        this.content = content;
    }
    public Message() {
        //TODO Auto-generated constructor stub
    }
    public Message getMessage(){
        return this;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String toCsv(String deliminator){
        return String.format("%s%s%s%s%s%s%s", Util.padId(id), deliminator, Util.padId(parent), deliminator, title, deliminator, content);
    }
    public String getDate(){
        return Util.getDateTime(id);
    }
    public long getParent() {
        return parent;
    }
    public void setParent(long parent) {
        this.parent = parent;
    }

    
}
