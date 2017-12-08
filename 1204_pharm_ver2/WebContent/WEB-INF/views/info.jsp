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
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
</head>
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
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
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

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
<body>

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
				<li><a href="reservation_list.do">접수현황</a></li>
				<li class="active"><a href="info_list.do">처방내역</a></li>
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
				<section class="10u" style="float:right;"> <section
					class="box_period01 mtm1">
				<div class="scont">
					<form action="search.do">
						<span>이름검색</span><input type="text" name="patName" /> <span>날짜검색</span>
						<span> <input type="date" name="date1" />
						</span> <span>~</span> <span> <input type="date" name="date2" />
						</span> <span> <input type="submit" class="button" value="조회">
						</span>
					</form>
				</div>
				</section> <section>
				<h4>처방내역</h4>
				</br>
				<div class="table-wrapper">
					<table class="alt" >
						<thead>
							<tr>
								<th>번호</th>
								<th>이름</th>
								<th>금액</th>
								<th>처방일시</th>
								<th>처방전</th>
							</tr>
						</thead>
						<tbody id="btnEvent">
							<c:forEach items="${doneList}" var="doneList" varStatus="status">
								<tr>
									<td>${status.count}</td>
									<td>${doneList.prescription.patName}</td>
									<td>${doneList.amount}</td>
									<td>${doneList.accDate}</td>
									<td><input type="button"
										class="button" value="상세보기" preCode="${doneList.preCode}"/>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</section> </section>
			</div>
		</div>
		<!-- /Main Content -->
	</div>
	<!-- Main -->

	<!-- The Modal -->
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<table>
				<thead>
					<tr><th colspan="3">상세보기</th></tr>
				</thead>
				<tbody id="detailView"></tbody>
			</table>
		</div>
	</div>

	<script src="./js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		// Get the modal
		var modal = document.getElementById("myModal");
 
		// Get the button that opens the modal
		var btn = document.getElementsByClassName("detailBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks the button, open the modal 
		$(function(){
			
			$("#myModal").css("display", "none");
			
			$("#btnEvent").on("click", $(".button"), function(event){
				$.get("done_detail.do",
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
</body>
</html>