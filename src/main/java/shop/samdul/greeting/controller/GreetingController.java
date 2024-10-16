package shop.samdul.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class GreetingController {
    private Stack<String> names = new Stack<>();

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "HI") String name, Model model) {

        names.add(name);
        model.addAttribute("names", names);
        return "greeting";
    }
}