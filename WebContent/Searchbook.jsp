<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search your book</title>
</head>
<body>

	<form action="Search" style="align: center">
		<p align="center">
			<b>Search Books Here</b>
		</p>
		<hr />
		<div align="center">
			<table>
				<tr>

					<td>Subjects Wise</td>
					<td><select name="subjectBook">
							<option>java</option>
							<option>.net</option>
							<option>oracle</option>
							<option>Cs</option>
					</select>
				</tr>
				<tr>
					<td><input type="submit" name="Search" value="Search"></td>
				</tr>
			</table>
		</div>
		<hr>
	</form>
</body>
</html>