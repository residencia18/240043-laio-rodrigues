package com.outlaio.redesocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Alo Mundo";
	}
	
	@RequestMapping("/palavra")
	@ResponseBody
    public String palavra() {
        return "girafa";
    }
}
