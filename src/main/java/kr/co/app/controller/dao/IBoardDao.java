package kr.co.app.controller.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.app.controller.dto.BoardDto;

@Mapper
public interface IBoardDao {
  public List<BoardDto> list();
  public int write(BoardDto dto);
  public BoardDto viewDto(String board_idx);
  public int deleteDto(String board_idx);
}