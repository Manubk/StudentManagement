<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
   
<div class="cointainer">
   <h1>Sign Up</h1>
    <form action="signup" class="form" method="post">
   
    <div class="cointainer-inside">
        <label>Role</label>
        <select name="role">
            <option selected>Select</option>
            <option value="teacher">Teacher</option>
            <option value="student">Student</option>
        </select>
    </div>
    <div class="cointainer-inside">
        <label>Name</label>
        <input type="text" name="name" required placeholder="Your Name">
    </div>
    <div class="cointainer-inside">
        <label>Father</label>
        <input type="text" name="father" required placeholder="Father name">
    </div>
    <div class="cointainer-inside">
        <label>Email</label>
        <input type="email" name="email" placeholder="example@email.com">
    </div>
    <div class="cointainer-inside">
        <label>Password</label>
        <input type="password" name="password">
    </div>
    <div class="cointainer-inside">
        <label>Phone</label>
        <input type="text" name="phone">
    </div>
    <div class="cointainer-inside">
        <label>DOB</label>
        <input type="date" name="dob">
    </div>
    <div class="cointainer-inside">
        <label>Sex</label>
        <input type="radio" name="sex" value="f">
        <label>F</label>
        <input type="radio" name="sex" value="m">
        <label>M</label>
    </div>
    <div class="cointainer-inside">
        <input type="submit" class="button" value="sign up">
    </div>
</form>
<a href="login.jsp">Existing User</a>
     </div>
    
</body>
</html>