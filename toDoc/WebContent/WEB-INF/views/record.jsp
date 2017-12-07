<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TODOC투닥</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href='http://fonts.googleapis.com/css?family=Questrial'
	rel='stylesheet' type='text/css'>
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<script type="text/javascript">
	$(function() {
		setInterval(recallReservationList, 10000)
		
		$("#search").on("submit",function() {			
			$.get("searchHistory.do?"+$(this).serialize(),recallHistoryList,"json")
				.fail(function() { //비동기 요청 실패 시 실행
		          alert("진료 기록을 불러오는데 실패하였습니다.");
		       					 }
				 );		
			return false;
		});
		
	});

	function recallReservationList() {
		console.log("recallReservationList");
		$.get("recallReservationList.do", {
			"hosCode" : "${sessionScope.hospital.hosCode}"
		}, recallList, "json");
	}

	function recallList(info) {
		$("#waitingNo").empty();
		$("#waitingNo").append(info.length);

	}
	
	
	function recallHistoryList(info) {
		$("#historyList").empty();
		
		if(info.lenth==0){
			$("<tr/>").append($("<td/>").attr("colspan","6")
										.appned("진료 기록이 존재하지 않습니다."))
				      .appendTo("#historyList");
		}else{
			for(var i=0;i<info.length;i++){
				$("<tr/>").append($("<td/>").append(info[i].treatCode))
						  .append($("<td/>").append(info[i].patName))
						  .append($("<td/>").append(info[i].patCode))
						  .append($("<td/>").append(info[i].treatDate))
						  .append($("<td/>").append(info[i].docName))
						  .append($("<td/>").append($("<input/>").attr("type","button")
								  								 .attr("value","처방전 재전송"))
								  		    .append(" ")
								  			.append($("<input/>").attr("type","button")
								  								 .attr("value","영수증 출력")))
						 .appendTo("#historyList");
				
											}			
		}
	}			
	
	
</script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
</head>
<body>

	<!-- Header -->
	<div id="header">
		<div id="logo-wrapper">
			<div class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="showRecord.do">TODOC</a>
					</h1>
				</div>

			</div>
		</div>
		<div class="container">
			<!-- Nav -->
			<nav id="nav">
			<ul>
				<li><a href="showReservationList.do">예약관리</a></li>
				<li><a
					href="showInfo.do?hosCode=${sessionScope.hospital.hosCode}">병원정보</a></li>
				<li class="active"><a href="showRecord.do">환자기록</a></li>
			</ul>
			</nav>
		</div>
	</div>
	<!-- Header -->

	<!-- Main -->
	<div id="main">

		<!-- Main Content -->
		<div class="container">
			<div class="row">
				<section class="2u" style="position: fixed;"> <section
					class="box"> <img src="images/profile_placeholder.gif"
					alt="" />
				<h3 style="color: #0099ff;">${sessionScope.hospital.hosName}</h3>
				<p>
					현재 <span style="color: red" id="waitingNo">${fn:length(requestScope.treatmentList)}
					</span>명 대기중
				</p>
				</section> </section>

				<section class="10u" style="float: right;"> 
				<section class="box_period01">
				<div class="scont">
					<form id="search">
						<span>이름검색</span><input type="text" name="patName" /> <span>날짜검색</span>
						<span> <input type="date" name="date1" />
						</span> <span>~</span> <span> <input type="date" name="date2" />
						</span> <span> <input type="submit" class="button" value="조회">
						</span>
					</form>
				</div>
				</section>
				<h4 style="text-align: center">환자기록</h4>
				</br>
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>진료코드</th>
								<th>환자이름</th>
								<th>주민번호</th>
								<th>진료일시</th>
								<th>담당의사</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody id=historyList>
							<c:choose>
								<c:when test="${empty requestScope.historyList}">
									<tr>
										<td colspan="6">진료 기록이 존재하지 않습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${requestScope.historyList}" var="history">
										<tr>
											<td>${history.treatCode}</td>
											<td>${history.patName}</td>
											<td>${history.patCode}</td>
											<td>${history.treatDate}</td>
											<td>${history.docName}</td>
											<td><input type="button" value="처방전 재전송" /> <input
												type="button" value="영수증 출력" /></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				</section>
			</div>
		</div>
		<!-- /Main Content -->
	</div>
	<!-- Main -->
</html>