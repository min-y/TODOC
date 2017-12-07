<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TODOC투닥</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Questrial' rel='stylesheet' type='text/css'>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<script type="text/javascript">
$(function() {
	setInterval(recallReservationList,10000)
	
	$("#reservationList").on("click",".delete",function() {
		var $treatCode=$(this).attr("data_treatCode");
		console.log($treatCode);
		console.log("${sessionScope.hospital.hosCode}");
		$.get("deleteReservation.do",{"hosCode" :"${sessionScope.hospital.hosCode}",
									  "treatCode":$treatCode},recallReservationList,"json");
		
		
	});
	
	$("#reservationList").on("click",".status",function() {
		var $treatCode=$(this).attr("data_treatCode");
		console.log($treatCode);
		console.log("${sessionScope.hospital.hosCode}");
		$.get("updateStatus.do",{"hosCode" :"${sessionScope.hospital.hosCode}",
							     "treatCode":$treatCode},recallReservationList,"json");
	});
	
	$("#reservationList").on("click",".submit",function() {
		var $treatCode=$(this).attr("data_treatCode");
		var $docCode=$(this).attr("data_docCode");
		var $patCode=$(this).attr("data_patCode");
		console.log($treatCode);
		console.log("${sessionScope.hospital.hosCode}");
		$.get("insertToHistory.do",{"hosCode" :"${sessionScope.hospital.hosCode}",
							     "treatCode":$treatCode,
							     "docCode":$docCode,
							     "patCode":$patCode},recallReservationList,"json");
	});
	
	$("#addReservation").on("click", function(){
		addReservation();
	});
	
});


function addReservation(){
	window.open("<%=request.getContextPath()%>/index.jsp", "findWindow", "top=200,left=450,width=400,height=500");
}

function recallReservationList() {
	console.log("recallReservationList");
	$.get("recallReservationList.do",{"hosCode" :"${sessionScope.hospital.hosCode}"},recallList,"json");
}	

function recallList(info){
	$("#waitingNo").empty();
	$("#waitingNo").append(info.length);			
	
	$("#reservationList").empty();
		
	for(var i=0;i<info.length;i++) {
	var	$tr=$("<tr/>").append($("<td/>").append(i+1))
				 	  .append($("<td/>").append(info[i].patName))
				 	  .append($("<td/>").append(info[i].patCode))
				 	  .append($("<td/>").append(info[i].treatTime))
				 	  .append($("<td/>").append(info[i].docName));
	
	if(info[i].treatStatus==1){
		$tr.append($("<td/>").append($("<input/>").attr("type", "button")
												  .attr("value","예약")
												  .attr("data_treatCode",info[i].treatCode)
												  .attr("class","status")))				  
		   .append($("<td/>").append($("<input/>").attr("type", "button")
												  .attr("value","삭제")
												  .attr("data_treatCode",info[i].treatCode)
												  .attr("class","delete")))
           .appendTo("#reservationList");									  
	}else if(info[i].treatStatus==2){
		$tr.append($("<td/>").append($("<input/>").attr("type", "button")
				  								  .attr("value","대기")
				  								  .attr("data_treatCode",info[i].treatCode)
				  								  .attr("class","status")))				  
		   .append($("<td/>").append($("<input/>").attr("type", "button")
				                                  .attr("value","삭제")
				                                  .attr("data_treatCode",info[i].treatCode)
				                                  .attr("class","delete")))
           .appendTo("#reservationList");			
		
	}else if(info[i].treatStatus==3){
		$tr.append($("<td/>").append($("<input/>").attr("type", "button")
				  								  .attr("value","진료 중")
				                                  .attr("data_treatCode",info[i].treatCode)
				                                  .attr("class","status")))				  
           .append($("<td/>").append($("<input/>").attr("type", "button")
                                                  .attr("value","삭제")
                                                  .attr("disabled","disabled")))
           .appendTo("#reservationList");			
	}else if(info[i].treatStatus==4){
		$tr.append($("<td/>").append($("<input/>").attr("type", "button")
				  								  .attr("value","진료 완료")
                                                  .attr("data_treatCode",info[i].treatCode)
                                                  .attr("disabled","disabled")
                                                  .attr("class","status")))				  
           .append($("<td/>").append($("<input/>").attr("type", "button")
                                                  .attr("value","전송")
                                                  .attr("data_treatCode",info[i].treatCode)
                                                  .attr("data_docCode",info[i].docCode)
                                                  .attr("data_patCode",info[i].patCode)
                                                  .attr("class","submit")))
           .appendTo("#reservationList");			
    }
		 
	};
}


</script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
</head>
<body class="homepage">

<!-- Header -->
<div id="header">
	<div id="logo-wrapper">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
				<h1>
					<a href="showReservationList.do">TODOC</a>
				</h1>
			</div>

		</div>
	</div>
	
	<div class="container">
		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li class="active"><a href="showReservationList.do">예약관리</a></li>
				<li><a href="showInfo.do?hosCode=${sessionScope.hospital.hosCode}">병원정보</a></li>
				<li><a href="showRecord.do">환자기록</a></li>
			</ul>
		</nav>
	</div>
