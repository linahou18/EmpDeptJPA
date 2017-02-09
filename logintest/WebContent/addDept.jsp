<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.elements.lina.Employee" %>
<%@ page import = "com.elements.lina.Department" %>
<html>

<body>
Hello, ${username} &nbsp
<form action="LogOutServlet" method = "GET">
    <input type = "submit" value = "Log Out" />
</form>
<h1>Add Department</h1>

<form action="AddDeptServlet" method = "GET">

    Deparment Name: <input type = "text" name = "deptname" />
    <br/><br/>
    Deparment Email: <input type = "text" name = "deptemail" />
    <br/><br/>
    
    <br/>
    <input type = "submit" value = "Submit" />

</form>

<a href="hello.jsp">Back</a>
<br/><br/>
Existing Department <br/>


<table>
   <tr>
      <th>Dept Name</th>
      <th>Dept Email</th>
      <th>Employee</th>
   </tr>
   
    <c:forEach items="${departments}" var="dept">
      		<c:if test="${not empty dept.getEmployeeList()}">
      		  <c:forEach items = "${dept.getEmployeeList()}" var = "emp">
		       		<tr>
		             <td>${dept.getName()}</td>
		             <td>${dept.getEmail()}</td>
		             <td>${emp.getLastName()} &nbsp ${emp.getFirstName()} 
		            </tr>
      		  </c:forEach>
      		</c:if>
       		
       		<c:if test="${empty dept.getEmployeeList()}">
       				<tr>
		             <td>${dept.getName()}</td>
		             <td>${dept.getEmail()}</td>
              	    </tr>
       		</c:if>
    </c:forEach>
</table>

</body>

</html>