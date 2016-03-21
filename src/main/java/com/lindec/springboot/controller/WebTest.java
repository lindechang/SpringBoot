package com.lindec.springboot.controller;

import com.lindec.springboot.dto.Information;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lindec on 2016/3/7.
 */
@Controller
public class WebTest {

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @PreAuthorize("")
    public String html(){
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Information information) {
        System.out.println("---information---:" + information.getUsername());
        return "ok";
    }
}
