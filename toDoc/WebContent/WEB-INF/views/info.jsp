<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    
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
<script src="js/jquery-3.2.1.min.js"></script>	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>

<script type="text/javascript">
$(function () {
	$("#1holiday").click(function(){
		$("#1Start").val("00:00");
		$("#1End").val("00:00");
		$("#1LunchStart").val("00:00");
		$("#1LunchEnd").val("00:00");
	});
	$("#2holiday").click(function(){
		$("#2Start").val("00:00");
		$("#2End").val("00:00");
		$("#2LunchStart").val("00:00");
		$("#2LunchEnd").val("00:00");
	});
	$("#3holiday").click(function(){
		$("#3Start").val("00:00");
		$("#3End").val("00:00");
		$("#3LunchStart").val("00:00");
		$("#3LunchEnd").val("00:00");
	});
	$("#4holiday").click(function(){
		$("#4Start").val("00:00");
		$("#4End").val("00:00");
		$("#4LunchStart").val("00:00");
		$("#4LunchEnd").val("00:00");
	});
	$("#5holiday").click(function(){
		$("#5Start").val("00:00");
		$("#5End").val("00:00");
		$("#5LunchStart").val("00:00");
		$("#5LunchEnd").val("00:00");
	});
	$("#6holiday").click(function(){
		$("#6Start").val("00:00");
		$("#6End").val("00:00");
		$("#6LunchStart").val("00:00");
		$("#6LunchEnd").val("00:00");
	});
	$("#7holiday").click(function(){
		$("#7Start").val("00:00");
		$("#7End").val("00:00");
		$("#7LunchStart").val("00:00");
		$("#7LunchEnd").val("00:00");
	});
});

$(function(){
    checkLogin(60000); // 1000 밀리세컨드 = 1초

    function checkLogin(delay) {
        setTimeout(function() {
            var hasCookie, hasSession;

            var loginCookie = document.cookie.indexOf("hospital");
            if ((loginCookie > 0) && (typeof loginCookie === "number")) {
                hasCookie = true;
            }
            
            if (document.getElementById("logout") !== null) {
              hasSession = true;
            }

            if (hasCookie && hasSession) {
                console.log("isLogin: true");
            }
            else {
                if (hasCookie || hasSession) {
                    // 둘 중 하나만 존재하는 경우 로그아웃 페이지로 이동시킴
                    window.location.replace("/index.jsp");

                }
                else {
                    return false;
                }
            }

            checkLogin(60000); // 재귀함수를 사용하여 반복수행함
        }, delay);
    }
});
</script>

<script type="text/javascript">
$(function(){
	//form 의 submit 이벤트 처리
	$("#updateHospital").submit(function(){
		//입력한 값을 읽어온다.
	    var hosCode=$("#hosCode").val();
	    var hosName=$("#hosName").val();
	    var hosTel=$("#hosTel").val();
	    var hosAddress=$("#hosAddress").val();
	    var hosInfo=$("#hosInfo").val();
	   	    
	    //ajax 방식으로 전송한다.
	    $.post("updateHospital.do",
	    		{"hosCode":hosCode, "hosName":hosName,"hosTel":hosTel,"hosAddress":hosAddress,"hosInfo":hosInfo},
	    		function(){
	    	alert("병원 정보 수정이 완료되었습니다.");
	    })
	    .fail(function() { //비동기 요청 실패 시 실행
			alert("수정에 오류가 발생하였습니다. 다시 로그인하여 주시기 바랍니다.");
		});
	    return false; //기본 이벤트 막기 (페이지 이동하지 않도록)
	});
	
 	$(".updateDoctor").on("submit", function(event) {
 		event.preventDefault();
		//ajax 방식으로 전송한다.
	    $.get("updateDoctor.do?"+$(this).serialize(), function(flag){
	    	alert("의사 정보 수정이 완료되었습니다.");
	    })
	    .fail(function() { //비동기 요청 실패 시 실행
			alert("수정에 오류가 발생하였습니다. 다시 로그인하여 주시기 바랍니다.");
		});
		return false;
	}); 
 	
 	$(".updateTimeTable").on("submit", function(event) {
 		event.preventDefault();
		//ajax 방식으로 전송한다.
	    $.get("updateTimeTable.do?"+$(this).serialize(), function(flag){
	    	alert("시간표 수정이 완료되었습니다.");
	    })
	    .fail(function() { //비동기 요청 실패 시 실행
			alert("수정에 오류가 발생하였습니다. 다시 로그인하여 주시기 바랍니다.");
		});
		return false;
	}); 
});
</script>
</head>
<body>

