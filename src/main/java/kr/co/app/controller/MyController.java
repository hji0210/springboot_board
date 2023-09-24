package kr.co.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import kr.co.app.controller.dao.IBoardDao;
import kr.co.app.controller.dto.BoardDto;

@Controller
public class MyController {

    @Autowired
    IBoardDao boardDao;

    @RequestMapping("/")
    public String root() {
        System.out.println("test");
        return "redirect:/listForm"; // Use the correct URL path.
    }

    @RequestMapping("/listForm")
    public String listForm(Model model) {
        List<BoardDto> list2 = boardDao.list();
        model.addAttribute("list", list2);
        return "listForm"; // "listForm.jsp" will be dispatched.
    }

    @RequestMapping("/writeForm")
    public String writeForm() {
        return "WriteForm"; // "WriteForm.jsp" will be dispatched.
    }

    @RequestMapping("/writeAction")
    public String writeAction(@RequestParam("board_name") String board_name, // Fix the parameter name
            @RequestParam("board_title") String board_title,
            @RequestParam("board_content") String board_content) 	
    {
    	BoardDto dto = new BoardDto();
    	dto.setBoard_name(board_name);
    	dto.setBoard_title(board_title);
    	dto.setBoard_content(board_content);
    	int result = boardDao.write(dto);
    	if(result==1) {
    		System.out.println("글쓰기 성공!");
    	}else {
    		System.out.println("글쓰기 실패!");
    	}
    	
    	
 
        return "redirect:/listForm"; // Redirect to the listForm.
    }
}
