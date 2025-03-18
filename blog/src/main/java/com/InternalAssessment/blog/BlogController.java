package com.InternalAssessment.blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.InternalAssessment.blog.Messages.Message;
import com.InternalAssessment.blog.People.Person;

import java.util.List;
@Controller
public class BlogController {
    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("message", "Hello World!");
        model.addAttribute("message2", "3!");
        return "home";
    }
    @GetMapping("/all")
    public String getPersons(Model model){
        List<Message> messages = Util.getMessages();
        model.addAttribute("messages", messages);
        return "allMessages";
    }
    @GetMapping("/message/{id}")
    public String getSingleMessage(Model model, @PathVariable String id){
        Message message = Util.getMessage(id);
        try {
            model.addAttribute("message", message);
        } catch (RuntimeException e){
            model.addAttribute("error", e.getMessage());
        }
        Message getMessage = new Message();
        getMessage.setId(System.currentTimeMillis());
        getMessage.setParent(message.getId());
        model.addAttribute("getMessage", getMessage);
        return "item";
    }
    @GetMapping("/newmessage")
    public String addPerson(Model model){
        Message message = new Message();
        model.addAttribute("message", message);
        return "newmessage";
    }
    @PostMapping("/sendMessage")
    public String getMessage(Model model, Message message){
        System.out.println(message.toCsv());
        Util.saveMessage(message);
        return "home";
    }
}
