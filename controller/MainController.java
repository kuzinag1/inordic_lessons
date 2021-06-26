package ru.news.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.news.demoapp.model.Cat;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHelloWorldPage(ModelMap modelMap,
                                    @RequestParam(name = "hello",required = false,
                                            defaultValue = "noName") String hello) {
        Cat cat = Cat.builder()
                .name("George").build();
        Cat cat1 = Cat.builder()
                .name("George1").build();
        Cat cat2 = Cat.builder()
                .name("George2").build();
        Cat cat3 = Cat.builder()
                .name("George3").build();
        Cat cat4 = Cat.builder()
                .name("George4")
                .color("yellow")
                .build();
        List<Cat> list = Arrays.asList(cat,cat1,cat2,cat3);
        modelMap.addAttribute("hello",hello);
        modelMap.addAttribute("cat",cat);
        modelMap.addAttribute("cats",list);
        modelMap.addAttribute("george",cat4);

        return "welcome";
    }
}
