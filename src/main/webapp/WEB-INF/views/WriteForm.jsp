<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
    <h2>글쓰기</h2>
    
    <form action="writeAction" method="post">
  <table width="500" cellpadding="0" cellspacing="0" border="1">
    
    
    <tr>
        <td>이름</td>
         <td><input type="text" name="board_name" value="" size="50"></td>
    </tr>
    <tr>
        <td>제목</td>
         <td><input type="text" name="board_title" value="" size="50"></td>
    </tr>
    
    <tr>
        <td>내용</td>
         <td>
           <textarea rows="10" cols="50" name="board_content"></textarea>
         
         </td>
    </tr>
    <tr>
        <td>첨부 파일</td>
        <td><input type="file" name="fileToUpload"></td>
    </tr>
    <tr>
    	<td colspan="2">
		    <input type="submit" value="글쓰기">
		    <a href="listForm"><input type="button" value="취소"></a>
		    <a href="listForm"><input type="button" value="목록보기"></a>
		</td>
    </tr>
    </table>
    </form>
</body>
</html>