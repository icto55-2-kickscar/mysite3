<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="board">
				<form id="search_form" action="board" method="get">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td><a href="board?a=view&no=${vo.no }">${vo.title }</a></td>
						<td>${vo.memberName }</td>
						<td>${vo.viewCount }</td>
						<td>${vo.regDate }</td>
						<td>
							<c:if test="${authMember.no == vo.memberNo }">
							<a href="board?a=delete&no=${vo.no }" class="del">삭제</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>	
				</table>
				<c:if test="${ not empty authMember }" >
				<div class="bottom">
					<a href="?a=write" id="new-book">글쓰기</a>
				</div>
				</c:if>				
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="type">board</c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>