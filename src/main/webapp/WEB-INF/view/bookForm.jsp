<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sathira
  Date: 09/03/2023
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<c:set var="type" value="${book.bookID == 0 ? 'Add New Book' : 'Edit Book'}" />


<head>
    <title>${type}</title>
</head>
<body>
<h1 style="text-align: center">${type}</h1>

<form:form action="saveBook" method="post" modelAttribute="book"><%--this model  attribute is only mapped there with @MedelAttribute Book book in saveBook--%>
    <table align="center">
        <form:hidden path="ISBN"/>
        <tr>
            <td>
                <form:label path="bName">Book Name</form:label>
            </td>
            <td>
                <form:input path="bName" required="true"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="copies">Number of copies</form:label>
            </td>
            <td>
                <form:input path="copies" required="true"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center" style="padding: 30px">
                <input type="submit" style="width: 100%" value="${type}"/>
            </td>

        </tr>
    </table>
</form:form>

</body>
</html>
