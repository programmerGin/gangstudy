
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
<html lang="ko">

<style>
@font-face { 
    font-family: 'Cafe24Oneprettynight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
     

</style>

<!--begin::Head-->
<head>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width user-scalable=no, initial-scale=1, shrink-to-fit=no" />
<title>예약하기 | Gangstudy</title>
<meta name="description" content="ECommerce Shopping Cart" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="canonical" href="https://gangstudy.com" />
<!--begin::Fonts-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
<!--end::Fonts-->
<!--begin::Global Theme Styles(used by all pages)-->
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/global/plugins.bundle.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/custom/prismjs/prismjs.bundle.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/css/style.bundle.css"
	rel="stylesheet" type="text/css" />
<!--end::Global Theme Styles-->
<!--begin::Layout Themes(used by all pages)-->
<!--end::Layout Themes-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/assets/media/logos/logo.png" />
</head>
<!--end::Head-->
<!--begin::Body-->
<body id="kt_body"
	class="header-mobile-fixed aside-enabled aside-fixed aside-secondary-enabled page-loading">
	<!--begin::Main-->
	<!--begin::Header Mobile-->
	<div id="kt_header_mobile" class="header-mobile">
		<!--begin::Toolbar-->
		<div class="d-flex align-items-center"></div>
		<!--end::Toolbar-->
	</div>
	<!--end::Header Mobile-->
	<div class="d-flex flex-column flex-root">
		<!--begin::Page-->
		<div class="d-flex flex-row flex-column-fluid page">
			<!--begin::Aside-->
			<div class="aside aside-left d-flex aside-fixed" id="kt_aside">
				<!--begin::Primary-->
				<div
					class="aside-primary d-flex flex-column align-items-center flex-row-auto">
					<!--begin::Brand-->
					<div
						class="aside-brand d-flex flex-column align-items-center flex-column-auto py-5 py-lg-12">
					</div>
					<!--end::Brand-->
					<!--begin::Nav Wrapper-->

					<!--end::Nav Wrapper-->
					<!--begin::Footer-->

					<!--end::Footer-->
				</div>
				<!--end::Primary-->
				<!--begin::Secondary-->
				<div class="aside-secondary d-flex flex-row-fluid">
					<!--begin::Workspace-->
					<div class="aside-workspace scroll scroll-push my-2">
						<!--begin::Tab Content-->
						<div class="tab-content">
							<!--begin::Tab Pane-->

							<!--end::Tab Pane-->
							<!--begin::Tab Pane-->
							<div class="tab-pane fade" id="kt_aside_tab_2">
								<!--begin::Aside Menu-->
								<div class="aside-menu-wrapper flex-column-fluid px-10 py-5"
									id="kt_aside_menu_wrapper">
									<!--begin::Menu Container-->
									<div id="kt_aside_menu" class="aside-menu min-h-lg-800px"
										data-menu-vertical="1" data-menu-scroll="1">
										<!--begin::Menu Nav-->




										<!--end::Svg Icon-->


										<!--end::Svg Icon-->

										<!--end::Menu Nav-->
									</div>
									<!--end::Menu Container-->
								</div>
								<!--end::Aside Menu-->
							</div>
							<!--end::Tab Pane-->
						</div>
						<!--end::Tab Content-->
					</div>
					<!--end::Workspace-->
				</div>
				<!--end::Secondary-->
			</div>
			<!--end::Aside-->
			<!--begin::Wrapper-->
			<div class="d-flex flex-column flex-row-fluid wrapper"
				id="kt_wrapper">
				<!--begin::Content-->
				<div class="content d-flex flex-column flex-column-fluid"
					id="kt_content">
					<!--begin::Subheader-->
					<div class="subheader py-3 py-lg-8" id="kt_subheader">
						<div
							class="d-flex align-items-center justify-content-between flex-wrap flex-sm-nowrap">
							<!--begin::Info-->
							<div class="d-flex align-items-center flex-wrap mr-1">
								<!--begin::Mobile Toggle-->

								<!--end::Mobile Toggle-->
								<!--begin::Page Heading-->
								<div class="d-flex align-items-baseline flex-wrap mr-5">
									<!--begin::Page Title-->
									<h2
										class="subheader-title text-dark font-weight-bold my-1 mr-3">

									</h2>
									<!--end::Page Title-->
									<!--begin::Breadcrumb-->

									<!--end::Breadcrumb-->
								</div>
								<!--end::Page Heading-->
							</div>
							<!--end::Info-->
							<!--begin::Toolbar-->

							<!--end::Toolbar-->
						</div>
					</div>
					<!--end::Subheader-->
					<!--begin::Entry-->
					<div class="d-flex flex-column-fluid cafe24" >
						<!--begin::Container-->   
						<div class="container">
							<!--begin::Page Layout-->
							<div class="d-flex flex-row">
								<!--begin::Aside-->
 
								<!--end::Aside-->
								<!--begin::Layout-->
								<div class="flex-row-fluid ml-lg-8">
									<!--begin::Section-->
									<div class="card card-custom gutter-b">
										<!--begin::Header-->
										<div class="card-header flex-wrap border-0 pt-6 pb-0">
											<h3 class="card-title align-items-start flex-column">
												<span
													class="card-label font-weight-bolder font-size-h3 text-dark">
			
				<i class="la la-user"></i><input type="text" name="name" value="${sUserId.name}" readonly
					placeholder="수정불가" id="name" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; width:30%;"> 
			 님의  결제정보</span>        
		               
			                   
			    
			
											</h3>          
											<!--begin::Logo-->
											<a href="/"> <img alt="Logo"
												src="${pageContext.request.contextPath}/resources/assets/media/logos/logo-g1.png"
												class="logo-default max-h-30px" />
											</a>
											<!--end::Logo-->

										</div>
										<!--end::Header-->
										<div id="kakaopay"></div>
										<div class="card-body">
											<!--begin::Shopping Cart-->
											<div class="table-responsive">
												<table class="table">
													<!--begin::Cart Header-->
													<thead>    
														<tr>      
															<th></th>
															<th class="text-center"></th>             
															<th class="text-right"></th>    
															<th></th>                     
														</tr>        
													</thead>        
													<!--end::Cart Header-->                             
													<tbody>                            
														<!--begin::Cart Content-->        
														<tr>    
															<td class="d-flex align-items-center font-weight-bolder">
																<!--begin::Symbol--> <!--end::Symbol-->
																<div class="text-dark">인원수</div>
															</td>      

															<td class="text-center align-middle"><div class="form-group" style="width:120%;" >     
													   
													
														<input id="touchspin" type="text"
															class="form-control" value=${people} name="demo"
															style="text-align: center; width:20px;">
													</div> <!-- <a
																href="javascript:;"
																class="btn btn-xs btn-light-success btn-icon mr-2">
																	<i class="ki ki-minus icon-xs"></i>
															</a>           
															
															<span class="mr-2 font-weight-bolder">5</span> 
															
															<a
																href="javascript:;"
																class="btn btn-xs btn-light-success btn-icon"> <i
																	class="ki ki-plus icon-xs"></i>
															</a> --></td>





															<!-- <td class="text-right align-middle">
																	<a href="#" class="btn btn-danger font-weight-bolder font-size-sm">Remove</a>
																</td> -->
														</tr>
														<tr>
															<td class="d-flex align-items-center font-weight-bolder">
																<div class="text-dark">총 이용시간</div>
															</td>

															<td class="text-center align-middle"><input	
																id="time" type="text" class="form-control" value="${timeInterval}"
																name="demo0" placeholder="Select time" readonly
																style="text-align: center; width:120%;" /></td>

															<td class="text-right align-middle font-weight-bolder" id="startDateTime">
																시작:<br/>${startDateTime}
															</td>     

															<!--     
															탬플릿에 기존에 있던 + - 테그    
															 <a
															href="javascript:;"
																class="btn btn-xs btn-light-success btn-icon mr-2">
																	<i class="ki ki-minus icon-xs"></i>
															</a> <span class="mr-2 font-weight-bolder">6</span> <a
																href="javascript:;"
																class="btn btn-xs btn-light-success btn-icon"> <i
																	class="ki ki-plus icon-xs"></i>
															</a> -->




															<!--  시간 & 날짜 선택하는 폼 	작은사이즈
																<td>   
														<div class="col">
															<div class="input-group date" id="kt_datetimepicker_7_1" data-target-input="nearest">
																<input type="text" class="form-control datetimepicker-input" placeholder="Start date" data-target="#kt_datetimepicker_7_1">
																<div class="input-group-append" data-target="#kt_datetimepicker_7_1" data-toggle="datetimepicker">
																	<span class="input-group-text">
																		<i class="ki ki-calendar"></i>
																	</span>
																</div>
															</div>
														</div>
														</td>
															
															<td
																class="text-right align-middle font-weight-bolder font-size-h5">
															</td>
														<td>
														<div class="col">
															<div class="input-group date" id="kt_datetimepicker_7_2" data-target-input="nearest">
																<input type="text" class="form-control datetimepicker-input" placeholder="End date" data-target="#kt_datetimepicker_7_2">
																<div class="input-group-append" data-target="#kt_datetimepicker_7_2" data-toggle="datetimepicker">
																	<span class="input-group-text">
																		<i class="ki ki-calendar"></i> 
																	</span>
																</div>
															</div>
														</div>
															</td>  -->





															<!-- 	시간 & 날짜 선택하는 폼 기본사이즈
															
																						<td class="text-middle align-middle font-weight-bolder" width="150px" >
																<div class="form-group">
									<label> 시작 시간</label> <input class="form-control " value="클릭"
										type="datetime-local" id="example-datetime-local-input" style="text-align:center; width:100px;">
								</div>    
								<div class="form-group">
									<label> 종료 시간</label> <input class="form-control" value="클릭"
										type="datetime-local" id="example-datetime-local-input" style="text-align:center; width:100px;">
								</div>
																</td> -->
															<td class="text-right align-middle font-weight-bolder" id="endDateTime">
																 종료:<br/>${endDateTime}
															</td>  
														</tr>      
														<tr>
															<td class="d-flex align-items-center font-weight-bolder">
																<div class="text-dark">사용 포인트</div>
															</td>
															<td class="text-center align-middle">
															 <input id="kt_touchspin" type="text"
																class="form-control" value="0" name="pointUse" style="text-align: center; width:120%;"/>
																<!-- <a
																href="javascript:;"
																class="btn btn-xs btn-light-success btn-icon mr-2">
																	<i class="ki ki-minus icon-xs"></i>
															</a> <span class="mr-2 font-weight-bolder">1</span> <a
																href="javascript:;"
																class="btn btn-xs btn-light-success btn-icon"> <i    
																	class="ki ki-plus icon-xs"></i>
															</td>
															-->
															<td class="text-right align-middle font-weight-bolder ">보유 포인트:<br/>
																<div id="pointMax">${point}</div>
															</td>
															<td class="text-right align-middle"><a
																class="btn btn-light-primary font-weight-bolder font-size-sm" id="pointMaxUseBtn">전액 사용</a></td>
														</tr>
														<!--end::Cart Content-->
														<!--begin::Cart Footer-->
														<tr>
															<td colspan="2"></td>
															<div id="chargePerPeople" style="display:none">${chargePerPeople}</div>
															<td class="font-weight-bolder font-size-h4 text-right">최종 결제 금액</td>
															<td class="font-weight-bolder font-size-h4 text-right">
																<span id="totalAmount">${charge}</span>원</td>
														</tr>
														<tr>
															<!-- 결제금액 밑에 적을사항 있으면 여기 td 사이에 적기 -->
															<td colspan="4"
																class="border-0 text-muted text-right pt-0"></td>
														</tr>
														<tr>
															<td colspan="3" class="border-0 pt-10">
																<form><a href="/" class="btn btn-secondary font-weight-bolder px-8">다시 설정하기  </a></form>
															</td>
															<td colspan="1" class="border-0 text-right pt-10">
																<a class="btn btn-light-warnning font-weight-bolder " id="payments">
																<img src="${pageContext.request.contextPath}/resources/images/payment_icon_yellow_small.png"></a>
																<button class="btn btn-light-primary font-weight-bolder px-8" id="pay" name="danal">다날 결제 </button>
															</td>
														</tr>
														<!--end::Cart Footer-->     
													</tbody>
												</table>
											
											<h1><b>  죄송하지만 지금은 홈페이지 리뉴얼중입니다. 예약&결제는 메인화면의 "카톡으로 문의하기" 를 이용해 주세요 감사합니다. </b></h1>
												
											</div>
											<!--end::Shopping Cart-->       
										</div>
									</div>
									<!--end::Section-->
									<!--begin::Section-->
									<div class="card card-custom"></div>
									<!--end::Section-->
								</div>
								<!--end::Layout-->
							</div>
							<!--end::Page Layout-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Entry-->
				</div>
				<!--end::Content-->
				<!--begin::Footer-->
				<!--doc: add "bg-white" class to have footer with solod background color-->
				<%@ include file="/WEB-INF/views/partials/_footer.jsp"%>
			<%-- 	<div class="footer py-4 d-flex flex-lg-column" id="kt_footer">
					<!--begin::Container-->
					<div
						class="container d-flex flex-column flex-md-row align-items-center justify-content-between">
						<!--begin::Copyright-->
						<div class="text-dark order-2 order-md-1">
							<a href="/admin"> <span
								class="text-muted font-weight-bold mr-2">대표이사 김정훈 </span></a> <a
								href="/" target="_blank"
								class="text-dark-75 text-hover-primary">갱스터디</a>
						</div>
						<!--end::Copyright-->
						<!--begin::Nav-->
						<div class="nav nav-dark">
							<a href="http://pf.kakao.com/_xbgCJxb" target="_blank"
								class="nav-link pl-0 pr-5">카톡으로 문의하기 </a> <a
								href="tel:+821021367733" target="_blank"
								class="nav-link pl-0 pr-5">전화하기 </a> <a
								onclick="window.open('${pageContext.request.contextPath}/resources/images/regit.png','_blank','scrollbars=no,width=564,height=860,top=10,left=20');"
								target="_blank" class="nav-link pl-0 pr-0">사업자 등록 번호 :
								783-17-01344</a>
						</div>
						<!--end::Nav-->
					</div>
					<!--end::Container-->
				</div> --%>
				<!--end::Footer-->
			</div>
			<!--end::Wrapper-->
		</div>
		<!--end::Page-->
	</div>
	<!--end::Main-->
	<!--begin::Quick Actions Panel-->
	<div id="kt_quick_actions" class="offcanvas offcanvas-left p-10">
		<!--begin::Header-->
		<div
			class="offcanvas-header d-flex align-items-center justify-content-between pb-10">
			<h3 class="font-weight-bold m-0">
				Quick Actions <small class="text-muted font-size-sm ml-2">finance
					&amp; reports</small>
			</h3>
			<a href="#" class="btn btn-xs btn-icon btn-light btn-hover-primary"
				id="kt_quick_actions_close"> <i
				class="ki ki-close icon-xs text-muted"></i>
			</a>
		</div>
		<!--end::Header-->
		<!--begin::Content-->
		<div class="offcanvas-content pr-5 mr-n5">
			<div class="row gutter-b">
				<!--begin::Item-->

				<!--end::Item-->
				<!--begin::Item-->

				<!--end::Item-->
			</div>
		</div>
		<!--end::Content-->
	</div>
	<!--end::Quick Actions Panel-->
	<!-- begin::User Panel-->

	<!-- end::User Panel-->
	<!--begin::Quick Panel-->

	<!--end::Chat Panel-->
	<!--begin::Scrolltop-->
	<div id="kt_scrolltop" class="scrolltop">
		<span class="svg-icon"> <!--begin::Svg Icon | path:${pageContext.request.contextPath}/resources/assets/media/svg/icons/Navigation/Up-2.svg-->
			<svg xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
				height="24px" viewBox="0 0 24 24" version="1.1">
					<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
						<polygon points="0 0 24 0 24 24 0 24" />
						<rect fill="#000000" opacity="0.3" x="11" y="10" width="2"
					height="10" rx="1" />
						<path
					d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z"
					fill="#000000" fill-rule="nonzero" />
					</g>    
				</svg> <!--end::Svg Icon-->
		</span>
	</div>
	<!--end::Scrolltop-->
	<!--begin::Sticky Toolbar-->

	<!--end::Sticky Toolbar-->
	<!--begin::Demo Panel-->

	<!--end::Demo Panel-->
	<script>
		var HOST_URL = "https://preview.keenthemes.com/metronic/theme/html/tools/preview";
	</script>
	<!--begin::Global Config(global config for global JS scripts)-->
	<script>
		var KTAppSettings = {
			"breakpoints" : {
				"sm" : 576,
				"md" : 768,
				"lg" : 992,
				"xl" : 1200,
				"xxl" : 1200
			},
			"colors" : {
				"theme" : {
					"base" : {
						"white" : "#ffffff",
						"primary" : "#1BC5BD",
						"secondary" : "#E5EAEE",
						"success" : "#1BC5BD",
						"info" : "#6993FF",
						"warning" : "#FFA800",
						"danger" : "#F64E60",
						"light" : "#F3F6F9",
						"dark" : "#212121"
					},
					"light" : {
						"white" : "#ffffff",
						"primary" : "#1BC5BD",
						"secondary" : "#ECF0F3",
						"success" : "#C9F7F5",
						"info" : "#E1E9FF",
						"warning" : "#FFF4DE",
						"danger" : "#FFE2E5",
						"light" : "#F3F6F9",
						"dark" : "#D6D6E0"
					},
					"inverse" : {
						"white" : "#ffffff",
						"primary" : "#ffffff",
						"secondary" : "#212121",
						"success" : "#ffffff",
						"info" : "#ffffff",
						"warning" : "#ffffff",
						"danger" : "#ffffff",
						"light" : "#464E5F",
						"dark" : "#ffffff"
					}
				},
				"gray" : {
					"gray-100" : "#F3F6F9",
					"gray-200" : "#ECF0F3",
					"gray-300" : "#E5EAEE",
					"gray-400" : "#D6D6E0",
					"gray-500" : "#B5B5C3",
					"gray-600" : "#80808F",
					"gray-700" : "#464E5F",
					"gray-800" : "#1B283F",
					"gray-900" : "#212121"
				}
			},
			"font-family" : "Poppins"
		};             
		
		
	
		
		
	</script>
	<!--end::Global Config-->
	<!--begin::Global Theme Bundle(used by all pages)-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/global/plugins.bundle.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/custom/prismjs/prismjs.bundle.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/scripts.bundle.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/custom/fullcalendar/fullcalendar.bundle.js"></script>
	<!--end::Global Theme Bundle-->
	
	<script src="${pageContext.request.contextPath}/resources/js/booking.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/makecart.js"></script>
	<!--begin:: I'm port -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/iamport.js"></script>
			<!--end:: I'm port  -->
</body>
<!--end::Body-->
</html>

