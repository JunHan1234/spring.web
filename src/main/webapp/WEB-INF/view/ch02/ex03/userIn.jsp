<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<!-- action값은 client가 이용한다. url은 handler의 url이다.-->
<!-- action값은 user에서 user로 물리적으로는 바뀌지만 식별할 수 없다. -->
<!-- <form action='user' method='post'> -->
<!-- action을 비워줘도 동작하는것을 확인할 수 있다. -->
<form method='post'>
	<label>이름: <input type='text' name='username'/></label><br>
	<label>나이: <input type='number' name='age'/></label><br>
	<label>등록일: <input type='date' name='regDate'/></label><br>
	<input type='submit'/>
</form>