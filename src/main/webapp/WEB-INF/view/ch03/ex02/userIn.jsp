<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<!-- binary file을 받기위해 encoding type을 정해준다. -->
<!-- method, encType inputType file을 지키자. -->
<form method='post' encType='multipart/form-data'>
	<label>이름: <input type='text' name='username'/></label><br>
	<label>나이: <input type='number' name='age'/></label><br>
	<label>얼굴: <input type='file' name='face'/></label><br>
	<input type='submit'/>
</form>