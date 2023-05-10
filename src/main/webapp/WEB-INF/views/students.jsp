<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/9/2023
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><%= "Hello World!" %></h1>

<a href="<%=request.getContextPath()%>/studentController/Add">Create Student</a>
    <table border="1" cellpadding="5" cellspacing="0">
       <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AGE</th>
                <th>SEX</th>
                <th>ADDRESS</th>
                <th colspan="2">ACTION</th>
            </tr>
       </thead>
        <tbody>
            <c:forEach items="${list_student}" var = "st">
                <tr>
                    <td>${st.id}</td>
                    <td>${st.name}</td>
                    <td>${st.age}</td>
                    <td>${st.sex?"Nam": "Nữ"}</td>
                    <td>${st.address}</td>
                    <td>
                        <button>Edit</button>
                    </td>
                    <td>
                        <button>Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
