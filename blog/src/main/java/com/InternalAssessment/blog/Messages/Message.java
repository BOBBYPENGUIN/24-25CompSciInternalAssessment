package com.InternalAssessment.blog.Messages;
import com.InternalAssessment.blog.Util;
public class Message {
    protected long id;
    protected String title;
    protected String content;
    public Message(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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
        return String.format("%s,%s,%s", Util.padId(id), title, content);
    }
    public String getDate(){
        return Util.getDateTime(id);
    }
    
}
