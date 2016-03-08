package com.lindec.springboot.web;

import org.springframework.stereotype.Controller;
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
    public String html(){
        return "Hello World!";
    }
}
