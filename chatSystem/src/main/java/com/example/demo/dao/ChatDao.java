package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntChat;

@Repository
public class ChatDao {
	private JdbcTemplate db;

	ChatDao(JdbcTemplate db) {
		this.db = db;
	}

	public void insertDb(EntChat entchat) {
		System.out.println("チャットデータベースに挿入");
		db.update("INSERT INTO chat (name,comment) VALUES (?,?)", entchat.getName(), entchat.getComment());

	}

	public List<EntChat> searchDb() {
		//DBからリストをMapで取得
		List<Map<String, Object>> listDb = db.queryForList("SELECT * FROM chat");
		//返す用のリスト
		List<EntChat> list = new ArrayList<EntChat>();

		for (Map<String, Object> data : listDb) {
			EntChat chat = new EntChat();
			//1つずつセット
			chat.setId((int) data.get("id"));
			chat.setName((String) data.get("name"));
			chat.setComment((String) data.get("comment"));
			//リストに追加
			list.add(chat);
		}

		return list;
	}
}
