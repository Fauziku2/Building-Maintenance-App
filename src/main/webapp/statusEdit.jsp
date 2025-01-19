<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Set Status</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
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
				<form action="setStatus" method="post">
					<caption>
						<h2>Status</h2>
					</caption>
					<c:if test="${issue != null}">
						<input type="hidden" name="title"
							value="<c:out value='${issue.title}' />" />
					</c:if>
					<fieldset class="form-group">
						<label for="assignOptions">Status</label> <select
							class="form-control" id="assignOptions" name="status">
							<option value="Not Started">Not Started</option>
							<option value="In Progress">In Progress</option>
							<option value="Completed">Completed</option>
						</select>
					</fieldset>
					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>