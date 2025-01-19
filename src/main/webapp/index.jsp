<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report Issue</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container col-md-6">
		<div class="card mt-3">
			<div class="card-body">
				<form action="ReportServlet" method="Post">
					<h6 class="card-subtitle mb-2 text-muted">Issue Details</h6>
					<fieldset class="form-group">
						<label>Title</label> 
						<input type="text" class="form-control" name="title" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Location</label> 
						<input type="text" class="form-control" name="location" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Description</label> 
						<textarea class="form-control" id="description" name="description" rows="3" required="required"></textarea>
					</fieldset>
					<fieldset class="form-group">
						<label>Comment</label> 
						<textarea class="form-control" id="comment" name="comment" rows="3" required="required"></textarea>
					</fieldset>
					<h6 class="card-subtitle mb-2 mt-4 text-muted">Reporter Details</h6>
					<fieldset class="form-group">
						<label>Name</label> 
						<input type="text" class="form-control" name="name" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Email</label> 
						<input type="text" class="form-control" name="email" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Phone Number</label> 
						<input type="text" class="form-control" name="phone" required="required">
					</fieldset>
					<button type="submit" class="btn btn-success mt-3">Report Issue</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>