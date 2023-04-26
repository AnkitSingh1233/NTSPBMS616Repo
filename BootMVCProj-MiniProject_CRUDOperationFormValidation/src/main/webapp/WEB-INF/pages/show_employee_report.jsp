<%@ page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
  <c:when test="${!empty empsList}">
  <h1 style="color:red;text-align: center;">Employee Report</h1>
  
    <table bgcolor="cyan" border="1" align="center">
    
      <tr style="color: red"><td>emp no</td><td>emp name</td><td>emp job</td><td>emp salary</td> <td>emp deptno</td><td>operation</td></tr>
    
       <c:forEach var="emp" items="${empsList}">
       <tr style="color:blue">
         <td>${emp.empno}</td>
         <td>${emp.ename}</td>
         <td>${emp.job}</td>
         <td>${emp.sal}</td>
         <td>${emp.deptno}</td>
         
         
         
         <td><a href="emp_edit?no=${emp.empno}">edit</a>
         <a href="emp_delete?no=${emp.empno}"
         onclick="return confirm('do you want to delete the employee')"
         
         >delete</a></td>
       </tr>
       
       
       
       
       </c:forEach>
    
    </table>
  
  
  </c:when>

  <c:otherwise>
  
  <h1 style="color: red;text-align: center">Employee Not Found</h1>
  </c:otherwise>



</c:choose>

<h2 style="color: blue;text-align: center">${resultMsg}</h2>

<center>

<a href="emp_add">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="./">Home</a>

</center>








