<!DOCTYPE html><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!--Template Name: Metronic - Bootstrap 4 HTML, React, Angular 10 & VueJS Admin Dashboard ThemeAuthor: KeenThemesWebsite: http://www.keenthemes.com/Contact: support@keenthemes.comFollow: www.twitter.com/keenthemesDribbble: www.dribbble.com/keenthemesLike: www.facebook.com/keenthemesPurchase: https://1.envato.market/EA4JPRenew Support: https://1.envato.market/EA4JPLicense: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.--><html lang="ko"><head>	<title>관리자 예약목록 | Gangstudy</title>	<meta name="description" content="Javascript sourced data examples" />	<%@ include file="/WEB-INF/views/layout/admin_header.jsp"%>   	   	<!--begin::Page Vendors Styles(used by this page)-->	<link href="${pageContext.request.contextPath}/resources/assets/css/view/bookingList.css" rel="stylesheet" type="text/css" />	<!--end::Page Vendors Styles--></head><body class="header-fixed header-mobile-fixed subheader-enabled subheader-fixed page-loading" id="kt_body">	<!--begin::Main-->	<div class="d-flex flex-column flex-root">		<!--begin::Page-->		<div class="d-flex flex-row flex-column-fluid page">			<!--begin::Wrapper-->			<div class="d-flex flex-column flex-row-fluid wrapper" id="kt_wrapper">				<!--begin::Content-->				<div class="content d-flex flex-column flex-column-fluid" id="kt_content">					<!--begin::Container-->					<div class="container">						<div class="row" >							<div class="col-md-11 col-sm-12 col-12">								<!--begin::Card-->								<div class="card card-custom example example-compact">									<!--begin::Card header-->									<div class="form-group form-group-last"> 										<div class="alert-text">											<p class="myinfo_text d-none d-xl-block">예약 목록</p>											<p class="mobile_myinfo_text d-xl-none">예약 목록</p>										</div>									</div>									<!--end::Card header-->									<div class="card-body">  										<!--begin: Datatable-->										<table class="table tabletable-hover table-striped" id="kt_datatable">											<thead>   												<tr>  													<th>예약번호</th>													<th>예약자 이름</th>													<th>시작시간</th>													<th>종료시간</th>													<th>인원수</th>													<th>예약상태</th>													<th>요청시간</th>												</tr>											</thead>     										</table>   										<!--end: Datatable-->									</div>								</div>								<!--end::Card-->							</div>						</div>					</div>					<!--end::Container-->				</div>				<!--end::Content-->				<%@ include file="/WEB-INF/views/layout/footer-include2.jsp"%> 			</div>			<!--end::Wrapper-->		</div>		<!--end::Page-->	</div>	<!--end::Main-->		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>	<!--begin::Page Vendors(used by this page)-->	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>	<script src="${pageContext.request.contextPath}/resources/assets/plugins/custom/datatables/datatables.bundle.js"></script>		<script type="text/javascript"> var books='${books}' </script>		<script src="${pageContext.request.contextPath}/resources/js/admin-bookingList.js"></script>	<!--end::Page Vendors--></body>