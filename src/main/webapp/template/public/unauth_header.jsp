<!DOCTYPE html>


<%String context=request.getContextPath();%>
<%String server =  request.getServerName(); %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default    navbar-collapse       h-navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="<%=context%>" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
						    idTracks Gauges
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->
					<button class="pull-right navbar-toggle navbar-toggle-img collapsed" type="button" data-toggle="collapse" data-target=".navbar-buttons,.navbar-menu">
						<span class="sr-only">Toggle user menu</span>

						<img src="../assets/avatars/user.jpg" alt="Jason's Photo" />
					</button>

					<button class="pull-right navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".sidebar">
						<span class="sr-only">Toggle sidebar</span>

						<span class="icon-bar"></span>

						<span class="icon-bar"></span>

						<span class="icon-bar"></span>
					</button>

					<!-- /section:basics/navbar.toggle -->
				</div>
			<c:if test="${userAttribute eq null}">
				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right  collapse navbar-collapse" role="navigation">
					<ul class="nav ace-nav">
						<li class="transparent">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-key icon-animated-bell"></i>
							</a>

							<div class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<div class="tabbable">
									<ul class="nav nav-tabs">
										<li>
											<a href="<%=context %>/services/auth/" >Sign In</a>
										</li>

										<li>
											<a href="<%=context %>/services/auth/signup" >Sign UP</a>
										</li>
									</ul><!-- .nav-tabs -->
						
						</li>

						<!-- #section:basics/navbar.user_menu -->
						

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>
			</c:if>	
				<!-- /section:basics/navbar.dropdown -->
				<nav role="navigation" class="navbar-menu pull-left collapse navbar-collapse">
					<!-- #section:basics/navbar.nav -->
					<ul class="nav navbar-nav">
						<li>
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								Overview
	  		                   &nbsp;
								<i class="ace-icon fa fa-angle-down bigger-110"></i>
							</a>


							<ul class="dropdown-menu dropdown-light-blue dropdown-caret">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-eye bigger-110 blue"></i>
										Monthly Visitors
									</a>
								</li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-user bigger-110 blue"></i>
										Active Users
									</a>
								</li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog bigger-110 blue"></i>
										Settings
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#">
								<i class="ace-icon fa fa-envelope"></i>
								Messages
								<span class="badge badge-warning">5</span>
							</a>
						</li>
					</ul>
					<!-- /section:basics/navbar.form -->
				</nav>
			</div><!-- /.navbar-container -->
		</div>