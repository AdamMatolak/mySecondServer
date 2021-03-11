package org.example.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RulersController {
    String svk = "Zuzana Čaputová";
    String cz = "Miloš Zeman";
    String usa = "Joe Biden";
    String uk = "Queen Elizabeth II";
    String nld = "King Willem Alexander";
    String rus = "Vladimir Putin";
    String swd = "King Carl XVI Gustaf";
    String swt = "Guy Parmelin";
    String ukr = "Volodymyr Zelensky";
    String jap = "Emperor Naruhito";

    List<String> list = new ArrayList<>();

    public RulersController(){
        list.add(svk);
        list.add(cz);
        list.add(usa);
        list.add(uk);
        list.add(nld);
        list.add(rus);
        list.add(swd);
        list.add(swt);
        list.add(ukr);
        list.add(jap);
    }
    @GetMapping(path = "/rulers")
    public ResponseEntity<String>getRulers(){
        JSONObject object = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (String s : list){
            jsonArray.add(s);
        }
        object.put("rulers",jsonArray);
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(object.toJSONString());
    }
    /*
    @GetMapping(path = "/ruler/{String}")
    public ResponseEntity<String>getRuler(){
        JSONObject object = new JSONObject();

        object.put("ruler",list.get(String));
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(object.toJSONString());
    }
    */
}
