<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${fns:getConfig('productName')} 登录</title>
	<meta name="decorator" content="login_basic"/>
	<script type="text/javascript">
		// 如果在框架或在对话框中，则弹出提示并跳转到首页
		if(self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0){
			alert('未登录或登录超时。请重新登录，谢谢！');
			top.location = "${ctx}";
		}
	</script>
</head>
<body>
	<div class="logintop">    
	    <span>欢迎${fns:getConfig('productName')}</span>    
	    <ul>
	    <li><a href="#">返回首页</a></li>
	    <li><a href="#">帮助</a></li>
	    <li><a href="#">关于</a></li>
	    </ul>
    </div>

	<div class="loginbody">
		<div class="login-container">
			<div class="center">
				<h1>
					<i class="icon-leaf green"></i> <span class="orange">${fns:getConfig('productName')}</span> <span
						class="white">后台管理系统</span>
				</h1>
				<h4 class="white">Background Management System</h4>
			</div>

			<div class="space-6"></div>

			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i> 管理员登陆
							</h4>
							<label id="loginError" class="blue">${message}</label>
							<div class="login_icon">
								<img src="${ctxStatic}/images/login.png" />
							</div>

							<form id="loginForm" class="form-signin" action="${ctx}/login" method="post">
								<fieldset>
									<label class="block clearfix"> 
										<span class="block input-icon input-icon-right"> 
											<input type="text" class="form-control" placeholder="登录名" name="username" value="${username}"><i class="icon-user"></i>
										</span>
									</label> 
									<label class="block clearfix"> 
										<span class="block input-icon input-icon-right"> 
											<input type="password" class="form-control required" placeholder="密码" name="password" value="${password}"> 
											<i class="icon-lock"></i>
										</span>
									</label>
									<c:if test="${isValidateCodeLogin}">
										<div class="validateCode">
											<label class="input-label mid" for="validateCode">验证码</label>
											<sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
										</div>
									</c:if>
	
									<div class="space"></div>
	
									<div class="clearfix">
										<label class="inline"> 
											<input type="checkbox" class="ace"  id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/> <span class="lbl">保存密码（公共场所慎用）</span>
										</label>
	
										<button type="submit" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
											<i class="icon-key"></i> 登陆
										</button>
									</div>

									<div class="space-4"></div>
								</fieldset>
							</form>
						<!--[if lte IE 7]>
							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>

							<div class="social-login center">本网站系统不支持IE8以下浏览器支持，请升级至最新的浏览器。</div>
						</div>
						<!-- /widget-main -->
						
						<div class="toolbar clearfix"></div>
						<![endif]-->
					</div>
					<!-- /widget-body -->
				</div>
				<!-- /login-box -->
			</div>
			<!-- /position-relative -->
		</div>
	</div>
</body>
</html>