<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Admin Panel</h1>
<h2>Manage Categories</h2>
<form action="admin" method="post">
    <input type="text" name="category" placeholder="New Category">
    <button type="submit" name="action" value="addCategory">Add Category</button>
</form>
<c:forEach var="category" items="${categories}">
    <form action="admin" method="post">
        <input type="hidden" name="category" value="${category}">
        <input type="text" name="newName" value="${category}">
        <button type="submit" name="action" value="editCategory">Edit</button>
        <button type="submit" name="action" value="deleteCategory">Delete</button>
    </form>
</c:forEach>

</body>
</html>
