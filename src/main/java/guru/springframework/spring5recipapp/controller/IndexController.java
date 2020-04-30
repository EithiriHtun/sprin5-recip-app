package guru.springframework.spring5recipapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index"})
    public String getIndexPage(){
        System.out.println("Some message to says!!!..123433");
        return "index";
    }

}
