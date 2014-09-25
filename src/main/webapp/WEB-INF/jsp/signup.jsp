<!DOCTYPE html>
  <jsp:include page="../../static.jsp"></jsp:include> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Login Page - Ace Admin</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
	</head>

	<body class="login-layout">
	   <jsp:include page="../../template/public/unauth_header.jsp"></jsp:include>
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">Ace</span>
									<span class="white" id="id-text2">Application</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; Company Name</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box  widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Please Enter Your Information
											</h4>

											<div class="space-6"></div>
											 <c:url var="loginurl" value="/services/auth/doLogin" />
											  <form:form modelAttribute="userAttribute" method="POST" action="${loginurl}"  id="login-form"> 
											    <label>	<span class="red">${errormsg}</span>  </label>
												<fieldset>
												  <div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="userName" type="text" name="userName" id="userName"  class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
												</div>
												 <div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:password path="loginpwd" name="loginpwd" id="loginpwd"  class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
                                                 </div>
													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Login</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form:form>
										
											<%-- <c:url var="openIDLoginUrl" value="/j_spring_openid_security_check" />
											     <form action="${openIDLoginUrl}" method="post" target="_blank" id="openIDform">
											       	<input id="openid_identifier" name="openid_identifier" value="" type="hidden"/>
											       	<button type="button" class="width-35  btn btn-sm btn-danger" onclick="getOpenIDItem('google');">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Google&#43;</span>
														</button>
												 </form>

											<div class="space-6"></div> --%>
											
											<div class="social-or-login center">
												<span class="bigger-110">Or Login Using</span>
											</div>

											<div class="space-6"></div>

											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="ace-icon fa fa-facebook"></i>
												</a>

												<a class="btn btn-info">
													<i class="ace-icon fa fa-twitter"></i>
												</a>
													<c:url var="openIDLoginUrl" value="/j_spring_openid_security_check" />
												<a class="btn btn-danger">
												 <form action="${openIDLoginUrl}" method="post" target="_blank" id="openIDform">
											       	<input id="openid_identifier" name="openid_identifier" value="" type="hidden"/>
												 </form>
													<i class="ace-icon fa fa-google-plus" onclick="getOpenIDItem('google');"></i>
												</a>
											</div>
											
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													I forgot my password
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													I want to register
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i>
												Retrieve Password
											</h4>

											<div class="space-6"></div>
											<p>
												Enter your email and to receive instructions
											</p>

											<form id="retrieve-form" method="post">
												<fieldset>
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" name="retrieve_email" id="retrieve_email" class="form-control" placeholder="Email" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
												 </div>
													<div class="clearfix">
														<button type="submit" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="ace-icon fa fa-lightbulb-o"></i>
															<span class="bigger-110">Send Me!</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												Back to login
												<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<div id="signup-box" class="signup-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												New User Registration
											</h4>

											<div class="space-6"></div>
											<p> Enter your details to begin: </p>
										     <c:url var="userRegisterUrl" value="/services/auth/signupProcess" />
										        <form:form modelAttribute="userAttribute" method="POST" action="${userRegisterUrl}"  autocomplete="off"  id="registration-form">
												<fieldset>
												
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="email" type="email" id="reg_email" name="email" class="form-control" placeholder="Email"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">			
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="userName" type="text" id="reg_username" name="userName" class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:password path="secpassword"  id="secpassword" name="secpassword" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:password path="cnfpassword" id="cnfpassword" name="cnfpassword" class="form-control" placeholder="Repeat password" />
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">		
													<label class="block">
														<input type="checkbox" id="accept" name="accept" class="ace" />
														<span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
													</label>
												</div>
													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">Reset</span>
														</button>

														<button type="submit" class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">Register</span>
															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form:form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative -->

							
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->
		
	</body>
</html>
