<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Issue Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand">Issue Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/IssueServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${!empty issue.title}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${empty issue.title}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${!empty issue.title}">Edit Issue</c:if>
						<c:if test="${empty issue.title}">Add New Issue</c:if>
					</h2>
				</caption>
				<c:if test="${issue != null}">
					<input type="hidden" name="oriTitle"
						value="<c:out value='${issue.title}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Issue Title</label> <input type="text"
						value="<c:out value='${issue.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Location</label> <input type="text"
						value="<c:out value='${issue.location}' />" class="form-control"
						name="location">
				</fieldset>
				<fieldset class="form-group">
					<label>Description</label>
					<textarea class="form-control" rows="3" name="description">${issue.description}</textarea>
				</fieldset>
				<fieldset class="form-group">
					<label>Comment</label>
					<textarea class="form-control" rows="3" name="comment">${issue.comment}</textarea>
				</fieldset>
				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${issue.name}' />" class="form-control"
						name="name">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${issue.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${issue.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>