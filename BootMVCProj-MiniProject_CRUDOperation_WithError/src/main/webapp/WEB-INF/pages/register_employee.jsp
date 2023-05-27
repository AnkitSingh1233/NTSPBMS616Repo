<%@page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>


<frm:form modelAttribute="emp">


<table  align="center" bgcolor="cyan">
  <tr>
    <td>Employee name</td>
    <td><frm:input path="ename"/></td>
  </tr>
    
  <tr>
    <td>Employee Desig</td>
    <td><frm:input path="job"/></td>
  </tr>
  
  
  <tr>
    <td>Employee Salary</td>
    <td><frm:input path="sal"/></td>
  </tr>
  
  
  <tr>
    <td>dept no</td>
    <td><frm:input path="deptno"/></td>
  </tr>
  <tr>
    <td><input type="submit" value="submit"></td>
  <td><input type="reset" value="cancel"></td>
  
    
  </tr>
  
  
  
  
  
  
  
</table>






</frm:form>