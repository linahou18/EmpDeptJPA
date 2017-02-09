<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<body>

  
   Hello, ${username}<br/><br/>

   <form action="LogOutServlet" method = "GET">

    <input type = "submit" value = "Log Out" />
    
    <br/><br/>
    
    <!-- <a href="addEmp.jsp">Add Employee</a>
    
    <br/>
    
    <a href="addDept.jsp">Add Department</a> -->
   </form>
   
   <form action="ShowDeptServlet" method = "GET">
   
     <input type = "submit" value = "Add Deptment" />
   
   </form>
   
   <br/><br/>
   
   <form action="ShowEmpServlet" method = "GET">
   
     <input type = "submit" value = "Add Employee" />
   
   </form>
   

</body>

</html>