package com.InternalAssessment.blog.Messages;
import com.InternalAssessment.blog.Util;
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
    public String toCsv(){
        return String.format("%s,%s,%s,%s", Util.padId(id), Util.padId(parent), title, content);
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
