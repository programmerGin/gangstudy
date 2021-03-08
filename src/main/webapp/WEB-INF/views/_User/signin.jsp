<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%><!DOCTYPE html><!--
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
--><html lang="en"><!--begin::Head--><head><base href="../../../"><meta charset="utf-8" /><title>로그인 | Gangstudy</title><meta name="description" content="Latest updates and statistic charts" /><meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no" /><link rel="canonical" href="https://keenthemes.com/metronic" /><!--begin::Fonts--><link rel="stylesheet"	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" /><!--end::Fonts--><!--begin::Global Theme Styles(used by all pages)--><link	href="${pageContext.request.contextPath}/resources/assets/plugins/global/plugins.bundle.css"	rel="stylesheet" type="text/css" /><link	href="${pageContext.request.contextPath}/resources/assets/plugins/custom/prismjs/prismjs.bundle.css"	rel="stylesheet" type="text/css" /><link	href="${pageContext.request.contextPath}/resources/assets/css/style.bundle.css"	rel="stylesheet" type="text/css" /><link	href="${pageContext.request.contextPath}/resources/assets/css/themes/layout/header/base/light.css"	rel="stylesheet" type="text/css" /><link	href="${pageContext.request.contextPath}/resources/assets/css/themes/layout/header/menu/light.css"	rel="stylesheet" type="text/css" /><!--end::Global Theme Styles--><!--begin::Layout Themes(used by all pages)--><!--end::Layout Themes--><link rel="shortcut icon"	href="${pageContext.request.contextPath}/resources/assets/media/logos/logo.png" /></head><!--end::Head--><!--begin::Body--><body id="kt_body"	class="quick-panel-right demo-panel-right offcanvas-right header-fixed subheader-enabled page-loading">	<!--begin::Main-->	<!--begin::Header Mobile-->	<%@ include file="/WEB-INF/views/partials/_header-mobile.jsp"%>	<!--end::Header Mobile-->	<div class="d-flex flex-column flex-root">		<!--begin::Page-->		<div class="d-flex flex-row flex-column-fluid page">			<!--begin::Wrapper-->			<div class="d-flex flex-column flex-row-fluid wrapper"				id="kt_wrapper">				<!--begin::Header-->				<div>					<%@ include file="/WEB-INF/views/partials/_header.jsp"%>				</div>				<!--end::Header-->				<!--begin::Content-->				<div class="content d-flex flex-column flex-column-fluid"					id="kt_content">					<div class="row">						<div class="col-md-4" style="float: none; margin: auto;">							<!--begin::Card-->							<!--begin::Form-->							<form   id="kt_login_singin_form" action="/" method="post">															<div class="col-md-4">									<p class="main_text"></p>								</div>								<div class="card-footer" style="align-items: center;">									<div class="form-group form-group-last">										<div class="alert-text" style="text-align: center">																							<p class="myinfo_text col-md-9 d-none d-xl-block">갱스터디 회원 로그인</p>											<p class="mobile_myinfo_text col-md-9 d-xl-none">갱스터디 회원 로그인</p>																								<br> <br>   																																											</div>									</div>									<div class="form-group">										<input class="form-control col-md-9 " type="text" name="id"											id="id" value="" style="height: 4.35rem; margin-bottom: 1rem;"  											placeholder=" 아이디를 입력해주세요." autocomplete="off" >										<div class="valid-feedback"></div>										<div class="invalid-feedback"></div>										</div>  										  										<div class="form-group"> 										<input class="form-control col-md-9 " type="password"  											name="pw" id="pw" value=""											style="height: 4.35rem; margin-bottom: 0rem;"											placeholder=" 비밀번호를 입력해주세요." autocomplete="off">     										<div class="valid-feedback"></div>										<div class="invalid-feedback">비밀번호는 6자리 이상입니다.</div>									</div>     									       									<table class="form-groups" style="margin: 0 0rem rem 0; ">                          <tr>                                                     <td >                                                                 									<a style="margin: 0 12rem 0rem 0; "> 비밀번호를 잊으셨나요?</a> </td> <th>       									<a href="/find_pw" class="text-primary font-weight-bolder text-hover-primary  underline" >비밀번호 찾기 <img src="${pageContext.request.contextPath}/resources/images/btn_arrow_pw.svg"     class="btn_arrow_pw">  </a>                 </th>    									   </tr></table>									         																		<div class="form-group" style="align-items: center;"> 										<button type="submit"											class="btn btn-booking btn-lg col-md-9  " id="kt_login_singin_form_submit_button" name="loginbtn">로그인</button>										<button type="button"    											onclick="location.href='/kakao/login'" 											class="btn btn-kakao btn-lg text-dark col-lg-9">    											<img												src="${pageContext.request.contextPath}/resources/images/ic-kakao.svg"												class="ic_kakao" style="float: none; margin: 0.5rem;">카카오톡계정으로 로그인										</button>										<button type="button" class="btn btn-dark btn-lg col-md-9  "											onclick="location.href='/signup_main'">회원가입</button>  									</div>									<div class="form-group "></div>									<!--begin: Code-->									<div class="example-code mt-10">										<div class="example-highlight"></div>									</div>									<!--end: Code-->								</div>							</form>							<!--end::Form-->							<!--end::Card-->						</div>						<!--end::Container-->					</div>					<!--end::Entry-->				</div>				<!--end::Content-->				<!--begin::Footer-->				<%@ include file="/WEB-INF/views/partials/_footer/extended.jsp"%>				<!--end::Footer-->			</div>			<!--end::Wrapper-->		</div>		<!--end::Page-->	</div>	<!--end::Main-->	<!-- begin::User Panel-->	<!-- end::User Panel-->	<!--begin::Quick Panel-->	<!--end::Quick Panel-->	<!--begin::Chat Panel-->	<!--end::Chat Panel-->	<!--begin::Scrolltop-->	<div id="kt_scrolltop" class="scrolltop">		<span class="svg-icon"> <!--begin::Svg Icon | path:${pageContext.request.contextPath}/resources/assets/media/svg/icons/Navigation/Up-2.svg-->			<svg xmlns="http://www.w3.org/2000/svg"				xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"				height="24px" viewBox="0 0 24 24" version="1.1">
					<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
						<polygon points="0 0 24 0 24 24 0 24" />
						<rect fill="#000000" opacity="0.3" x="11" y="10" width="2"					height="10" rx="1" />
						<path					d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z"					fill="#000000" fill-rule="nonzero" />
					</g>
				</svg> <!--end::Svg Icon-->		</span>	</div>	<!--end::Scrolltop-->	<!--begin::Sticky Toolbar-->	<!--end::Sticky Toolbar-->	<!--begin::Demo Panel-->	<!--end::Demo Panel-->	<script>		var HOST_URL = "https://preview.keenthemes.com/metronic/theme/html/tools/preview";	</script>	<!--begin::Global Config(global config for global JS scripts)-->	<script>		var KTAppSettings = {			"breakpoints" : {				"sm" : 576,				"md" : 768,				"lg" : 992,				"xl" : 1200,				"xxl" : 1200			},			"colors" : {				"theme" : {					"base" : {						"white" : "#ffffff",						"primary" : "#6993FF",						"secondary" : "#E5EAEE",						"success" : "#1BC5BD",						"info" : "#8950FC",						"warning" : "#FFA800",						"danger" : "#F64E60",						"light" : "#F3F6F9",						"dark" : "#212121"					},					"light" : {						"white" : "#ffffff",						"primary" : "#E1E9FF",						"secondary" : "#ECF0F3",						"success" : "#C9F7F5",						"info" : "#EEE5FF",						"warning" : "#FFF4DE",						"danger" : "#FFE2E5",						"light" : "#F3F6F9",						"dark" : "#D6D6E0"					},					"inverse" : {						"white" : "#ffffff",						"primary" : "#ffffff",						"secondary" : "#212121",						"success" : "#ffffff",						"info" : "#ffffff",						"warning" : "#ffffff",						"danger" : "#ffffff",						"light" : "#464E5F",						"dark" : "#ffffff"					}				},				"gray" : {					"gray-100" : "#F3F6F9",					"gray-200" : "#ECF0F3",					"gray-300" : "#E5EAEE",					"gray-400" : "#D6D6E0",					"gray-500" : "#B5B5C3",					"gray-600" : "#80808F",					"gray-700" : "#464E5F",					"gray-800" : "#1B283F",					"gray-900" : "#212121"				}			},			"font-family" : "Poppins" 		};  	</script>	<!--end::Global Config-->	<!--begin::Global Theme Bundle(used by all pages)--> 	<script		src="${pageContext.request.contextPath}/resources/assets/plugins/global/plugins.bundle.js"></script>	<script		src="${pageContext.request.contextPath}/resources/assets/plugins/custom/prismjs/prismjs.bundle.js"></script>	<script        		src="${pageContext.request.contextPath}/resources/assets/js/scripts.bundle.js"></script>		        			  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>   					<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_Signin.js"></script>  			          	<!--end::Global Theme Bundle--></body><!--end::Body--></html>