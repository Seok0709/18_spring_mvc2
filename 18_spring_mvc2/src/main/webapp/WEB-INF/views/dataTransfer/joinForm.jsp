<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
</head>
<body>
	<form action="transfer3" method="post"> 
		<fieldset>
			<legend>회원가입</legend>
			<p> 아이디 :   <input type="text" name="id" placeholder="아이디를 입력하세요." /></p>
			<p> 비밀번호 : <input type="password" name="password" placeholder="비밀번호를 입력하세요." /></p>
			<p> 이름 :     <input type="text" name="name" /></p>
			<p> 이메일 :   <input type="email"  name="email" ></p>		
		    <p><input type="submit" value="회원가입" ></p>
		    
		    <input type="hidden" name="addData1" value="추가된데이터1">
		    <input type="hidden" name="addData2" value="추가된데이터2">
		    <input type="hidden" name="addData3" value="추가된데이터3">
		    <!--  
		    	<p>이미 회원가입이 되어있으면 <a href="transfer5?isMember=yes&isSession=no">로그인으로 이동하기</a></p>
		    -->
		    	<p>이미 회원가입이 되어있으면 <a href="transfer5/yes/no">로그인으로 이동하기</a></p>
		</fieldset>	
     </form>
</body>
</html>