</div>
<!-- Header -->

<!-- Main -->
<div id="main">

<!-- Featured -->
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
			
			
			<section class="profiles">
				<div class="">
					<c:choose>
						<c:when test="${empty requestScope.doctorList}">
						<section class="6u(medium) 12u$(xsmall) profile">
						<img src="images/profile_placeholder.gif" alt="" style="width: 30%; height: 30%;" />
						<h4>의사를 등록하세요.</h4>
					</section>
						</c:when>
						<c:otherwise>
							<c:forEach items="${requestScope.doctorList}" var="doctor">
								<a href="${pageContext.request.contextPath}/showReseravtionListByDoctor.do?docCode=${doctor.docCode}">
									<section class="6u(medium) 12u$(xsmall) profile" data_docCode="${doctor.docCode}">
									<img src="${doctor.docImage}" alt="" style="width: 30%; height: 30%;" />
									<h4>${doctor.docName} 전문의</h4>
									<p>${doctor.docPart}</p>
									</section>
								</a>
							</c:forEach>	
						</c:otherwise>
					</c:choose>
				</div>
			</section>
		</section>
	</section>
	
	
	
	
	<section class="10u" style="float: right;">
		<h4 style="text-align: center">다음진료</h4></br>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>순서</th>
						<th>담당의사</th>
						<th>환자이름</th>
						<th>주민번호</th>
						<th>예약일시</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty requestScope.nexttreatmentList}">
							<tr>
								<td colspan="7">진료 리스트가 없습니다.</td>
							</tr>
						</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.nexttreatmentList}" var="treatment" varStatus="no">
							<tr>
								<td>${no.index+1}</td>
								<td>${treatment.docName}</td>
								<td>${treatment.patName}</td>
								<td>${treatment.patCode}</td>
								<td>${treatment.treatTime}</td>
								<c:if test="${treatment.treatStatus==1}">
								<td><input type="button" value="예약" class="status" data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="삭제" class="delete" data_treatCode="${treatment.treatCode}"/></td>	
								</c:if>
								<c:if test="${treatment.treatStatus==2}">
								<td><input type="button" value="대기" class="status" data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="삭제" class="delete" data_treatCode="${treatment.treatCode}"/></td>	
								</c:if>																					
								<c:if test="${treatment.treatStatus==3}">
								<td><input type="button" value="진료 중" class="status"  data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="삭제" disabled="disabled" data_treatCode="${treatment.treatCode}"/></td>	
								</c:if>																					
								<c:if test="${treatment.treatStatus==4}">
								<td><input type="button" value="진료 완료" class="status" disabled="disabled" data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="전송" class="submit" data_treatCode="${treatment.treatCode}"/></td>										
								</c:if>																					
							</tr>
						</c:forEach>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		</br></br>
		<h4 style="text-align: center">진료대기</h4></br>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>순서</th>
						<th>환자이름</th>
						<th>주민번호</th>
						<th>예약일시</th>
						<th>담당의사</th>
						<th>상태</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody id="reservationList">
					<c:choose>
						<c:when test="${empty requestScope.treatmentList}">
							<tr>
								<td colspan="7">진료 리스트가 없습니다.</td>
							</tr>
						</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.treatmentList}" var="treatment" varStatus="no">
							<tr>
								<td>${no.index+1}</td>
								<td>${treatment.patName}</td>
								<td>${treatment.patCode}</td>
								<td>${treatment.treatTime}</td>
								<td>${treatment.docName}</td>
								<c:if test="${treatment.treatStatus==1}">
								<td><input type="button" value="예약" class="status" data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="삭제" class="delete" data_treatCode="${treatment.treatCode}"/></td>	
								</c:if>
								<c:if test="${treatment.treatStatus==2}">
								<td><input type="button" value="대기" class="status" data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="삭제" class="delete" data_treatCode="${treatment.treatCode}"/></td>	
								</c:if>																					
								<c:if test="${treatment.treatStatus==3}">
								<td><input type="button" value="진료 중" class="status"  data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="삭제" disabled="disabled" data_treatCode="${treatment.treatCode}"/></td>	
								</c:if>																					
								<c:if test="${treatment.treatStatus==4}">
								<td><input type="button" value="진료 완료" class="status" disabled="disabled" data_treatCode="${treatment.treatCode}"/></td>										
								<td><input type="button" value="전송" class="submit" data_treatCode="${treatment.treatCode}"/></td>										
								</c:if>																					
							</tr>
						</c:forEach>
					</c:otherwise>
					</c:choose>
				</tbody>
					<%-- 	<td style="vertical-align: bottom;">
							<a href="delete.do?userId=${user.userId}">
								<i class="material-icons">&#xe92b;</i>
							</a>
						</td> --%>
				<tfoot>
					<tr>
						<td colspan="4"></td>
						<td colspan="2"><input type="button" id="addReservation" value="예약추가"
							style="float: right" /></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</section>
</div>
</div>
<!-- /Featured -->

</div>
<!-- /Main -->
</body>
</html>