<!-- Header -->
<div id="header">
	<div id="logo-wrapper">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
				<h1>
					<a href="showInfo.do?hosCode=${sessionScope.hospital.hosCode}">TODOC</a>
				</h1>
			</div>

		</div>
	</div>
	<div class="container">
		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="showReservationList.do">예약관리</a></li>
				<li class="active"><a href="showInfo.do?hosCode=${sessionScope.hospital.hosCode}">병원정보</a></li>
				<li><a href="showRecord.do">환자기록</a></li>
			</ul>
		</nav>
	</div>
</div>
<!-- Header -->

<!-- 병원정보로 바로가기 --><a name="hospital"></a>

<!-- Main -->
<div id="main">

<!-- Main Content -->
<div class="container">
<div class="row">
	
	<!-- 왼쪽 navi -->
	<section class="2u" style="position: fixed;">
		<section id="sidebar1">
			<section class="box">
				<img src="images/${sessionScope.hospital.hosImage}" alt="" style="width: 100px; height: 100px;"/>
				<br/>
				<h3 style="color: #0099ff;">${sessionScope.hospital.hosName}</h3>
				<p>
					현재 <span style="color: red" id="waitingNo">${fn:length(requestScope.treatmentList)}</span>명 
					<br/>대기중
				</p>
				<p style="text-align: center;">
					<input type="button" class="button" value="로그아웃"  style="font-size: 9pt;"
						   onclick="location.href='logout.do'"/>
				</p>
			</section>
			<ul class="default alt">
				<li><a href="#hospital">병원정보 </a></li>
				<li><a href="#doctor">의사정보</a></li>
				<li><a href="#timeTable">진료시간/휴무일</a></li>
			</ul>
		</section>
	</section>
	
	
	
	<!-- 오른쪽 정보 -->
	<section class="10u" style="float: right;">
	
		<blockquote>병원정보</blockquote>
		<section class="wrapper style1">
			<div class="inner">
				<!-- 2 Columns -->
				<div class="flex flex-2">
					<div class="col col1">
						<div class="image fit" style="width: 90%;">
							<img src="images/${hospital.hosImage}" alt="" /></a>
						</div>
					</div>
					
					<div class="col col2">
						<form action="updateHospital.do" method="post" id="updateHospital">
							<p>병원 이름 :
								<input type="text" value="${hospital.hosName}" id="hosName">
							</p>
							<p>전화 번호 : 
								<input type="text" value="${hospital.hosTel}" id="hosTel">
							</p>
							<p>병원 주소 : 
								<input type="text" value="${hospital.hosAddress}" id="hosAddress">
							</p>
							<p><span>병원 소개 :</span> 
								<textarea rows="3" cols="80" id="hosInfo" style="margin-top: 10px;">${hospital.hosInfo}</textarea>
							</p>
							
							<!-- 의사정보로 바로가기 --><a name="doctor"></a>
							<p style="text-align: right;">
								<input type="hidden" id="hosCode" value="${hospital.hosCode}">
								<input type="submit" class="button" value="수정"/>
							</p>
						</form>
					</div>
					
				</div>
			</div>
		</section>
							
		
		<blockquote>의사정보</blockquote>
		<section class="wrapper style1">
			<div class="inner">
				<div class="flex flex-3" id="doctorList">
				
					<c:forEach items="${doctors}" var="doctor">
						<div class="col align-center">
							<div class="image round fit" style="width: 50%; margin: 0px auto;">
								<a>
								<img src="images/profile_placeholder.gif" alt="" />
								</a>
							</div>
								
							<form method="get" class="updateDoctor" >
								<p style="margin-top: 20px;">의사 이름 :
									<input type="text" value="${doctor.docName}" name="docName">
								</p>
								<p>진료 과목 : 
									<input type="text" value="${doctor.docPart}" name="docPart">
								</p>
								
								<p style="text-align: right;">
									<input type="hidden" name="hosCode" value="${hospital.hosCode}">
									<input type="hidden" name="docCode" value="${doctor.docCode}">
									<input type="submit" value="수정" class="button"/>
									<input type="button" class="button" value="삭제" onclick="location.href='deleteDoctor.do?docCode=${doctor.docCode}'" style="text-decoration: none; height: 23px;"/>
								</p>
							</form> 
						</div>
					</c:forEach>
					
					<div class="col align-center">
						<div class="image round fit" style="width: 50%; margin: 0px auto;">
							<a>
							<img src="images/profile_placeholder.gif" alt="" />
							</a>
						</div>
							
						<form method="post" class="insertDoctor" action="insertDoctor.do">
							<p style="margin-top: 20px;">의사 이름 :
								<input type="text" value="" name="docName" id="docName">
							</p>
							<p>진료 과목 : 
								<input type="text" value="" name="docPart" id="docPart">
							</p>
							
							<p style="text-align: right;">
								<input type="submit" value="의사 추가" class="button"/>
							</p>
						</form> 
					</div>					
					
					
				</div>
				<!-- 진료시간정보로 바로가기 --><a name="timeTable"></a>
			</div>
		</section>
		
		<blockquote>진료시간/휴무일</blockquote>
		<section class="wrapper style1">
			
			<table>
				<thead>
					<tr>
						<th>요일</th>
						<th>진료시작시간</th>
						<th>진료마감시간</th>
						<th>점심시작시간</th>
						<th>점심마감시간</th>
						<th>휴무일설정</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${timetables}" var="timetable">
					<form method="get" class="updateTimeTable" >
						<tr>
							<td>
								<c:if test="${timetable.hosDay==1}"><font style="color: red;">일요일</font></c:if>
								<c:if test="${timetable.hosDay==2}">월요일</c:if>
								<c:if test="${timetable.hosDay==3}">화요일</c:if>
								<c:if test="${timetable.hosDay==4}">수요일</c:if>
								<c:if test="${timetable.hosDay==5}">목요일</c:if>
								<c:if test="${timetable.hosDay==6}">금요일</c:if>
								<c:if test="${timetable.hosDay==7}"><font style="color: blue;">토요일</font></c:if>
							</td>
							<td><input type="time" value="${timetable.hosOpen}" 
									id="${timetable.hosDay}Start" name="hosOpen"></td>
							<td><input type="time" value="${timetable.hosClose}" 
									id="${timetable.hosDay}End" name="hosClose"></td>
							<td><input type="time" value="${timetable.hosLunchStart}" 
									id="${timetable.hosDay}LunchStart" name="hosLunchStart"></td>
							<td><input type="time" value="${timetable.hosLunchEnd}" 
									id="${timetable.hosDay}LunchEnd" name="hosLunchEnd"></td>
							<td>
								<c:choose>
									<c:when test="${timetable.hosOpen=='00:00'}">
										<input type="checkbox" checked="checked" id="${timetable.hosDay}holiday"> 휴 무
									</c:when>
									<c:otherwise>
										<input type="checkbox" id="${timetable.hosDay}holiday"> 휴 무
									</c:otherwise>
								</c:choose>
								
							</td>
							
							<td>
								<input type="hidden" name="hosCode" value="${hospital.hosCode}">
								<input type="hidden" name="hosDay" value="${timetable.hosDay}">
								<input type="submit" value="수정" class="button"/>
							</td>	
						</tr>
					</form>
					</c:forEach>
				</tbody>
			</table>
			
		</section>
		
	</section>
	<!-- /오른쪽 끝 -->
	
</div>
</div>
<!-- /Main Content -->
	
	
</div>
<!-- /Main -->

</body>
</html>