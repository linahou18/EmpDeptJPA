<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.elements.lina.Employee" %>
<html>
<body>
Hello, ${username}&nbsp

<form action="LogOutServlet" method = "GET">

<input type = "submit" value = "Log Out" />

</form>

<h1>Add Employees</h1>

<form action="AddEmpServlet" method = "GET">

    First Name: <input type = "text" name = "firstname" />
    <br/><br/>
    Last Name: <input type = "text" name = "lastname" />
    <br/><br/>
    Age: <input type = "text" name = "age" />
    <br/><br/>
    
    <select id="deptSelect" name="deptSelect">
       <c:forEach var="dept" items="${departments}">
        <option value = "${dept.getId()}"><c:out value="${dept.getName()}"/></option>
       </c:forEach>
    </select>
    
    <br/><br/>
    <input type = "submit" value = "Submit" />

</form>

<a href="hello.jsp">Back</a>

<br/> <br/>
Existing Employees:
<br/><br/>

<table>
   <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
      <th>Department</th>
   </tr>

	<c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.getFirstName()}</td>
            <td>${emp.getLastName()}
            <td>${emp.getAge()}</td>
            <td>${emp.getDepartment().getName()}</td>
        </tr>
	</c:forEach>

</table>

</body>

</html>