package com.sam.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempTestController {
	
	@GetMapping("/temp/home")
	public String tmepHome(){
		System.out.println("tempHome()");
		return "/home.html";
	}

}
