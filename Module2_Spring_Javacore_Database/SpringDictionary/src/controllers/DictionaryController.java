package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {


    @GetMapping("/dictionary")
    public String getDictionary(){
        return "dictionary";
    }
    @PostMapping("/dictionary")
    public ModelAndView findWord(@RequestParam(name = "word") String word){
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
        String vneseWord= dic.get(word);

        ModelAndView modelAndView = new ModelAndView("dictionary","word",word);
        if(vneseWord==null){
            modelAndView.addObject("result","Not Found");
        }else {
            modelAndView.addObject("result",vneseWord);
        }
        return modelAndView;
    }
}