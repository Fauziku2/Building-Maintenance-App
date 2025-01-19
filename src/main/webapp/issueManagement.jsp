<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Issues</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Issues</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>"
					class="btn btn-success">Add New Issue</a>
			</div>
			<br>

			<c:forEach var="issue" items="${listIssues}">
				<div class="card mt-2 mb-3">
					<div class="card-body">
						<h6 class="card-subtitle mb-2 text-muted">
							<u>Issue Details</u>
						</h6>
						<div>
							<strong>Title:</strong> <span><c:out value="${issue.title}" /></span>
						</div>
						<div>
							<strong>Location:</strong> <span><c:out value="${issue.location}" /></span>
						</div>
						<div>
							<strong>Description:</strong> <span><c:out value="${issue.description}" /></span>
						</div>
						<div>
							<strong>Comment:</strong> <span><c:out value="${issue.comment}" /></span>
						</div>	
						<h6 class="card-subtitle mb-2 mt-3 text-muted">
							<u>Reporter Details</u>
						</h6>
						<div>
							<strong>Name:</strong> <span><c:out value="${issue.name}" /></span>
						</div>	
						<div>
							<strong>Email:</strong> <span><c:out value="${issue.email}" /></span>
						</div>
						<div>
							<strong>Phone:</strong> <span><c:out value="${issue.phone}" /></span>
						</div>
						<h6 class="card-subtitle mb-2 mt-3 text-muted">
							<u>Job Status</u>
						</h6>
						<div>
							<strong>Priority:</strong> <span><c:out value="${issue.priority}" /></span>
						</div>	
						<div>
							<strong>Assign:</strong> <span><c:out value="${issue.assign}" /></span>
						</div>
						<div>
							<strong>Status:</strong> <span><c:out value="${issue.status}" /></span>
						</div>
						<div class="mt-3">
							<a class="btn btn-primary btn-sm" href="edit?title=<c:out value='${issue.title}'/>" role="button">Edit</a>
							<a class="btn btn-danger btn-sm" href="delete?title=<c:out value='${issue.title}'/>" role="button">Delete</a>
							<a class="btn btn-secondary btn-sm" href="priority?title=<c:out value='${issue.title}'/>" role="button">Priority</a>
							<a class="btn btn-info btn-sm" href="assign?title=<c:out value='${issue.title}'/>" role="button">Assign</a>
							<a class="btn btn-dark btn-sm" href="status?title=<c:out value='${issue.title}'/>" role="button">Status</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>