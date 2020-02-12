package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {

    @GetMapping("/dictionary")
    public String dictionary(){
        return "dictionary";
    }
    @PostMapping("/dictionary")
    public String result(@RequestParam("search") String search , Model model){
        Map<String,String> dic = new HashMap<>();
        dic.put("hello", "Xin chao");
        dic.put("computer", "May Tinh");
        dic.put("book", "Cuon Sach");
        dic.put("run", "chay");
        dic.put("eat", "An");

        String result = dic.get(search.toLowerCase());
        if (result != null){
            model.addAttribute("result",result);
        }else {
            model.addAttribute("result","Not found");
        }
        model.addAttribute("resultString","Result: ");
        return "dictionary";
    }

}
