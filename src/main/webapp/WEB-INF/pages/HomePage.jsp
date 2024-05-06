<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
body {
	background-image:
		url('https://cdn.pixabay.com/photo/2015/01/13/13/21/paradise-598201_640.jpg');
	background-size: cover;
	background-repeat: no-repeat;
}

.navbar-nav .nav-item:not(:first-child) .nav-link:hover {
	color: #fff; 
}
</style>
<title>Book-Home</title>
</head>
<body>
	<center>
		<h2>Vacation Planner</h2>
	</center>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">VP</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="add">Add</a></li>
					<li class="nav-item"><a class="nav-link" href="updateform">Update</a></li>
					<li class="nav-item"><a class="nav-link" href="delete">Delete</a></li>
					<li class="nav-item"><a class="nav-link" href="getById">GetById</a></li>
					<li class="nav-item"><a class="nav-link" href="getAll">ShowAll</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
