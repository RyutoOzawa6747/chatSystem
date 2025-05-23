package com.example.demo.chat;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ChatDao;
import com.example.demo.entity.EntChat;

@Controller
public class ChatController {

	private ChatDao chatdao;

	public ChatController(ChatDao chatdao) {
		this.chatdao = chatdao;
	}

	@RequestMapping("/home")
	public String pageTop() {
		return "index";
	}

	@GetMapping("/view")
	public String chatRoom(Model model, Chat chat) {
		//チャットデータをDBからもってくる
		List<EntChat> list = chatdao.searchDb();
		model.addAttribute("chatList", list);
		//最新順に並べ替え
		list.sort((a, b) -> b.getId() - a.getId());

		return "/chat/view";
	}

	@PostMapping("/view")
	public String postChat(Chat chat) {
		//DBに挿入できる形に変換
		EntChat entchat = new EntChat();
		entchat.setName(chat.getName());
		entchat.setComment(chat.getComment());
		//DB操作
		chatdao.insertDb(entchat);

		return "redirect:/view";
	}
}
