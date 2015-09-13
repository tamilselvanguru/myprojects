<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">
	
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".tabbable").find(".tab").hide();
						$(".tabbable").find(".subtab").hide();
						$(".tabbable").find(".tab").first().show();
						$(".tabbable").find(".tabs li").first().find("a")
								.addClass("active");
						$(".tabbable").find(".tabs").find("a").click(
								function() {
									var val = $(this).attr("href");
									$(".tabbable").find(".tab").hide();
									$(".tabbable").find(".subtab").hide();
									$(".tabbable").find(".tabs").find("a")
											.removeClass("active");
									$(val).show();
									$(this).addClass("active");
									return false;
								});
						$(".tabbable").find(".tab").find(".subtabs").find("a")
								.click(function() {
									$(".tabbable").find(".subtab").hide();
									var value = $(this).attr("href");

									$(value).show();

									return false;
								});
						$('#pName')
								.change(
										function() {
											//alert("change");
											$
													.ajax({
														type : 'GET',
														url : 'http://localhost:8080/PartnerConnect/group',
														data : "name="
																+ $('#pName')
																		.val(),
														dataType : 'json',
														success : function(
																result) {
															var jsonObject = jQuery
																	.parseJSON(JSON
																			.stringify(result));
															if (jsonObject.data != null) {

																$('#error')
																		.remove();
																$('#group')
																		.val(
																				jsonObject.data);
															} else {
																alert(jsonObject.emptyData);
																$('#group')
																		.val("");
																$('#error')
																		.append(
																				jsonObject.emptyData);

																$('#group')
																		.change(
																				function() {
																					$(
																							'#error')
																							.remove();
																				});
															}

														},
														error : function(xhr) {
															alert('Request Status: '
																	+ xhr.status
																	+ ' Status Text: '
																	+ xhr.statusText
																	+ ' '
																	+ xhr.responseText);
														}
													});
										});

						$("#save")
								.click(
										function() {
											$
													.ajax({
														type : 'POST',
														url : 'http://localhost:8080/PartnerConnect/addPartner',
														data : {
															partnerName : $(
																	'#pName')
																	.val(),
															group : $('#group')
																	.val(),
															streetAddress : $(
																	"#sAddress")
																	.val(),
															city : $("#city")
																	.val(),
															state : $("#state")
																	.val(),
															zipCode : $(
																	"#zcode")
																	.val(),
															id : $("#uid")
																	.val()
														},
														dataType : 'json',
														success : function(

														result) {

															var jsonObject = jQuery
																	.parseJSON(JSON
																			.stringify(result));
															if (jsonObject.partnerId != 0) {
																$("#uid")
																		.val(
																				jsonObject.partnerId);
																alert(jsonObject.partnerId);
																alert(jsonObject.message);
															} else {
																alert(jsonObject.data);
															}
														},
														async : false,
														error : function(xhr) {
															alert('Request Status: '
																	+ xhr.status
																	+ ' Status Text: '
																	+ xhr.statusText
																	+ ' '
																	+ xhr.responseText);
														}

													});
											$("#lists").remove();
											$("#section1").append(
													'<span id="lists"></span>');
											partnerList();

											$('input[type="text"]').attr(
													'readonly', true);
											$('input[type="text"]').addClass(
													'input-disabled');

										});

						$("#tab2").click(partnerList());

						function partnerList() {
							$
									.ajax({
										type : 'GET',
										url : 'http://localhost:8080/PartnerConnect/partnersList',
										dataType : 'json',
										success : function(data) {
											var jsonObject = jQuery
													.parseJSON(JSON
															.stringify(data));
											var i = 1;

											//alert(jsonObject.partner.length);
											if (jsonObject.partnerList != null) {
												$
														.each(
																jsonObject.partnerList,
																function(idx,
																		obj) {
																	//alert(this.partnerName+" increment"+i);
																	i++;

																	$("#lists")
																			.append(
																					'<a href="#" class="selectedPartner">'
																							+ this.partnerName
																							+ '</a>');
																	$("#lists")
																			.append(
																					'<br>');
																});
											} else {

												alert(jsonObject.empty);
												$('#lists').addClass(
														"emptyList");

												$(".emptyList")
														.append(
																'<p><b>'
																		+ jsonObject.empty
																		+ '</b></p>');
											}
											//alert(i);

											/* for(var obj in jsonObject.partner){
												console.log(obj.partnerName);
												alert(obj.partnerName);
											} */
											$(".selectedPartner")
													.click(
															function() {

																var partner = $(
																		this)
																		.text();
																$
																		.ajax({

																			type : 'GET',
																			url : 'http://localhost:8080/PartnerConnect/getPartner',
																			data : "name="
																					+ partner,
																			dataType : 'json',
																			success : function(
																					result) {
																				var jsonObject = jQuery
																						.parseJSON(JSON
																								.stringify(result));
																				$(
																						'#pName')
																						.val(
																								jsonObject.partner.partnerName);
																				$(
																						'#group')
																						.val(
																								jsonObject.partner.group);
																				$(
																						"#sAddress")
																						.val(
																								jsonObject.partner.streetAddress);
																				$(
																						"#city")
																						.val(
																								jsonObject.partner.city);
																				$(
																						"#state")
																						.val(
																								jsonObject.partner.state);
																				$(
																						"#zcode")
																						.val(
																								jsonObject.partner.zipCode);
																				$(
																						"#uid")
																						.val(
																								jsonObject.partner.id);

																			},
																			error : function(
																					xhr) {
																				alert('Request Status: '
																						+ xhr.status
																						+ ' Status Text: '
																						+ xhr.statusText
																						+ ' '
																						+ xhr.responseText);
																			}

																		});
															});

										},
										error : function(xhr) {
											alert('Request Status: '
													+ xhr.status
													+ ' Status Text: '
													+ xhr.statusText + ' '
													+ xhr.responseText);
										}

									});
						}

						$("#add").click(function() {

							clearTextfields();

						});

						$("#clear").click(function() {
							clearTextfields();

						});
						function clearTextfields() {
							$('input[type="text"]').removeClass(
									'input-disabled');
							$('input[type="text"]').attr('readonly', false);
							$("input[class='fields']").val("");

						}
						$("#pName").focusout(function() {
							if (!$(this).val()) {
								alert("This field is required");
								$(this).focus();
							}
						});

						$("#delete")
								.click(
										function() {
											$
													.ajax({
														type : 'POST',
														url : 'http://localhost:8080/PartnerConnect/deletePartner',
														data : "uid="
																+ $("#uid")
																		.val(),

														dataType : 'json',
														success : function(

														result) {
															alert(JSON
																	.stringify(result.data));
															$("#lists")
																	.remove();
															$("#section1")
																	.append(
																			'<span id="lists"></span>');
															partnerList();
														},
														error : function(xhr) {
															alert('Request Status: '
																	+ xhr.status
																	+ ' Status Text: '
																	+ xhr.statusText
																	+ ' '
																	+ xhr.responseText);
														}

													});

										});

					});
