package kr.co.app.controller.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDto {
	private int board_idx;
	private String board_name;
	private String board_title;
	private String board_content;
	private Date board_date;
	private int board_hit;

	public BoardDto() {

	}

	public BoardDto(int board_idx, String board_name, String board_title, String board_content, Date board_date,
			int board_hit) {
		this.board_idx = board_idx;
		this.board_name = board_name;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_hit = board_hit;
	}

	@Override
	public String toString() {
		return "BoardDto [board_idx=" + board_idx + ", board_name=" + board_name + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_date=" + board_date + ", board_hit=" + board_hit + "]";
	}

	
}
