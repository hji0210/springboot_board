
CREATE TABLE t_board (
    board_idx INT AUTO_INCREMENT COMMENT '글 번호',
    title VARCHAR(300) NOT NULL COMMENT '제목',
    contents TEXT NOT NULL COMMENT '내용',
    hit_cnt SMALLINT DEFAULT 0 NOT NULL COMMENT '조회수',
    created_datetime DATETIME NOT NULL COMMENT '작성시간',
    creator_id VARCHAR(50) NOT NULL COMMENT '작성자',
    updated_datetime DATETIME DEFAULT NULL COMMENT '수정시간',
    updater_id VARCHAR(50) DEFAULT NULL COMMENT '수정자',
    deleted_yn CHAR(1) DEFAULT 'N' NOT NULL COMMENT '삭제여부',
    PRIMARY KEY (board_idx)
);


INSERT INTO t_board (title, contents, created_datetime, creator_id)
VALUES ("게시글1", "내용1", NOW(), "hong");

SELECT * FROM t_board;

CREATE TABLE board (
  board_idx INT PRIMARY KEY,
  board_name VARCHAR(20),
  board_title VARCHAR(100),
  board_content VARCHAR(300),
  board_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  board_hit INT DEFAULT 0
);


INSERT INTO board (board_idx, board_name, board_title, board_content, board_hit)
VALUES (1, 'User1', 'Title 1', 'Content 1', 10),
  (2, 'User2', 'Title 2', 'Content 2', 20),
  (3, 'User3', 'Title 3', 'Content 3', 30),
  (4, 'User4', 'Title 4', 'Content 4', 40),
  (5, 'User5', 'Title 5', 'Content 5', 50),
  (6, 'User6', 'Title 6', 'Content 6', 60),
  (7, 'User7  
  show tables;', 'Title 7', 'Content 7', 70),
  (8, 'User8', 'Title 8', 'Content 8', 80),Tables
  (9, 'User9', 'Title 9', 'Content 9', 90),
  (10, 'User10', 'Title 10', 'Content 10', 100);
  
  desc board;

  테이블 조회;
select * from board; 


CREATE TABLE reply (
  reply_idx INT PRIMARY KEY,
  reply_name VARCHAR(20),
  reply_content VARCHAR(300),
  reply_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  reply_board_idx INT
);

select * from reply; 


INSERT INTO reply (reply_idx, reply_name, reply_content, reply_board_idx)
VALUES
  (1, 'User1', 'Reply 1 Content', 1),
  (2, 'User2', 'Reply 2 Content', 1),
  (3, 'User3', 'Reply 3 Content', 2),
  (4, 'User4', 'Reply 4 Content', 2),
  (5, 'User5', 'Reply 5 Content', 3);


select * from reply; 

commit;