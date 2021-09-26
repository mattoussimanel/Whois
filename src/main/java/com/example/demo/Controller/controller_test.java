package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller_test {

	@GetMapping("/list_test")
	public String test(){
		
		return "test";
}
}
