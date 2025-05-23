CREATE TABLE chat(
	-- id カラム NULL禁止 自動追加
	id INT NOT NULL AUTO_INCREMENT,
	-- name カラム NULL禁止
	name VARCHAR(100) NOT NULL,
	-- comment カラム NULL禁止
	comment VARCHAR(100) NOT NULL,
	-- idを主キーとする
	PRIMARY KEY(id)
);