</script>
<style type="text/css">
.error {
	color: red;
}

* {
	font-family: 'Segoe UI';
}

.tabbable .tabs {
	list-style: none;
	margin: 0 10px;
	padding: 0;
}

.tabbable .tabs li {
	list-style: none;
	margin: 0;
	padding: 0;
	display: inline-block;
	position: relative;
	z-index: 1;
	margin: 0;
}

.tabbable .tabs li a {
	text-decoration: none;
	color: #000;
	border: 1px solid #ccc;
	padding: 5px;
	display: inline-block;
	border-radius: 5px 5px 0 0;
	background: #f5f5f5;
}

.tabbable .tabs li a.active,.tabbable .tabs li a:hover {
	border-bottom-color: #fff;
	background: #fff;
}

.tabcontent {
	border: 1px solid #ccc;
	margin-top: -1px;
	padding: 10px;
}

#section1 {
	display: inline-block;
	width: 300px;
	display: table-cell;
	border: 1px solid green;
}

#section2 {
	vertical-align: top;
	display: inline-block;
	display: table-cell;
	width: 400px;
	border: 1px solid blue;
}

}
.input-disabled {
	background-color: #EBEBE4;
	border: 1px solid #ABADB3;
	padding: 2px 1px;
}
</style>
</head>
<body>
	<!--  Welcome ${user.firstName} ${user.lastName } -->
	<div class="tabbable">
		<ul class="tabs">
			<li><a href="#tab1">Inbox</a></li>
			<li><a href="#tab2">Partner</a></li>
			<li><a href="#tab3">FT</a></li>
		</ul>
		<div class="tabcontent">
			<div id="tab1" class="tab">
				<ul class="subtabs">
					<li><a href="#critical">Critical</a></li>
					<li><a href="#action">Action</a></li>
					<li><a href="#info">Info</a></li>
				</ul>

			</div>
			<div id="critical" class="subtab">

				<table border="2" id="usersTable">
					<thead>
						<tr>
							<th>Subject</th>

							<th>Message</th>
						</tr>
					</thead>
					<tbody id="bodyTable">
						<tr>
							<td><a href="sap">sapsystem@sap.com</a></td>
							<td>files uploaded</td>
						</tr>
						<tr>
							<td><a href="hr">emailhrteam@hr.com</a></td>
							<td>files not uploaded</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="tab2" class="tab">

				<div id="section1">
					<input type="image" id="add" src="resources/add.jpg" alt="Submit"
						width="30" height="30">
					<h1>
						<font size="2" color="orange"> Partners List</font>
					</h1>
					<span id="lists"></span>
				</div>

				<div id="section2" class="section2">
					<form id="addPartner">
						<table>
							<tr>
								<td>PartnerName:</td>
								<td><input type="text" name="partnerName" id="pName"
									class="fields"></td>
							</tr>
							<tr>
								<td>Group:</td>
								<td><input type="text" name="group" id="group"
									class="fields">
									<div id="error" class="error"></div></td>
							</tr>
							<tr>
								<td>Address:
							<tr>
								<td>Street Address:</td>
								<td><input type="text" name="streetAddress" id="sAddress"
									class="fields"></td>
							</tr>
							<tr>
								<td>City:</td>
								<td><input type="text" name="city" id="city" class="fields"></td>
							</tr>
							<tr>
								<td>State:</td>
								<td><input type="text" name="state" id="state"
									class="fields"></td>
							</tr>
							<tr>
								<td>Zipcode:</td>
								<td><input type="text" name="zipCode" id="zcode"
									class="fields"></td>
							</tr>
							<tr>
								<td><input type="hidden" name="uid" class="fields" id="uid" />
							<tr>
								<td><input type="submit" onClick="return false"
									value="Save" align="right" id="save"></td>
							</tr>
							<tr>

								<td><input type="button" value="Delete" align="middle"
									id="delete"></td>
							</tr>
							<tr>
								<td><input type="button" value="Clear" align="left"
									id="clear"></td>
							</tr>
						</table>

					</form>
				</div>
			</div>
		</div>
		<div id="tab3" class="tab">cat</div>
	</div>

</body>
</html>