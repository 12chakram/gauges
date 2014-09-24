<!DOCTYPE html>
    
  <jsp:include page="../../static.jsp"></jsp:include>
  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<html lang="en">
	<head>
		<script type="text/javascript">
		
			function getOpenIDItem(name) {
				alert(name);
				if (name == 'yahoo') {
					$("#openid_identifier").val("https://me.yahoo.com/");
					$("#openIDform").submit();
				}
				if(name == 'google'){
					$("#openid_identifier").val("https://www.google.com/accounts/o8/id");
					$("#openIDform").submit();
				}
			}
		
		</script>
	</head>

	<body class="login-layout">
	  <jsp:include page="../../template/auth/auth_header.jsp"></jsp:include>
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
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Please Enter Your Information
											</h4>

											<div class="space-6"></div>

											<form id="login-form" method="post">
											
												<fieldset>
												  <div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" id="username"  class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
												</div>
												 <div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" id="password"  class="form-control" placeholder="Password" />
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
											</form>
											<c:url var="openIDLoginUrl" value="/j_spring_openid_security_check" />
											     <form action="${openIDLoginUrl}" method="post" target="_blank" id="openIDform">
											       	<input id="openid_identifier" name="openid_identifier" value="" type="hidden"/>
											       	<button type="button" class="width-35  btn btn-sm btn-danger" onclick="getOpenIDItem('google');">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Google&#43;</span>
														</button>
												 </form>

											<div class="space-6"></div>
											
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

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												New User Registration
											</h4>

											<div class="space-6"></div>
											<p> Enter your details to begin: </p>
										     <c:url var="userRegisterUrl" value="/services/users/register" />
										     <form:form modelAttribute="userAttribute" method="POST" action="${userRegisterUrl}"  autocomplete="off" encoding="multipart/form-data" enctype="multipart/form-data" id="registration-form">
										     
												<fieldset>
												
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" id="reg_email" name="reg_email" class="form-control" placeholder="Email" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">			
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="reg_username" name="reg_username" class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="reg_password" name="reg_password" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="reg_cnf-password" name="reg_cnf_password" class="form-control" placeholder="Repeat password" />
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label>
												</div>
												
												<div class="form-group">		
													<label class="block">
														<input type="checkbox" id="reg_accept" name="reg_accept" class="ace" />
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

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			
										
				$('#login-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						username: {
							required: true,
							username:true
						},
						password: {
							required: true,
							password:true
						},
						
					},
			
					messages: {
						username: {
							required: "Please provide username.",
							username: "Please provide username."
						},
						password: {
							required: "Please provide Password.",
							username: "Please provide Password."
						},
						
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						   error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
				$('#retrieve-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						retrieve_email: {
							required: true,
							email:true
						},
											
					},
			
					messages: {
						retrieve_email: {
							required: "Please provide Email.",
							retrieve_email: "Please provide a valid Email."
						},
											
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						   error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
				
				
				
				$('#registration-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						reg_email: {
							required: true,
							email:true
						},
						reg_username: {
							required: true,
							reg_username:true
						},
						reg_password: {
							required: true,
							reg_password:true
						},
						reg_cnf_password: {
							required: true,
							reg_password:true
						},
											
					},
			
					messages: {
						reg_email: {
							required: "Please provide Email.",
							retrieve_email: "Please provide a valid Email."
						},
						reg_username: {
							required: "Please provide username.",
							reg_username:"Please provide username."
						},
						reg_password: {
							required: "Please provide password.",
							reg_password:"Please provide password."
						},
						reg_cnf_password: {
							required: "Please reenter password.",
							reg_cnf_password:"Please reenter password."
						},
																	
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						   error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
			})
			
		</script>
	</body>
</html>
