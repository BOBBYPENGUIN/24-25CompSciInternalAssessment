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
        try {
            Message message = Util.getMessage(id);
            model.addAttribute("message", message);
        } catch (RuntimeException e){
            model.addAttribute("error", e.getMessage());
        }
        return "item";
    }
}
