<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>8691</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">
</head>
<body>
<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->
   <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />
</c:if>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
				<form action="<c:url value="/_02_Login/login.controller" />" method="post" >
					<h2 class="intro-text text-center">					
					帳號 :<input type="text" name="acc_email"	 id="emailinput" value="${param.acc_email}"><span id="emailsp" style="color:red"></span></h2>
					<h3 class="intro-text text-center">${error.acc_email}</h3>
					

					<h2 class="intro-text text-center">
					密碼 :<input type="password" name="psd"  id="pwdinput" value="${param.psd}"><span id="pwdsp" style="color:red"></span></h2>
					<h3 class="intro-text text-center" >${error.psd}${error.loginfail}</h3>
					
					
                    <div class="checkbox">
			          	<label><input type="checkbox"> Remember me</label>
			        </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="submit" value="登入">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="btn btn-primary" type="button" value="註冊" onclick="location.href='<%= request.getContextPath() %>/_01_Register/SelectRegister.jsp'">                     
                </form>
				</div>				
			</div>
		</div>

	</div>
	<!-- /.container -->
	<script>
        window.onload = function () {
            document.getElementById("emailinput").onblur = blur;
            document.getElementById("pwdinput").onblur = blur2;            
        }
        
        function blur() {
            if (document.getElementById("emailinput").value == "") {
                document.getElementById("emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
            }
            else if (document.getElementById("emailinput").value != "") {
                chkemail();          
            }
        }

        function chkemail() {
            var theemail = document.getElementById("emailinput").value; 
            var namere = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
            
            if (namere.test(theemail)) {
                document.getElementById("emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";
            }   
             else {
                document.getElementById("emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
               }
        }        


        function blur2() {
            if (document.getElementById("pwdinput").value == "") {
                document.getElementById("pwdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
            }            
        }
        
    </script>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; EEIT83第五小組 2016 | <a href="<%= request.getContextPath() %>/contact.jsp">聯絡我們</a></p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>