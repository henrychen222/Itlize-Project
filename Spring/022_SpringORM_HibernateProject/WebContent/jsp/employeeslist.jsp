<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Employees List</title>
<style type="text/css">
	th {font-weight:normal;}
	.greybg {
		background-color: #F6F6F6;
		font-weight: normal;
	}
</style>
<link rel="stylesheet" type="text/css" href="/022_SpringORM_HibernateProject/js/jquery_pagination/pagination.css" />
<script type="text/javascript" src="/022_SpringORM_HibernateProject/js/jquery_pagination/jquery.js"></script>
<script type="text/javascript" src="/022_SpringORM_HibernateProject/js/jquery_pagination/jquery.pagination.js"></script>
<script type="text/javascript">
if(window.history.forward(1) != null)
   window.history.forward(1);

$(document).ready(function(){
	var total_count = document.getElementById("totalrecords").value;
	var optInit = getOptionsFromForm();
	$("#Pagination").pagination(total_count, optInit);
});
function getOptionsFromForm() {
	var opt = {callback: pageselectCallback};
	$("input:hidden").each(function(){
		opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;
	});
	return opt;
}
function pageselectCallback(page_index, jq){
	if (document.getElementById("current_page").value != page_index) {
		document.getElementById("current_page").value = page_index;
		document.getElementById("form1").action = "findEmployees.do";
		document.getElementById("form1").submit();
	}
	return false;
} 

</script>
</head>
<body>
<form:form action="/findEmployees" method="post" commandName="empForm" name="form1" id="form1">
  <h1><center>Registered Employee Details</center></h1>

<table width="100%" border="0" cellspacing="3" cellpadding="0">

<tr><td valign="top" class="">
<table id="voterList" width="100%" border="2" cellpadding="3" cellspacing="1" class="border">
<tr class="bggrey2">
	<th  nowrap="nowrap"><strong>Emp ID#</strong></th>
	<th  nowrap="nowrap"><strong>Last Name</strong></th>
	<th  nowrap="nowrap"><strong>First Name</strong></th>
	<th  nowrap="nowrap"><strong>Middle Name</strong></th>
	<th  nowrap="nowrap"><strong>Date of Birth</strong></th>
	<th  nowrap="nowrap"><strong>Address</strong></th>
	<th  nowrap="nowrap"><strong>Phone No</strong></th>
	<th  nowrap="nowrap"><strong>idUser</strong></th>
	<th  nowrap="nowrap"><strong>Registration Date</strong></th>
</tr>
<tbody>
<c:forEach var="emp" items="${empList}" varStatus="currentIndex">
<tr <c:if test="${currentIndex.index % 2 == 0}"> class="greybg" </c:if>> 
	<td align="center" nowrap="nowrap">${emp.idEmp}</td>
	<td align="left" nowrap="nowrap">${emp.nmLast}</td>
	<td align="left" nowrap="nowrap">${emp.nmFirst}</td>
	<td align="left" nowrap="nowrap">${emp.nmMid}</td>
	<td align="center" nowrap="nowrap"><fmt:formatDate pattern="MM/dd/yyyy" value="${emp.dtDob}"/></td>
	<td align="left">${emp.txAddress}</td>
	<td align="center" nowrap="nowrap">${emp.idPhone}</td>
	<td align="center" nowrap="nowrap">${emp.idUser}</td>
	<td align="center" nowrap="nowrap">${emp.tmStamp}</td>
</tr>
</c:forEach>
</tbody>
</table>
<br/>
<div id="Pagination" class="pagination" align="center"></div>
<br/>

</td></tr>
</table>

<form:hidden path="totalrecords" id="totalrecords" cssClass="numeric"/>
<form:hidden path="current_page" id="current_page" cssClass="numeric"/>
<input type="hidden" name="items_per_page" id="items_per_page" value="15" />
<input type="hidden" name="num_display_entries" id="num_display_entries" value="5" />
<input type="hidden" name="num_edge_entries" id="num_edge_entries" value="4"/>
</form:form>
</body>
</html>