<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>


<b><a mid='${member.mId}' id="user_signUp"  href="#" title="">${user.sign_up}</a></b>

<P>  The time on the server is ${serverTime}. </P>


</body>
</html>
