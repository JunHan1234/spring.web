<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<!-- action값은 client가 이용한다. url은 handler의 url이다.-->
<form action='userOut' method='post'>
	<label>이름: <input type='text' name='username'/></label><br>
	<label>나이: <input type='number' name='age'/></label><br>
	<label>등록일: <input type='date' name='regDate'/></label><br>
	<input type='submit'/>
</form>