package com.example.demo.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	@RequestMapping("/home")
	public String pageTop() {
		return "index";
	}
	
	@RequestMapping("/view")
	public String chatRoom() {
		return "/chat/view";
	}
}
