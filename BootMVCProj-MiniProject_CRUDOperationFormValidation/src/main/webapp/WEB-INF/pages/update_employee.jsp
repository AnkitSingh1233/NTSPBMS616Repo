<%@ page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<link rel="stylesheet" type="text/css" href="css/style.css">

<script language="javaScript" src="js/validation.js">

</script>

<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">





<%-- <p style="color: red;text-align: center">
<frm:errors path="*"/>

</p>

 --%>
<table align="center" bgcolor="cyan">

<tr>
<td>Employee Number::</td>
<td><frm:input path="empno" readonly="true"/></td>

</tr>
<tr>
<td>Employee Name::</td>
<td><frm:input path="ename"/><frm:errors path="ename"/><span id="enameErr"></span></td>

</tr>
<tr>
<td>Employee job::</td>
<td><frm:input path="job"/><frm:errors path="job"/><span id="jobErr"></span></td>

</tr>
<tr>
<td>Employee salary::</td>
<td><frm:input path="sal"/><frm:errors path="sal"/><span id="salErr"></span></td>

</tr>
<tr>
<td>Employee deptno::</td>
<td><frm:input path="deptno"/><frm:errors path="deptno"/><span id="deptnoErr"></span></td>

</tr>
<tr>
<td><input type="submit" value="update Employee"></td>
<td><input type="reset" value="cancel"></td>

</tr>

</table>







</frm:form>
