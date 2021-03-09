package org.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {
    @RequestMapping(path = "/hello")
    public String getHello(){
        return "Hi. How are you? Do you like Java?";
    }
    @RequestMapping(path = "/hello/sk")
    public String getHelloSk(){
        return "Dobrý, ako sa máme ujo/teta?";
    }
    @RequestMapping(path = "/time")
    public String currentTime(){
        return  new Date().toString();
    }
    @RequestMapping(path = "/hi")
    public String getHi(){
        return  "<h2>Hi user. What are u doin?</h2>";
    }
    @RequestMapping(path = "/hi/{username}")
    public String getHiWithName(@PathVariable String username){
        return  "<a href=http://localhost:8080/nameverification><h2>Hi "+username+". What are u doin?</h2></a>";
    }
    @RequestMapping(path = "/data", method = RequestMethod.POST)
    public String getHiTest(){
        return  "<h2>This is a test.</h2>";
    }
    @RequestMapping(path = "/nameverification")
    public String nameVerification(){
        return  "<h2>This is your name, right? =]</h2>";
    }
}
