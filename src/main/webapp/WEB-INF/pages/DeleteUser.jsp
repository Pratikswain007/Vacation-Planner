<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Booked Slot</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    body {
        background-color: #f8f9fa;
    }
    
    .container {
        max-width: 500px;
        margin: 100px auto;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        background-color: #fff;
    }

    h1 {
        font-size: 28px;
        color: #333;
        margin-bottom: 30px;
        text-align: center;
    }

    .form-label {
        font-weight: bold;
        color: #555;
    }

    .form-control {
        border-radius: 5px;
        padding: 10px;
    }

    .btn-primary {
        padding: 10px 20px;
        font-size: 16px;
        font-weight: bold;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Delete Booked Slot</h1>
        <form action="deletebyid" onsubmit="showSuccessAlert()">
            <div class="mb-3">
                <label for="id" class="form-label">Enter the id of the user:</label>
                <input type="number" id="id" name="id" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Bootstrap JS (Optional if you're not using any JS functionality) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+UO7W0Ml3MzP5miHQ7Q5U2z4tBtwbYIpe1z17nE" crossorigin="anonymous"></script>

    <script>
        function showSuccessAlert() {
            // Create a success alert element
            var successAlert = document.createElement('div');
            successAlert.classList.add('alert', 'alert-success');
            successAlert.setAttribute('role', 'alert');
            successAlert.textContent = 'User deleted successfully!';

            // Insert the alert before the form element
            var container = document.querySelector('.container');
            container.insertBefore(successAlert, container.firstChild);
        }
    </script>
</body>
</html>
