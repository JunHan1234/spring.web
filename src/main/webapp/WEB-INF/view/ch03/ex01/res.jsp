<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!-- url action tag의 value값으로는 app.properties에서
	설정한 context-path 이후의 상대주소값을 기술한다. 
	이 value값을 client에서 request가 오면,
	action tag가 절대주소로 변환하여 값을 넘긴다. -->
<script src='<c:url value="/res/alert.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/box.css"/>'/>
<img src='<c:url value="/res/duke.gif"/>'/>

<div></div>