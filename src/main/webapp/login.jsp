<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>sign in</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
    <div class="cointainer">
    <h1>Sign In </h1>
        <form action="login" method="post">
            <div class="cointainer-inside">
                <label>Role</label>
                <select name="role">
                    <option selected>Select</option>
                    <option value="teacher">Teacher</option>
                    <option value="student">Student</option>
                </select>
            </div>
            <div class="cointainer-inside">
                <label>Email :</label>
                <input type="email" name="email">
            </div>
            <div class="cointainer-inside">
                <label>password</label>
                <input type="password" name="password">
            </div>
            <div class="button">
                <input type="submit" value="sign in">
            </div>
        </form>
        <label>or</label>
        <a href="signup.jsp">I am new User</a>

    </div>    
</body>
</html>