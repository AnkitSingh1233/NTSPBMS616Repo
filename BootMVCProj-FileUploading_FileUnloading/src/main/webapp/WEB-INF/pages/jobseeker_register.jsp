<%@ page language="java" isELIgnored="false"%>



<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<frm:form modelAttribute="js" enctype="multipart/form-data">




	<table bgcolor="cyan" align="center" border="0">


		<tr>
			<td>Name</td>
			<td><frm:input path="jsName" /></td>



		</tr>


		<tr>
			<td>Address</td>
			<td><frm:input path="jsAddrs" /></td>



		</tr>
		<tr>
			<td>Resume</td>
			<td><frm:input type="file" path="resume" /></td>



		</tr>



		<tr>
			<td>Photo</td>
			<td><frm:input type="file" path="photo" /></td>



		</tr>


    <tr>
       <td><input type="submit" value="register"></td>
    </tr>






	</table>






</frm:form>
