<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOPHARM투팜</title>
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
	setInterval(recallWaitList,10000)
});

function recallWaitList() {
	console.log("recallWaitList");
	$.get("recallWaitList.do",{"pharmCode" :"${sessionScope.pharmCode}"},recallList,"json");
}	

function recallList(info){
	$("#waitList").empty();
	for(var i=0;i<info.length;i++) {
	console.log(info[i].preCode);
	var	$tr=$("<tr/>").append($("<td/>").append(i+1))
				 	  .append($("<td/>").append($("<a/>").append(info[i].prescription.patName)
				 			  				.attr("class", "view")
							  				.attr("preCode",info[i].preCode)))
				 	  .append($("<td/>").append(info[i].accDate))
					  .append($("<td/>").append($("<input/>").attr("type", "button")
												  .attr("value","승인")
												  .attr("class","button")
												  .attr("onclick","approveFunc("+info[i].preCode+")"))
										.append(" ")
										.append($("<input/>").attr("type", "button")
												  .attr("value","거절")
												  .attr("class","button")
												  .attr("onclick","denyFunc("+info[i].preCode+")"))
					  		 )		
           .appendTo("#waitList");
	};
}

function approveFunc(preCode){
	location.href = "wait_update.do?preCode="+preCode;
}

function denyFunc(preCode){
	location.href = "wait_delete.do?preCode="+preCode;
}

</script>
<style>

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
</head>
<body>
<body class="homepage">

	<!-- Header -->
	<div id="header">
		<div id="logo-wrapper">
			<div class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="index.jsp">TOPHARM</a>
					</h1>
				</div>

			</div>
		</div>
		<div class="container">
			<!-- Nav -->
			<nav id="nav">
			<ul>
				<li class="active"><a href="reservation_list.do">접수현황</a></li>
				<li><a href="info_list.do">처방내역</a></li>
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
				<section class="2u" style="position: fixed"> <section
					class="box"> <img src="images/medicine.png"
					alt="" />
				<h3>${sessionScope.pharmName}</h3>
				현재 <span style="color: red">${sessionScope.waitNum}</span>명 대기중
				<p>
					<form action="logout.do">
						<input type="submit" class="button" value="로그아웃"/>
					</form>
				</p>
				</section> </section>
				<section class="5u" style="float: right;">
				<h4>대기목록</h4>
				</br>
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>번호</th>
								<th>환자이름</th>
								<th>접수일시</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody id="waitList">
							<c:forEach items="${waitList}" var="waitList" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td><a class="view" preCode="${waitList.preCode}">${waitList.prescription.patName}</a></td>
									<td>${waitList.accDate}</td>
									<td><input type="button" class="button" value="승인"
										onclick="approveFunc(${waitList.preCode})" /> <input
										type="button" class="button" value="거절"
										onclick="denyFunc(${waitList.preCode})" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</section>
				<section class="5u" style="float: right;">
				<h4>승인목록</h4>
				</br>
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>번호</th>
								<th>환자이름</th>
								<th>접수일시</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody id="acceptList">
							<c:forEach items="${acceptList}" var="acceptList"
								varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td><a class="view" preCode="${acceptList.preCode}">${acceptList.prescription.patName}</a></td>
									<td>${acceptList.accDate}</td>
									<td><a href="done_add.do?preCode=${acceptList.preCode}">
											<input type="button" class="button" value="제조완료" />
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</section>
			</div>
		</div>
		<!-- /Featured -->

	</div>
	<!-- /Main -->
	<!-- The Modal -->
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<table>
				<thead>
					<tr>
						<th colspan="3">상세보기</th>
					</tr>
				</thead>
				<tbody id="detailView"></tbody>
			</table>
		</div>
	</div>

</body>
<script src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
		// Get the modal
		var modal = document.getElementById("myModal");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks the button, open the modal 
		$(function(){
			
			$("#myModal").css("display", "none");
			
			$("#waitList").on("click", $(".view"), function(event){
				$.get("today_detail.do",
						{
							"preCode" : $(event.target).attr('preCode')
						},
						details,
						"json"
				)
				.fail(function(){
					console.log("실패!");
				});
			});
			$("#acceptList").on("click", $(".view"), function(event){
				$.get("today_detail.do",
						{
							"preCode" : $(event.target).attr('preCode')
						},
						details,
						"json"
				)
				.fail(function(){
					console.log("실패!");
				});
			});
		});
		
		function details(info){
			$("#detailView").empty();
			var $type=null;
			var	$tr=$("<tr/>").append($("<td/>").append("처방전번호"))
		 	  				.append($("<td colspan='2'/>").append(info.preCode))
		 	  		.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("제조년월"))
							.append($("<td colspan='2'/>").append(info.accDate))
					.appendTo("#detailView");
			switch(info.prescription.insuranceType){
				case 1:
					$type="의료보험"
				break;
				case 2:
					$type="의료보호"
				break;
				case 3:
					$type="산제보험"
				break;
				case 4:
					$type="자동차보험"
				break;
				case 5:
					$type="기타"
				break;
			}
			var	$tr=$("<tr/>").append($("<td/>").append("보험분류"))
							.append($("<td colspan='2'/>").append($type))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("교부년월"))
							.append($("<td colspan='2'/>").append(info.prescription.issueDate))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("교부번호"))
							.append($("<td colspan='2'/>").append(info.prescription.issueNo))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("환자이름"))
							.append($("<td colspan='2'/>").append(info.prescription.patName))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("환자주민번호"))
							.append($("<td colspan='2'/>").append(info.prescription.patSocialNo))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("병원이름"))
							.append($("<td colspan='2'/>").append(info.prescription.hosName))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("병원전화번호"))
							.append($("<td colspan='2'/>").append(info.prescription.hosTel))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("의사이름"))
							.append($("<td colspan='2'/>").append(info.prescription.docName))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("의사면허번호"))
							.append($("<td colspan='2'/>").append(info.prescription.docCode))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("질병분류기호"))
							.append($("<td colspan='2'/>").append(info.prescription.sickCode))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("처방년월"))
							.append($("<td colspan='2'/>").append(info.accDate))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("유효기간"))
							.append($("<td colspan='2'/>").append(info.prescription.valDay))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("금액"))
							.append($("<td colspan='2'/>").append(info.amount))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td colspan='3'/>").append("약 정보"))
					.appendTo("#detailView");
			var	$tr=$("<tr/>").append($("<td/>").append("약이름"))
							.append($("<td/>").append("투약량"))
							.append($("<td/>").append("투약일수"))
					.appendTo("#detailView");
			console.log(info.prescription.prescriptionMedicineList);
			for(var i=0; i<info.prescription.prescriptionMedicineList.length; i++) {
				var	$tr=$("<tr/>").append($("<td/>").append(info.prescription.prescriptionMedicineList[i].medName))
						.append($("<td/>").append(info.prescription.prescriptionMedicineList[i].dosage))
						.append($("<td/>").append(info.prescription.prescriptionMedicineList[i].dosDay))
						.appendTo("#detailView");
			}
			$("#myModal").css("display", "block");
		}

		// When the user clicks on <span> (x), close the modal
 		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}  
	</script>
</html>