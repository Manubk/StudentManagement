
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/stylesheet.css"/>
    <title>Teacher panel</title>
</head>
<body>
   
    <h1 style="text-align: center;">Teacher Panel</h1>
    <div class="cointainer">
        <form action="" method="">

            <table >
                <thead>
                    <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Father</td>
                        <td>Gender</td>
                        <td>DOB</td>
                        <td>Phone</td>
                        <td>Email</td>
                        <td>Password</td>
                        <td>Salary</td>
                        <td>Attendance</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${teacher.getTeacher_id()}</td>
                        <td>${teacher.getName()} </td>
                        <td>${teacher.getFather() } </td>
                        <td>${teacher.getSex() } </td>
                        <td>${teacher.getDob() } </td>
                        <td>${teacher.getPhone() } </td>
                        <td>${teacher.getEmail() } </td>
                        <td>${teacher.getPass() } </td>
                        <td>${teacher.getSalary() } </td>
                        <td>${teacher.getAttendance() } </td>
                        <td><a href="/edit?id=${teacher.getTeacher_id()}}">Edit</a></td>
                    </tr>
                </tbody>
            </table>

            <input type="button" value="Edit" > 
        </form>
       
    </div>
</body>
</html>