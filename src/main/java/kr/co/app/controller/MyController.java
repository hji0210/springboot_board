package kr.co.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.app.controller.dao.IBoardDao;
import kr.co.app.controller.dto.BoardDto;

@Controller
public class MyController {

	@Autowired
	IBoardDao boardDao;

	@RequestMapping("/")
	public String root() {
		System.out.println("test");
		return "redirect:listForm"; // Use the correct URL path.
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
	public String writeAction(@RequestParam("board_name") String board_name,
	        @RequestParam("board_title") String board_title, @RequestParam("board_content") String board_content
//	        @RequestParam("fileToUpload") MultipartFile file
	        , HttpServletRequest request) {
	    String uploadResult = "";
	    // 업로드 파일이 존재하면 uploadFile 함수 호출
//	    if (!file.isEmpty()) {
//	        uploadResult = uploadFile(file, request);
//	        if ("fail".equals(uploadResult)) {
//	            // 파일 업로드 실패
//	            // 필요한 로직 수행 (예: 데이터베이스에 파일 정보 저장)
//	        	System.out.println("파일첨부 실패!");
//		        request.getSession().setAttribute("alert_message", "파일첨부 실패!");
//		        return "redirect:writeForm";
//	        } else {
//	            // 파일 업로드 성공 == 업로드패스
//	            // 실패 메시지 등을 설정하고 원하는 페이지로 리다이렉트
//	            request.getSession().setAttribute("uploadPath", uploadResult);
//	        }
//	    }
	    BoardDto dto = new BoardDto();
	    dto.setBoard_name(board_name);
	    dto.setBoard_title(board_title);
	    dto.setBoard_content(board_content);
//	    dto.setFile_path(uploadResult);
	    int result = boardDao.write(dto);
	    if (result == 1) {
	        System.out.println("글쓰기 성공!");
	        request.getSession().setAttribute("alert_message", "글쓰기 성공!");
	        return "redirect:listForm";
	    } else {
	    	System.out.println("글쓰기 실패!");
	        request.getSession().setAttribute("alert_message", "글쓰기 실패!");
	        return "redirect:writeForm";
	    }
	}

	@RequestMapping("/contentForm")
	public String contentForm(@RequestParam("board_idx") String board_idx, Model model) {
		BoardDto dto = boardDao.viewDto(board_idx);
		System.out.println(dto);

		model.addAttribute("dto", dto);
		return "contentForm";// writeForm으로 리다이렉트
	}

	@RequestMapping("/deleteAction")
	public String deleteAction(@RequestParam("board_idx") String board_idx, HttpServletRequest request) {
		int result = boardDao.deleteDto(board_idx);
		if (result == 1) {
			System.out.println("글삭제 성공!");
			request.getSession().setAttribute("alert_message", "글삭제 성공!");
			return "redirect:listForm";
		} else {
			System.out.println("글삭제 실패!");
			request.getSession().setAttribute("alert_message", "글삭제 실패!");
			return "redirect:contentForm?board_idx=" + board_idx; // 원래대로 돌아가기(내용)
		}
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("fileToUpload") MultipartFile file, HttpServletRequest request) {
		String uploadPath = null;
		if (!file.isEmpty()) {
			try {
				// 업로드한 파일 정보 가져오기
				String originalFilename = file.getOriginalFilename();
				// 로컬 드라이브의 경로 설정
				uploadPath = "C:\\files\\" + originalFilename;

				// 파일 저장
				File localFile = new File(uploadPath);
				file.transferTo(localFile);

				// 필요한 로직 수행 (예: 데이터베이스에 파일 정보 저장)

				// 업로드 성공 메시지 설정
			} catch (Exception e) {
				// 업로드 실패 시 처리
				e.printStackTrace();
				// 실패 메시지 등을 설정하고 원하는 페이지로 리다이렉트
				return "fail";
			}
		}
		return uploadPath;
	}

	@RequestMapping(value = "/cancelWrite", method = RequestMethod.GET)
	public String cancelWrite() {
		// 글 작성 취소 시 목록 페이지로 리다이렉트
		return "redirect:listForm";
	}

}
