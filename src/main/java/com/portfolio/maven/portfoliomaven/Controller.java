package com.portfolio.maven.portfoliomaven;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


@RestController
@CrossOrigin({"https://immense-thicket-55693.herokuapp.com/","https://peaceful-gates-78e3d1.netlify.app/","http://localhost:3000/"})
public class Controller {
    @Autowired
	UserRepository repository;

    @PostMapping("/post")
    public void saveFormData(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        MailService mailService = new MailService();
        

            try {
                mailService.sendMail(object.getString("email"), object.getString("name"), object.getString("description"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        Gson g = new Gson();
        repository.save(g.fromJson(body, PortFolio.class));
    }
    @GetMapping("/getAll")
    public List<String> fetchAllData() throws Exception{
        List<PortFolio> li=repository.findAll();
        List<String> res=new ArrayList<>(li.size());
        li.forEach(
            (n)->{
                
                res.add((new Gson().toJson(n)));
            }
            );
        
        return res;
    }
}
