package org.example.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JokeController {
    String joke1 = "I ate a clock yesterday, it was very time-consuming.";
    String joke2 = "Where do you find a cow with no legs? Right where you left it.";
    String joke3 = "And God said to John, \"Come forth and you shall be granted eternal life.\" But John came fifth and won a toaster.";
    List<String> list = new ArrayList<>();

    public JokeController(){
        list.add(joke1);
        list.add(joke2);
        list.add(joke3);
    }

    @GetMapping("/jokes")
    public ResponseEntity<String> getJokes(){
        JSONObject object = new JSONObject();
        JSONArray jArray = new JSONArray();
        for (String s : list){
            jArray.add(s);
        }
        object.put("jokes",jArray);
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(object.toJSONString());
    }
    @GetMapping("/joke/{id}")
    public ResponseEntity<String> getJokeById(@PathVariable int id){
        JSONObject object = new JSONObject();
        int status;
        if (id<1 || id>list.size()){
            object.put("error","Invalid id");
            status = 404;
        }else{
            object.put("joke",list.get(id-1));
            status = 200;
        }
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(object.toJSONString());
    }
    @GetMapping("/joke")
    public ResponseEntity<String> getRandomJoke(){
        JSONObject object = new JSONObject();
        int status;
        if (list.size()==0){
            object.put("error","No joke in database");
            status = 404;
        }else {
            int id =(int) ((Math.random() * (3 - 1)) + 1);
            object.put("id",id);
            object.put("joke",list.get(id-1));
            status = 200;
        }
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(object.toJSONString());
    }
}
