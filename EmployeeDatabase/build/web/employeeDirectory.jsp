<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ejd.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJD Employee Directory</title>
        <link href="css.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1>EJD Corp. Employee Directory</h1>

        <p>Enter a full or partial first name to search <u>employee.</u></p>

       
        <form action="EmployeeDirectory" method="GET" >
            First Name: <input type="text" name="firstName"/>
            <input type="submit" value="Search"/> 
        </form>

        <!-- Test if employee arraylist is empty or null-->
        <br><br><br>
         <div id="wrapper">
        <c:if test="${!empty employees}">
            
            <p>Here is a list of employees matching your search.</p>
            
            <c:forEach var="employee" items="${employees}">
                <table>

                    <tr>
                        <th>ID</th>
                        <th>FIRST NAME</th>
                        <th>LAST NAME</th>
                        <TH>DEPARTMENT</TH>
                        <th>SALARY</th>
                    </tr>

                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.department}</td>
                        <td>${employee.salary}</td>
                    </tr>
                    
                </c:forEach>
            </table>
        </c:if>
        </div>
    </body>
</html>