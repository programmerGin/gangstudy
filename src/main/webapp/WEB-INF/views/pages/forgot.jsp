<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
Template Name: Metronic - Bootstrap 4 HTML, React, Angular 9 & VueJS Admin Dashboard Theme
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: https://1.envato.market/EA4JP
Renew Support: https://1.envato.market/EA4JP
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<style>
	<!--begin::Head-->
	<head><base href="../../../../">
		<meta charset="utf-8" />
		<title>비밀번호 찾기 | Gangstudy</title>
		<meta name="description" content="Forgot password page example" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<link rel="canonical" href="https://keenthemes.com/metronic" />
		<!--begin::Fonts-->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
		<!--end::Fonts-->
		<!--begin::Page Custom Styles(used by this page)-->
		<link href="${pageContext.request.contextPath}/resources/assets/css/pages/login/login-4.css" rel="stylesheet" type="text/css" />
		<!--end::Page Custom Styles-->
		<!--begin::Global Theme Styles(used by all pages)-->
		<link href="${pageContext.request.contextPath}/resources/assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resources/assets/plugins/custom/prismjs/prismjs.bundle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resources/assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
		<!--end::Global Theme Styles-->
		<!--begin::Layout Themes(used by all pages)-->
		<!--end::Layout Themes--> 
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/media/logos/logo-g1.png" /> 
	</head>
	<!--end::Head--> 
	<!--begin::Body-->
	<body id="kt_body" class="header-mobile-fixed subheader-enabled aside-enabled aside-fixed aside-secondary-enabled page-loading">
		<!--begin::Main-->
		<div class="d-flex flex-column flex-root">
			<!--begin::Login-->
			<div class="login login-4 wizard d-flex flex-column flex-lg-row flex-column-fluid">
				<!--begin::Content-->
				<div class="login-container order-2 order-lg-1 d-flex flex-center flex-row-fluid px-7 pt-lg-0 pb-lg-0 pt-4 pb-6 bg-white">
					<!--begin::Wrapper-->
					<div class="login-content d-flex flex-column pt-lg-0 pt-12">
						<!--begin::Logo-->
							
						<a href="/gangstudy" class="login-logo pb-xl-20 pb-15">
						</a>
						<!--end::Logo--> 
						<!--begin::Signin-->
						<div class="login-form">
							<form class="form" id="kt_login_forgot_form" action="">
								<!--begin::Title-->
								<div class="pb-5 pb-lg-15">
									<h3 class="font-weight-bolder text-dark font-size-h2 cafe24 font-size-h1-lg"> 비밀번호 찾기</h3>
									<p class="text-muted font-weight-bold cafe24 font-size-h4"> 아이디와 이메일을 적어주세요 </p>
								</div>
								<!--end::Title-->
								<!--begin::Form group-->
								<div class="form-group">
									<input class="form-control form-control-solid h-auto py-7 px-6 border-0 rounded-lg font-size-h6" type="id" placeholder="id" name="id" autocomplete="off" />
								</div>
									<input class="form-control form-control-solid h-auto py-7 px-6 border-0 rounded-lg font-size-h6" type="email" placeholder="Email" name="email" autocomplete="off" />
								</div>
								<!--end::Form group-->
								<!--begin::Form group-->
								<div class="form-group d-flex flex-wrap">
									<button type="submit" id="kt_login_forgot_form_submit_button" class="btn btn-primary font-weight-bolder cafe24 font-size-h6 px-8 py-4 my-3 mr-4">확인 </button>
									<a href="/gangstudy/signin" id="kt_login_forgot_cancel" class="btn btn-light-primary cafe24 font-weight-bolder font-size-h6 px-8 py-4 my-3">뒤로가기</a>
								</div>
								<!--end::Form group-->
							</form>
						</div> 
						<!--end::Signin-->
					</div>
					<!--end::Wrapper-->
				</div>
				<!--begin::Content-->
				<!--begin::Aside-->
				<div class="login-aside order-1 order-lg-2 bgi-no-repeat bgi-position-x-right" style="background-image: url(${pageContext.request.contextPath}/resources/assets/media/bg/forgot.png);">
					<div class="login-conteiner bgi-no-repeat bgi-position-x-right bgi-position-y-bottom" >
						<!--begin::Aside title-->
						<h3 class="pt-lg-40 pl-lg-20 pb-lg-0 pl-10 py-20 m-0 d-flex justify-content-lg-start font-weight-boldest display5 display1-lg text-white">When you
						<br />forgot
						<br /> your password</h3>
						<!--end::Aside title-->
					</div>
				</div>
				<!--end::Aside-->
			</div>
			<!--end::Login-->
		</div>
		<!--end::Main-->
		<script>var HOST_URL = "https://preview.keenthemes.com/metronic/theme/html/tools/preview";</script>
		<!--begin::Global Config(global config for global JS scripts)-->
		<script>var KTAppSettings = { "breakpoints": { "sm": 576, "md": 768, "lg": 992, "xl": 1200, "xxl": 1200 }, "colors": { "theme": { "base": { "white": "#ffffff", "primary": "#1BC5BD", "secondary": "#E5EAEE", "success": "#1BC5BD", "info": "#6993FF", "warning": "#FFA800", "danger": "#F64E60", "light": "#F3F6F9", "dark": "#212121" }, "light": { "white": "#ffffff", "primary": "#1BC5BD", "secondary": "#ECF0F3", "success": "#C9F7F5", "info": "#E1E9FF", "warning": "#FFF4DE", "danger": "#FFE2E5", "light": "#F3F6F9", "dark": "#D6D6E0" }, "inverse": { "white": "#ffffff", "primary": "#ffffff", "secondary": "#212121", "success": "#ffffff", "info": "#ffffff", "warning": "#ffffff", "danger": "#ffffff", "light": "#464E5F", "dark": "#ffffff" } }, "gray": { "gray-100": "#F3F6F9", "gray-200": "#ECF0F3", "gray-300": "#E5EAEE", "gray-400": "#D6D6E0", "gray-500": "#B5B5C3", "gray-600": "#80808F", "gray-700": "#464E5F", "gray-800": "#1B283F", "gray-900": "#212121" } }, "font-family": "Poppins" };</script>
		<!--end::Global Config-->
		<!--begin::Global Theme Bundle(used by all pages)-->
		<script src="${pageContext.request.contextPath}/resources/assets/plugins/global/plugins.bundle.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/plugins/custom/prismjs/prismjs.bundle.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/scripts.bundle.js"></script>
		<!--end::Global Theme Bundle-->
		<!--begin::Page Scripts(used by this page)-->
		<script src="${pageContext.request.contextPath}/resources/assets/js/pages/custom/login/login-4.js"></script>
		<!--end::Page Scripts-->
	</body>
	<!--end::Body-->
</html>